package com.nttdata.proyecto.BankProduct.domain.dto.Model;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.CreditEntity;
import lombok.Data;
//Model of credit card with attributes
@Data
public class CreditCard {
    private Long id;
    private String numberCard;
    private Long limitCredit;
    private Long availableCredit;
    private String typeCustomer;
    private CreditEntity creditEntity;
}
