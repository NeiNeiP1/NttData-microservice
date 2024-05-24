package com.nttdata.proyecto.BankProduct.domain.dto.Controller;

import com.nttdata.proyecto.BankProduct.domain.dto.Model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customers")
public interface CustomerProduct {
    @GetMapping(value = "/{doc}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("doc") String document);
}
