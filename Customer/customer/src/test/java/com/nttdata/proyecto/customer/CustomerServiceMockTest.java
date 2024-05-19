package com.nttdata.proyecto.customer;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.entity.TypeDocEntity;
import com.nttdata.proyecto.customer.domain.dto.repository.CustomerRepository;
import com.nttdata.proyecto.customer.domain.dto.service.CustomerService;
import com.nttdata.proyecto.customer.domain.dto.service.CustomerServiceImpl;
import com.nttdata.proyecto.customer.domain.dto.CustomerApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

//Test Unitario Mock Repositorio

@SpringBootTest(classes= CustomerApplication.class)
public class CustomerServiceMockTest {
    @Mock
    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        customerService=new CustomerServiceImpl(customerRepository);
        CustomerEntity customer01= CustomerEntity.builder()
                .name("john")
                .status("created")
                .customerType(CustomerType.builder().id(1L).build())
                .typeDoc(TypeDocEntity.builder().id(1L).build())
                .location("Arequipa")
                .phonenumber("+51959541245")
                .email("jramosb@unsa.edu.pe")
                .doc("95487466")
                .build();
        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer01));
        Mockito.when(customerRepository.save(customer01)).thenReturn(customer01);
    }
    @Test
    public void whenValidGetID_ThenReturnCustomer(){
        CustomerEntity found= customerService.getCustomer(1l);
        Assertions.assertEquals("john",found.getName());
    }
    @Test
    public void whenValidGetTypeDoc_ThenReturnNull(){
        CustomerEntity found1= customerService.getCustomer(1l);
        Assertions.assertEquals(1L,found1.getCustomerType().getId());
    }
}
