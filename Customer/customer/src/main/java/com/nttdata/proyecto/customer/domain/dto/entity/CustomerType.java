package com.nttdata.proyecto.customer.domain.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

// CustomerType entity with its attributes

@Entity
@Table(name="tbl_customerstype")
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
    private String description;
}
