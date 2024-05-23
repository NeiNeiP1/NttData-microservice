package com.nttdata.proyecto.BankProduct.domain.dto.Repository;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.AccountBankEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AccountBankRepository extends JpaRepository<AccountBankEntity, Long> {
    public AccountBankEntity findByAccountNumber(String accountNumber);
    public AccountBankEntity findByTypeAccount(String typeAccount);
    public AccountBankEntity findByComission(Long comission);
    public AccountBankEntity findByLimitMovement(Long limitMovement);
    public AccountBankEntity findByDateMovement(Date dateMovement);
    public AccountBankEntity findByBankProductEntity(BankProductEntity bankProductEntity);


}
