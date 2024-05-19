package com.nttdata.proyecto.customer;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.entity.TypeDocEntity;
import com.nttdata.proyecto.customer.domain.dto.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CustomerRepositoryMockTest {
    @Autowired
    private CustomerRepository customerRepository;

    //Test for create customer in database and search of customertype with de customer created
    @Test
    public void TestListCustomer() {
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
        customerRepository.save(customer01);


        List<CustomerEntity> founds =customerRepository.findByCustomerType(customer01.getCustomerType());
        //If founds size is equal to 3 is good search
        Assertions.assertThat(founds.size()).isEqualTo(1);

    }
}
