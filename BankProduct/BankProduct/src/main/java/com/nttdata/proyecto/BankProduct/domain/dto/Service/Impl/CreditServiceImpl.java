package com.nttdata.proyecto.BankProduct.domain.dto.Service.Impl;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.CreditEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Repository.CreditRepository;
import com.nttdata.proyecto.BankProduct.domain.dto.Service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    @Autowired
    private final CreditRepository creditRepository;
    @Override
    public List<CreditEntity> findAll() {
        return creditRepository.findAll();
    }

    @Override
    public CreditEntity getCreditById(Long id) {
        return creditRepository.findById(id).orElse(null);
    }

    @Override
    public CreditEntity save(CreditEntity creditEntity) {
        return creditRepository.save(creditEntity);
    }

    @Override
    public CreditEntity update(CreditEntity creditEntity) {
        CreditEntity credit = getCreditById(creditEntity.getId());
        if(null==credit){
            return null;
        }
        credit.setNumCredit(credit.getNumCredit());
        credit.setLimit(credit.getLimit());
        credit.setInterest(credit.getInterest());
        return creditRepository.save(creditEntity);
    }

    @Override
    public void delete(CreditEntity creditEntity) {
        CreditEntity credit = getCreditById(creditEntity.getId());
        creditRepository.delete(credit);
    }

    @Override
    public CreditEntity findByNumCredit(String numCredit) {
        return creditRepository.findByNumCredit(numCredit);
    }

    @Override
    public CreditEntity findByInterest(Long interest) {
        return creditRepository.findByInterest(interest);
    }
}
