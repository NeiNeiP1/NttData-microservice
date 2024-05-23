package com.nttdata.proyecto.customer.application.service.Impl;

import com.nttdata.proyecto.customer.application.service.CustomerExternalService;
import com.nttdata.proyecto.customer.application.service.CustomerExternalServiceCustom;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerExternalServiceCustomImpl implements CustomerExternalServiceCustom {

    private final CustomerExternalService customerExternalService;

    @Override
    public List<Customer> listCustomer() {
        return customerExternalService.listCustomer();
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerExternalService.getAllCustomers();
    }


}
