package com.nttdata.proyecto.customer.domain.dto.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

// Customer entity with its attributes


@Entity
@Table(name="tbl_customers")
//Data = setter, getter hashCode, to String and Equals
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEntity {
    //Main key and auto incremental
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String name;
    @NotEmpty(message = "No puede estar vacío el documentoy")
    @Size(min = 8, max = 8, message = "El documento es de 8 cifras")
    private String doc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typedoc_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeDocEntity typeDoc;

    private String status;
    private String location;
    private String phonenumber;
    private String email;
    //For relation de many to one, One CustomerType have many customers
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customertype_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CustomerType customerType;

}
