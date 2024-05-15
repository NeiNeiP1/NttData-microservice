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
public class CustomerEntity {
    //Para llave primaria y autoincrementable
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int type;
    private Long codeDocument;
    // Por si el nombre es distinto en la base de datos@Column(name="fecha_at")
    @Temporal(TemporalType.DATE)
    private Date fecha;
}
