package com.nttdata.proyecto.customer.domain.dto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.proyecto.customer.application.dto.request.CustomerRequest;
import com.nttdata.proyecto.customer.application.dto.response.CustomerResponse;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.entity.TypeDocEntity;
import com.nttdata.proyecto.customer.domain.dto.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;
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
    private CustomerService customerService;



    @PostMapping(value= "/register")
    public ResponseEntity<CustomerEntity> saveCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(customerRequest.getName())
                .doc(customerRequest.getDoc())
                .typeDoc(TypeDocEntity.builder().id(customerRequest.getTypeDoc()).build())  // Solo pasar el ID
                .status(customerRequest.getStatus())
                .location(customerRequest.getLocation())
                .phonenumber(customerRequest.getPhonenumber())
                .email(customerRequest.getEmail())
                .customerType(CustomerType.builder().id(customerRequest.getTypeCustomer()).build()) // Solo pasar el ID
                .build();
        CustomerEntity customerCreate =  customerService.createCustomer(customerEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
        /**Guardado del Cliente
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CustomerResponse.builder()
                        .code("201")
                        .message("Customer created with exit")
                        .build()
        );
         **/
    }

    //Returns a complete or filtered list of registered customers by their id.
    @GetMapping
    public ResponseEntity<List<CustomerEntity>> listCustomers( @RequestParam(name="customertype_id",required = false) Long customertype_id) {
        List<CustomerEntity> customers;
        if(Optional.ofNullable(customertype_id).isEmpty()){
            customers=customerService.listAllCustomer();
        }else{
            customers=customerService.findByCustomerType(
                    CustomerType.builder().id(customertype_id).build());
        }
        System.out.println("List of customers: " + customers);
        return ResponseEntity.ok(customers);
    }
    @GetMapping(value = "/{doc}")
    public ResponseEntity<CustomerEntity> getCustomer(@PathVariable("doc") String document) {
        CustomerEntity customer =  customerService.findByDoc(document);
        System.out.println("Customer found: " + customer);
        if (Optional.ofNullable(customer).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }


}
