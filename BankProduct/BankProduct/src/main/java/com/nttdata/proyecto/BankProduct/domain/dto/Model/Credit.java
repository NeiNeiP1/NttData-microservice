package com.nttdata.proyecto.BankProduct.domain.dto.Model;


import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import lombok.Data;
//Model of credit with attributes
@Data
public class Credit {
    private Long id;
    private String numCredit;
    private Long limit;
    private Long interest;
    private BankProductEntity bankProductEntity;
}
