package com.nttdata.proyecto.customer.application.service.Impl;

import com.nttdata.proyecto.customer.application.service.CustomerExternalService;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import com.nttdata.proyecto.customer.domain.dto.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerExternalServiceImpl implements CustomerExternalService {
    private final CustomerService customerService;

    @Override
    public List<Customer> listCustomer() {
        return customerService.listCustomer();
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
