package com.nttdata.proyecto.customer.domain.dto.repository;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Customer Repository with search functions

import java.util.List;

//Para paginar y generar automaticamente kis query
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    // search for a Customer by its type. @return CustomerList

    public List<CustomerEntity> findByCustomerType(CustomerType customerType);

    // search for a Customer by name. @return Customer
    public List<CustomerEntity> findByName(String nombre);

    // search for a Customer by document code. @return Customer
    public CustomerEntity findByCodeDocument(Long codeDocument);

    // search for a Customer by document code. @return CustomerList
    public List<CustomerEntity> findByLocation(String location);

    // search for a customer by phonenumber. @return Customer
    public CustomerEntity findByPhoneNumber(String phoneNumber);

    // search for a customer by email. @return Customer
    public CustomerEntity findByEmail(String email);
}
