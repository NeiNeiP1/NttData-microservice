package com.nttdata.proyecto.customer.domain.dto.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tbl_customers")
//Da el setter, getter hashCode, to String y Equals
@Data
public class CompanyEntity {
    //Para llave primaria y autoincrementable
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int type;
    private Long codeDocument;
    private String description;
    private String location;
    //Para relación de muchos a uno, x tiene muchos de esto@ManyToOne(fetch=FetchType.LAZY)
    //JoinColumn(name="category_id")
    //private CustomerEntity customer;
}
