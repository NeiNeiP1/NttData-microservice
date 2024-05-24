package com.nttdata.proyecto.BankProduct.domain.dto.Model;

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



