package com.nttdata.proyecto.customer.application.service.Impl;

import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import com.nttdata.proyecto.customer.domain.dto.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerExternalService implements com.nttdata.proyecto.customer.application.service.CustomerExternalService {
    private final CustomerService customerService;

    @Override
    public List<Customer> listCustomerModel() {
        return customerService.listAllCustomer();
    }

    @Override
    public Customer saveCustomerModel(Customer customerModels) {
        return customerService.saveCustomerModel(customerModels);
    }

    @Override
    public Customer updateCustomerModel(Customer customerModels) {
        return customerService.updateCustomerModel(customerModels);
    }
}
