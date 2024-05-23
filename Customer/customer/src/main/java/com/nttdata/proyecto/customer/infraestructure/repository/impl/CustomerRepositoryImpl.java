package com.nttdata.proyecto.customer.infraestructure.repository.impl;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import com.nttdata.proyecto.customer.domain.dto.repository.CustomerRepository;
import com.nttdata.proyecto.customer.infraestructure.dao.repository.CustomerRepositoryJPA;
import com.nttdata.proyecto.customer.infraestructure.mapper.CustomerEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Repository
@AllArgsConstructor
public  class CustomerRepositoryImpl implements CustomerRepository  {

    private final CustomerRepository customerRepository;

    private final CustomerRepositoryJPA customerReposiJPA;
    //Mapper


    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<Customer> listCustomer(){
        //Without Programation functional
        return  CustomerEntityMapper.INSTANCE.mapperCustomerModel(customerReposiJPA.findAll());

        //With programation functional
        //return customerReposiJPA.findAll().stream().map(CustomerEntityMapper.INSTANCE::mapperCustomerModel).collect(Collectors.toList());
    }



    @Override
    public List<CustomerEntity> findByCustomerType (CustomerType customerType){
        return customerRepository.findByCustomerType(customerType);
    }

    @Override
    public List<CustomerEntity> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public CustomerEntity findByDoc(String doc) {
        return customerRepository.findByDoc(doc);
    }

    @Override
    public List<CustomerEntity> findByLocation(String location) {
        return customerRepository.findByLocation(location);
    }

    @Override
    public CustomerEntity findByPhonenumber(String phonenumber) {
        return customerRepository.findByPhonenumber(phonenumber);
    }

    @Override
    public CustomerEntity findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Optional<CustomerEntity> findById(Long id) {
        return customerRepository.findById(id);
    }



    @Override
    public boolean existsById(Long aLong) {
        return customerRepository.existsById(aLong);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerEntity> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }

    @Override
    public Page<CustomerEntity> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<CustomerEntity> findAllById(Iterable<Long> longs) {
        return customerRepository.findAllById(longs);
    }

    //------------------------------Metodos de JPA REPOSITORY
    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }

    @Override
    public void delete(CustomerEntity entity) {
        customerRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        customerRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends CustomerEntity> entities) {
        customerRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public <S extends CustomerEntity> S save(S entity) {
        return customerRepository.save(entity);
    }

    @Override
    public <S extends CustomerEntity> List<S> saveAll(Iterable<S> entities) {
        return customerRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        customerRepository.flush();
    }

    @Override
    public <S extends CustomerEntity> S saveAndFlush(S entity) {
        return saveAndFlush(entity);
    }

    @Override
    public <S extends CustomerEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return customerRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<CustomerEntity> entities) {
        customerRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        customerRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        customerRepository.deleteAllInBatch();
    }

    @Override
    public CustomerEntity getOne(Long aLong) {
        return customerRepository.getOne(aLong);
    }

    @Override
    public CustomerEntity getById(Long aLong) {
        return customerRepository.getById(aLong);
    }

    @Override
    public CustomerEntity getReferenceById(Long aLong) {
        return customerRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends CustomerEntity> Optional<S> findOne(Example<S> example) {
        return customerRepository.findOne(example);
    }

    @Override
    public <S extends CustomerEntity> List<S> findAll(Example<S> example) {
        return customerRepository.findAll(example);
    }

    @Override
    public <S extends CustomerEntity> List<S> findAll(Example<S> example, Sort sort) {
        return customerRepository.findAll(example,sort);
    }

    @Override
    public <S extends CustomerEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return customerRepository.findAll(example,pageable);
    }

    @Override
    public <S extends CustomerEntity> long count(Example<S> example) {
        return customerRepository.count(example);
    }

    @Override
    public <S extends CustomerEntity> boolean exists(Example<S> example) {
        return customerRepository.exists(example);
    }

    @Override
    public <S extends CustomerEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return customerRepository.findBy(example,queryFunction);
    }

    /**
    @Override
    public Customer saveCustomer(Customer customerModel) {
        return CustomerEntityMapper.INSTANCE.mapperCustomerModel(
                customerReposiJPA.save(CustomerEntityMapper.INSTANCE.mapperCustomerEntity(customerModel))
        );
    }

    @Override
    public Customer updateCustomer(Customer customerModel) {
        return CustomerEntityMapper.INSTANCE.mapperCustomerModel(
                customerReposiJPA.save(CustomerEntityMapper.INSTANCE.mapperCustomerEntity(customerModel))
        );
    }
    **/
}
