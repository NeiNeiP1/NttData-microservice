package com.nttdata.proyecto.customer.application.service;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerExternalService {
    List<Customer> listCustomer();
    List<CustomerEntity> getAllCustomers();

}
