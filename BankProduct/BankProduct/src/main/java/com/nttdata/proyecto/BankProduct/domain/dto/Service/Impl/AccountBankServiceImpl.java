package com.nttdata.proyecto.BankProduct.domain.dto.Service.Impl;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.AccountBankEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Repository.AccountBankRepository;
import com.nttdata.proyecto.BankProduct.domain.dto.Service.AccountBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountBankServiceImpl implements AccountBankService {

    @Autowired
    private final AccountBankRepository accountBankRepository;

    @Override
    public List<AccountBankEntity> findAll() {
        return accountBankRepository.findAll();
    }

    @Override
    public AccountBankEntity getAccountBank(Long id) {
        return accountBankRepository.findById(id).orElse(null);
    }

    @Override
    public AccountBankEntity create(AccountBankEntity accountBankEntity) {
        return accountBankRepository.save(accountBankEntity);
    }

    @Override
    public AccountBankEntity update(AccountBankEntity accountBankEntity) {
        AccountBankEntity accountBankEntity1 = getAccountBank(accountBankEntity.getId());
        if(null==accountBankEntity1){
            return null;
        }
        accountBankEntity1.setAccountNumber(accountBankEntity.getAccountNumber());
        accountBankEntity1.setComission(accountBankEntity.getComission());
        accountBankEntity1.setTypeAccount(accountBankEntity.getTypeAccount());
        accountBankEntity1.setLimitMovement(accountBankEntity.getLimitMovement());

        return accountBankRepository.save(accountBankEntity1);
    }

    @Override
    public AccountBankEntity delete(Long id) {
        AccountBankEntity accountBankEntity = getAccountBank(id);
        if(accountBankEntity==null){
            return null;
        }
        accountBankRepository.delete(accountBankEntity);
        return accountBankRepository.save(accountBankEntity);

    }

    @Override
    public AccountBankEntity findByAccountNumber(String accountNumber) {
        return accountBankRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public AccountBankEntity findByTypeAccount(String typeAccount) {
        return accountBankRepository.findByTypeAccount(typeAccount);
    }

    @Override
    public AccountBankEntity findByComission(Long comission) {
        return accountBankRepository.findByComission(comission);
    }

    @Override
    public AccountBankEntity findByLimitMovement(Long limitMovement) {
        return accountBankRepository.findByLimitMovement(limitMovement);
    }

    @Override
    public AccountBankEntity findByDateMovement(Date dateMovement) {
        return accountBankRepository.findByDateMovement(dateMovement);
    }

    @Override
    public AccountBankEntity findByBankProductEntity(BankProductEntity bankProductEntity) {
        return accountBankRepository.findByBankProductEntity(bankProductEntity);
    }
}
