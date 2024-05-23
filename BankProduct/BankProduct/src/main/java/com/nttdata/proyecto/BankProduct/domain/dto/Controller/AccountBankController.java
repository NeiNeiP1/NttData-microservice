package com.nttdata.proyecto.BankProduct.domain.dto.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.proyecto.BankProduct.application.dto.request.AccountBankRequest;
import com.nttdata.proyecto.BankProduct.application.dto.request.BankProductRequest;
import com.nttdata.proyecto.BankProduct.domain.dto.Entity.AccountBankEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Service.AccountBankService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/AccountBank")
public class AccountBankController {
    //formatMessage is a function that is responsible for creating a list of errors
    //that facilitates the validation of the Request Body.

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .message(errors)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;

    }
    @Autowired
    private AccountBankService accountBankService;

    @PostMapping(value="/register")
    public ResponseEntity<AccountBankEntity> register(@Valid @RequestBody AccountBankRequest accountBankRequest, BindingResult result) {
        if(result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
        }
        AccountBankEntity accountBankEntity= AccountBankEntity.builder()
                .accountNumber(accountBankRequest.getAccountNumber())
                .comission(accountBankRequest.getComission())
                .typeAccount(accountBankRequest.getTypeAccount())
                .limitMovement(accountBankRequest.getLimitMovement())
                .dateMovement(accountBankRequest.getDateMovement())
                .build();
        AccountBankEntity accountcreate = accountBankService.create(accountBankEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountcreate);
    }
    @GetMapping
    public ResponseEntity<List<AccountBankEntity>> getAll(){
        List<AccountBankEntity> list=accountBankService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping(value="/{accountNumber}")
    public ResponseEntity<AccountBankEntity> getByAccountNumber(@PathVariable("accountNumber") String accountNumber){
        AccountBankEntity accountBankEntity = accountBankService.findByAccountNumber(accountNumber);
        if(Optional.ofNullable(accountBankEntity).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountBankEntity);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountBankEntity> update(@PathVariable("id") Long id, @RequestBody AccountBankEntity accountBankEntity){
        accountBankEntity.setId(id);
        AccountBankEntity accountBankEntity1 = accountBankService.update(accountBankEntity);
        if(accountBankEntity1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountBankEntity1);
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<AccountBankEntity> delete(@PathVariable("id") Long id){
        AccountBankEntity accountBankEntity=accountBankService.delete(id);
        if(accountBankEntity == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(accountBankEntity);
    }
}
