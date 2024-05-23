package com.nttdata.proyecto.BankProduct.domain.dto.Service.Impl;

import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import com.nttdata.proyecto.BankProduct.domain.dto.Repository.BankProductRepository;
import com.nttdata.proyecto.BankProduct.domain.dto.Service.BankProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankProductServiceImpl implements BankProductService {
    @Autowired
    private final BankProductRepository bankProductRepository;

    @Override
    public List<BankProductEntity> findAll(){

        return bankProductRepository.findAll();
    }

    @Override
    public BankProductEntity getBankProduct(Long id) {

        return bankProductRepository.findById(id).orElse(null);
    }

    @Override
    public BankProductEntity create(BankProductEntity bankProduct) {

        return bankProductRepository.save(bankProduct);
    }

    @Override
    public BankProductEntity update(BankProductEntity bankProduct) {
        BankProductEntity bankProductEntity = getBankProduct(bankProduct.getId());
        if(null==bankProductEntity){
            return null;
        }
        bankProductEntity.setTypePB(bankProduct.getTypePB());
        bankProductEntity.setBalance(bankProduct.getBalance());

        return bankProductRepository.save(bankProductEntity);
    }

    @Override
    public BankProductEntity delete(Long id) {
        BankProductEntity bankProductEntity = getBankProduct(id);
        if(null==bankProductEntity){
            return null;
        }
        bankProductRepository.delete(bankProductEntity);
        return bankProductRepository.save(bankProductEntity);
    }

    @Override
    public BankProductEntity findByTypePB(String typePB) {
        return bankProductRepository.findByTypePB(typePB);
    }

    @Override
    public BankProductEntity findByBalance(Long balance) {
        return bankProductRepository.findByBalance(balance);
    }
}
