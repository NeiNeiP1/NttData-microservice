package com.nttdata.proyecto.customer.domain.dto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.proyecto.customer.application.dto.request.CustomerRequest;
import com.nttdata.proyecto.customer.application.dto.response.CustomerResponse;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

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

    //Client service that saves create, modify, find, and delete functions
    @Autowired
    private CustomerService customer2;



    @PostMapping(value= "/register")
    public ResponseEntity<CustomerResponse> saveCustomer(@Valid @RequestBody CustomerRequest customerRequest){


        //Guardado del Cliente
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CustomerResponse.builder()
                        .code("201")
                        .message("Customer created with exit")
                        .build()
        );
    }
    //Returns a complete or filtered list of registered customers by their id.
    @GetMapping("/customerList")
    public ResponseEntity<List<CustomerEntity>> listCustomers(Long tipoId) {

        return ResponseEntity.status(HttpStatus.CREATED).body(
                customer2.listAllCustomer()
        );
    }

}
