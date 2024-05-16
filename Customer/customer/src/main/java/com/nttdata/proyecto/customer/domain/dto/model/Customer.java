package com.nttdata.proyecto.customer.domain.dto.model;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.entity.TypeDocEntity;
import lombok.Data;

// Customer model with its attributes

@Data
public class Customer {
    private Long id;
    private String name;
    private Long doc;
    private TypeDocEntity typeDoc;
    private String status;
    private String location;
    private String phonenumber;
    private String email;
    private CustomerType customerType;
}



