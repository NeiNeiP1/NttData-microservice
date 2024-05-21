package com.nttdata.proyecto.customer.application.service;

import com.nttdata.proyecto.customer.domain.dto.model.Customer;

import java.util.List;

public interface CustomerExternalServiceCustom {
    List<Customer> listCustomerModel();

    Customer saveCustomerModel(Customer customerModels);

    Customer updateCustomerModel(Customer customerModels);
}
