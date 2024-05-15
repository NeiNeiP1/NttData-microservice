package com.nttdata.proyecto.customer.domain.dto.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Da el setter, getter hashCode, to String y Equals
@Data
public class Customer {
    private Long id;
    private String name;
    private int type;
    private Long codeDocument;
}



