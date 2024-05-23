package com.nttdata.proyecto.BankProduct.domain.dto.Model;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.CreditEntity;
import lombok.Data;

@Data
public class CreditCard {
    private Long id;
    private String numberCard;
    private Long limitCredit;
    private Long availableCredit;
    private String typeCustomer;
    private CreditEntity creditEntity;
}
