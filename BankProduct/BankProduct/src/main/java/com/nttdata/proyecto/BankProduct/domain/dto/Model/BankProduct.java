package com.nttdata.proyecto.BankProduct.domain.dto.Model;

import lombok.Data;
//Model of product bank with attributes
@Data
public class BankProduct {
    private Long id;
    private String typePB;
    private Long balance;
}
