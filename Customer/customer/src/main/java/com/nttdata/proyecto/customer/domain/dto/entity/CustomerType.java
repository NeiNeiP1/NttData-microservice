package com.nttdata.proyecto.customer.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

// CustomerType entity with its attributes

@Entity
@Table(name="tbl_customertype")
//Data = setter, getter hashCode, to String and Equals
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerType {
    //Main key and auto incremental
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String name;

    @OneToMany(mappedBy = "customerType", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    private List<CustomerEntity> customers;
}
