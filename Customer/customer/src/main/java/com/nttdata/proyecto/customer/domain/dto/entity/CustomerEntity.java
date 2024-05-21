package com.nttdata.proyecto.customer.domain.dto.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
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

    @NotEmpty(message = "You must enter a name")
    @Size(max = 50, message = "The name can have a maximum of 50 characters")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotEmpty(message = "You must enter a number of doc")
    @Size(min = 8, max = 8, message = "You must enter the correct data")
    @Column(name = "doc", nullable = false, unique = true, length = 8)

    private String doc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typedoc_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @Positive(message = "The Type Doc is positive")
    @JsonBackReference // or @JsonIgnore
    private TypeDocEntity typeDoc;

    @Column(name="status",length = 255)
    private String status;

    @NotEmpty(message = "You must enter a location")
    @Column(name="location", length = 255)
    private String location;

    @Column(name="phonenumber", length = 255)
    @NotEmpty(message = "You must enter a phone number")
    private String phonenumber;

    @Column(name="email", length = 255,unique = true,nullable = false)
    @NotEmpty(message = "You must enter a email")
    @Email(message = "not address email correctly")
    private String email;


    //For relation de many to one, One CustomerType have many customers
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customertype_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @Positive(message = "The Type Customer is positive")
    @JsonBackReference // or @JsonIgnore
    private CustomerType customerType;

}
