package com.nttdata.proyecto.customer.application.service;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;

import java.util.List;

public interface CustomerExternalServiceCustom {
    List<Customer> listCustomer();
    List<CustomerEntity> getAllCustomers();

}
