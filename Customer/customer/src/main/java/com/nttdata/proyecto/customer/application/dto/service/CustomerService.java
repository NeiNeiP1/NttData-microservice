package com.nttdata.proyecto.customer.application.dto.service;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;

import java.util.List;

public interface CustomerService {
    public List<CustomerEntity> listAllCustomer();
    public CustomerEntity getCustomer (Long id);
    public CustomerEntity createCustomer (CustomerEntity customer);
    public CustomerEntity updateCustomer (CustomerEntity customer);
    public CustomerEntity deleteCustomer (CustomerEntity customer);
    public List<CustomerEntity> findByCustomerType(CustomerType customerType);
    public CustomerEntity updateStock(Long id, Double quantity);
}
