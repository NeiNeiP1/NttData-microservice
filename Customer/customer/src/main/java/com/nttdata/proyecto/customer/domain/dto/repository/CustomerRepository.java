package com.nttdata.proyecto.customer.domain.dto.repository;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Customer Repository with search functions

import java.util.List;
import java.util.Optional;

//Para paginar y generar automaticamente los query

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {


    List<Customer> listCustomer();
    // search for a Customer by its type. @return CustomerList

    public List<CustomerEntity> findByCustomerType(CustomerType customerType);

    // search for a Customer by name. @return Customer
    public List<CustomerEntity> findByName(String name);

    // search for a Customer by document code. @return Customer
    public CustomerEntity findByDoc(String doc);

    // search for a Customer by document code. @return CustomerList
    public List<CustomerEntity> findByLocation(String location);

    // search for a customer by phonenumber. @return Customer
    public CustomerEntity findByPhonenumber(String phonenumber);

    // search for a customer by email. @return Customer
    public CustomerEntity findByEmail(String email);


    public Optional<CustomerEntity> findById(Long id);
    Customer saveCustomer( Customer customerModel );

    Customer updateCustomer( Customer customerModel );
}
