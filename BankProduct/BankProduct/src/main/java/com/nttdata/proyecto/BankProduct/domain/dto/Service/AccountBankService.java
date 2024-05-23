package com.nttdata.proyecto.BankProduct.domain.dto.Service;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.AccountBankEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;

import java.util.Date;
import java.util.List;

public interface AccountBankService {
    public  List<AccountBankEntity> findAll();
    public AccountBankEntity getAccountBank(Long id);
    public AccountBankEntity create(AccountBankEntity accountBankEntity);
    public AccountBankEntity update(AccountBankEntity accountBankEntity);
    public AccountBankEntity delete(Long id);
    public AccountBankEntity findByAccountNumber(String accountNumber);
    public AccountBankEntity findByTypeAccount(String typeAccount);
    public AccountBankEntity findByComission(Long comission);
    public AccountBankEntity findByLimitMovement(Long limitMovement);
    public AccountBankEntity findByDateMovement(Date dateMovement);
    public AccountBankEntity findByBankProductEntity(BankProductEntity bankProductEntity);


}
