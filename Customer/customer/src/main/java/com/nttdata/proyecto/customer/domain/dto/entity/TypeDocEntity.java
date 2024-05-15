package com.nttdata.proyecto.customer.domain.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


// TypeDoc entity with its attributes


@Entity
@Table(name = "tbl_documenttype")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeDocEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
}
