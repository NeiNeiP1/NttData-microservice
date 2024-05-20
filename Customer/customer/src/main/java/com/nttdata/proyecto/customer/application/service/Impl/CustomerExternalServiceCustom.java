package com.nttdata.proyecto.customer.application.service.Impl;

import com.nttdata.proyecto.customer.application.service.CustomerExternalService;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerExternalServiceCustom  implements com.nttdata.proyecto.customer.application.service.CustomerExternalServiceCustom {

    private final CustomerExternalService customerExternalService;

    @Override
    public List<Customer> listCustomerModel() {
        return customerExternalService.listCustomerModel();
    }

    @Override
    public Customer saveCustomerModel(Customer customerModels) {
        return customerExternalService.saveCustomerModel(customerModels);
    }

    @Override
    public Customer updateCustomerModel(Customer customerModels) {
        return customerExternalService.updateCustomerModel(customerModels);
    }
}
