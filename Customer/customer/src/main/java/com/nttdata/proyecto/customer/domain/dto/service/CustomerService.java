package com.nttdata.proyecto.customer.domain.dto.service;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;

import java.util.List;
public interface CustomerService {

    public List<CustomerEntity> getAllCustomers();
    public List<Customer> listCustomer();
    public CustomerEntity getCustomer (Long id);
    public CustomerEntity createCustomer (CustomerEntity customer);
    public CustomerEntity updateCustomer (CustomerEntity customer);
    public CustomerEntity deleteCustomer (Long id);
    public List<CustomerEntity> findByCustomerType(CustomerType customerType);
    public CustomerEntity findByDoc(String doc);

}
