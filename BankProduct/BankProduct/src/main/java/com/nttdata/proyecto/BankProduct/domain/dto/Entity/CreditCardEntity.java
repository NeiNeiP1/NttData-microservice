package com.nttdata.proyecto.BankProduct.domain.dto.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_credit_card")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "You must enter a number card")
    @Column(name="number_card",nullable = false)
    private String numberCard;
    @NotBlank(message = "You must enter a limit credit")
    @Column(name="limit_credit",nullable = false)
    private Long limitCredit;
    @NotBlank(message = "You must enter a available credit")
    @Column(name="available_credit",nullable = false)
    private Long availableCredit;
    @NotBlank(message = "You must enter a type customer")
    @Column(name="type_customer",nullable = false)
    private String typeCustomer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @JsonBackReference // or @JsonIgnore
    private CreditEntity creditEntity;

}
