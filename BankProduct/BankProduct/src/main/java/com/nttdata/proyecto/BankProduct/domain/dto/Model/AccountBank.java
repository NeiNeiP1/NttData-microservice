package com.nttdata.proyecto.BankProduct.domain.dto.Model;


import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import lombok.Data;

import java.util.Date;

@Data
public class AccountBank {
    private Long id;
    private String accountNumber;
    private Long comission;
    private String typeAccount;
    private Long limitMovemment;
    private Date datemovemment;
    private BankProductEntity bankProductEntity;
}
