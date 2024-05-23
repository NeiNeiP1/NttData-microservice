package com.nttdata.proyecto.BankProduct.domain.dto.Repository;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<CreditEntity,Long> {
    public CreditEntity findByNumCredit(String numCredit);
    public CreditEntity findByLimit(Long limit);
    public CreditEntity findByInterest(Long interest);
}
