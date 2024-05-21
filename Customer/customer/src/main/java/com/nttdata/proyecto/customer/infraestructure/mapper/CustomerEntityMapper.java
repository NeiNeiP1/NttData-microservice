package com.nttdata.proyecto.customer.infraestructure.mapper;

import com.nttdata.proyecto.customer.domain.dto.entity.CustomerEntity;
import com.nttdata.proyecto.customer.domain.dto.entity.TypeDocEntity;
import com.nttdata.proyecto.customer.domain.dto.model.Customer;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerEntityMapper {

     CustomerEntityMapper INSTANCE = Mappers.getMapper(CustomerEntityMapper.class);

     @Mapping(target="id", source = "id")
     @Mapping(target="name", source = "name")
     @Mapping(target="doc", source = "doc")
     @Mapping(target="typeDoc", source = "typeDoc.name")
     @Mapping(target="status", source = "status")
     @Mapping(target="location", source = "location")
     @Mapping(target="phonenumber", source = "phonenumber")
     @Mapping(target="email", source = "email")
     @Mapping(target="customerType", source = "customerType.name")
     Customer mapperCustomerModel(CustomerEntity customerEntity);




     //Without Programation functional
     List<Customer> mapperCustomerModel(List<CustomerEntity> customerEntities);

     /**
     @Mapping(target="id", source = "id")
     @Mapping(target="name", source = "name")
     @Mapping(target="doc", source = "doc")
     @Mapping(target="typeDoc", source = "typeDoc.id")
     @Mapping(target="status", source = "status")
     @Mapping(target="location", source = "location")
     @Mapping(target="phonenumber", source = "phonenumber")
     @Mapping(target="email", source = "email")
     @Mapping(target="customerType", source = "customerType.id")
     Customer mapperCustomerEntity(Customer customer);
     List<Customer> mapperCustomerEntity(List<CustomerEntity> customerEntities);
**/

}
