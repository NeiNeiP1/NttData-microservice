package com.nttdata.proyecto.customer.domain.dto.model;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.entity.TypeDocEntity;
import lombok.*;

// Customer model with its attributes
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String doc;
    private String typeDoc;
    private String status;
    private String location;
    private String phonenumber;
    private String email;
    private String customerType;
}



