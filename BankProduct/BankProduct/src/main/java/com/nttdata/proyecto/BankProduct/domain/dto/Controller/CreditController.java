package com.nttdata.proyecto.BankProduct.domain.dto.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.proyecto.BankProduct.domain.dto.Entity.CreditEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Service.CreditService;
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
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/Credit")
public class CreditController {
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
    private CreditService creditService;

    @PostMapping(value = "/register")
    public ResponseEntity<CreditEntity> register(@Valid @RequestBody CreditEntity credit, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
        }
        CreditEntity creditentity=CreditEntity.builder()
                .numCredit(credit.getNumCredit())
                .limit(credit.getLimit())
                .interest(credit.getInterest())
                .build();
        CreditEntity creditEntity=creditService.save(creditentity);
        return ResponseEntity.status(HttpStatus.CREATED).body(creditEntity);
    }

    @GetMapping
    public ResponseEntity<List<CreditEntity>> findAll() {
        List<CreditEntity> list = creditService.findAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

}
