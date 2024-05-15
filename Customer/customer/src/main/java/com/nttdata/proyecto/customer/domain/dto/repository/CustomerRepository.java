package com.nttdata.proyecto.customer.domain.dto.repository;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
