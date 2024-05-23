package com.nttdata.proyecto.BankProduct.domain.dto.Repository;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankProductRepository extends JpaRepository<BankProductEntity, Long> {

    public BankProductEntity findByTypePB(String typePB);
    public BankProductEntity findByBalance(Long balance);

}
