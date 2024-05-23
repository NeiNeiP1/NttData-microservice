package com.nttdata.proyecto.BankProduct.domain.dto.Service;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.CreditEntity;

import java.util.List;

public interface CreditService {
    public List<CreditEntity> findAll();
    public CreditEntity getCreditById(Long id);
    public CreditEntity save(CreditEntity creditEntity);
    public CreditEntity update(CreditEntity creditEntity);
    public void delete(CreditEntity creditEntity);
    public CreditEntity findByNumCredit(String numCredit);
    public CreditEntity findByInterest(Long interest);
}
