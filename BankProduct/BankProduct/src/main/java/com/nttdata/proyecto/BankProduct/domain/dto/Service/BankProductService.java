package com.nttdata.proyecto.BankProduct.domain.dto.Service;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;

import java.util.List;

public interface BankProductService {
    public List<BankProductEntity> findAll();
    public BankProductEntity getBankProduct(Long id);
    public BankProductEntity create(BankProductEntity bankProduct);
    public BankProductEntity update(BankProductEntity bankProduct);
    public BankProductEntity delete(Long id);
    public BankProductEntity findByTypePB(String typePB);
    public BankProductEntity findByBalance(Long balance);
}
