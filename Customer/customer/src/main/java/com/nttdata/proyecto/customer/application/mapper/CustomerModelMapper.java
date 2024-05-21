package com.nttdata.proyecto.customer.application.mapper;

import com.nttdata.proyecto.customer.application.dto.request.CustomerRequest;
import com.nttdata.proyecto.customer.application.dto.request.CustomerUpdateRequest;
import com.nttdata.proyecto.customer.domain.dto.entity.CustomerType;
import com.nttdata.proyecto.customer.domain.dto.entity.TypeDocEntity;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerModelMapper {
    CustomerModelMapper INSTANCE = Mappers.getMapper(CustomerModelMapper.class);
    default Customer mapToCustomerModel(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .doc(customerRequest.getDoc())
                .typeDoc(String.valueOf(customerRequest.getTypeDoc()))  // Solo pasar el ID
                .status(customerRequest.getStatus())
                .location(customerRequest.getLocation())
                .phonenumber(customerRequest.getPhonenumber())
                .email(customerRequest.getEmail())
                .customerType(String.valueOf(customerRequest.getTypeCustomer())) // Solo pasar el ID
                .build();
    }

    default Customer mapToCustomerUpdateModel(CustomerUpdateRequest customerRequest){
        return Customer.builder()
                .id(Long.parseLong(customerRequest.getId()))
                .name(customerRequest.getName())
                .doc(customerRequest.getDoc())
                .typeDoc(String.valueOf(customerRequest.getTypeDoc()))  // Solo pasar el ID
                .status(customerRequest.getStatus())
                .location(customerRequest.getLocation())
                .phonenumber(customerRequest.getPhonenumber())
                .email(customerRequest.getEmail())
                .customerType(String.valueOf(customerRequest.getTypeCustomer())) // Solo pasar el ID
                .build();
    }
}
