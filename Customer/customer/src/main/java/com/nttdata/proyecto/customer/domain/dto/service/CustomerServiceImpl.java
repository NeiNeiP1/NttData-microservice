package com.nttdata.proyecto.customer.domain.dto.service;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private final CustomerRepository customerRepository;
    @Override
    public List<CustomerEntity> listAllCustomer(){

        return customerRepository.findAll();
    }
    @Override
    public CustomerEntity getCustomer(Long id){

        return customerRepository.findById(id).orElse(null);
    }
    @Override
    public CustomerEntity createCustomer(CustomerEntity customer){

        return customerRepository.save(customer);
    }
    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer){
        CustomerEntity customerEntityDB = getCustomer(customer.getId());
        if(null==customerEntityDB){
            return null;
        }
        customerEntityDB.setName(customer.getName());
        customerEntityDB.setEmail(customer.getEmail());
        customerEntityDB.setDoc(customer.getDoc());
        customerEntityDB.setTypeDoc(customer.getTypeDoc());
        customerEntityDB.setCustomerType(customer.getCustomerType());
        customerEntityDB.setPhonenumber(customer.getPhonenumber());
        customerEntityDB.setStatus(customer.getStatus());
        customerEntityDB.setLocation(customer.getLocation());
        return customerRepository.save(customerEntityDB);
    }
    public CustomerEntity deleteCustomer(Long id){
        CustomerEntity customerEntityDB = getCustomer(id);
        if(null==customerEntityDB){
            return null;
        }
        customerEntityDB.setStatus("DELETED");
        return customerRepository.save(customerEntityDB);
    }
    @Override
    public List<CustomerEntity> findByCustomerType(CustomerType customerType){
        return customerRepository.findByCustomerType(customerType);
    }

    @Override
    public CustomerEntity findByDoc(String doc){
        return customerRepository.findByDoc(doc);
    }

}
