package com.nttdata.proyecto.BankProduct.domain.dto.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.proyecto.BankProduct.application.dto.request.BankProductRequest;
import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Service.BankProductService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
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
@RequestMapping("/BankProduct")
public class BankProductController {
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
    // Service for managing operations related to bank products
    @Autowired
    private BankProductService bankProductService;
    // Endpoint to register a new bank product
    @PostMapping(value="/register")
    public ResponseEntity<BankProductEntity> register(@Valid @RequestBody BankProductRequest bankProduct, BindingResult result) {
        if(result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
        }

        BankProductEntity bankProductEntity = BankProductEntity.builder()
                .typePB(bankProduct.getTypePB())
                .balance(bankProduct.getBalance())
                .build();
        BankProductEntity bankcreate = bankProductService.create(bankProductEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(bankcreate);
    }
    // Endpoint to obtain all bank product
    @GetMapping
    public ResponseEntity<List<BankProductEntity>> getAll() {
        List<BankProductEntity> list = bankProductService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    // Endpoint to obtain a bank product by its type produc bank
    @GetMapping(value = "/{typePB}")
    public ResponseEntity<BankProductEntity> getByTypePB(@PathVariable("typePB") String typePB) {
        return Optional.ofNullable(bankProductService.findByTypePB(typePB))
                .map(bankProductEntity -> ResponseEntity.status(HttpStatus.OK).body(bankProductEntity))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
    // Endpoint to update a bank product
    @PutMapping(value = "/{id}")
    public ResponseEntity<BankProductEntity> update(@PathVariable("id") Long id, @RequestBody BankProductEntity bankProduct) {
        bankProduct.setId(id);
        return Optional.ofNullable(bankProductService.update(bankProduct))
                .map(updatedEntity -> ResponseEntity.status(HttpStatus.OK).body(updatedEntity))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Endpoint to delete a bank product
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BankProductEntity> delete(@PathVariable("id") Long id) {
        return Optional.ofNullable(bankProductService.delete(id))
                .map(deletedEntity -> ResponseEntity.status(HttpStatus.OK).body(deletedEntity))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
