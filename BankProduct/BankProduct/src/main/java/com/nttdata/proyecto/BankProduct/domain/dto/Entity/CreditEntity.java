package com.nttdata.proyecto.BankProduct.domain.dto.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="tbl_credit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// Entity credit with attributes with validation
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "You must enter a number credit")
    @Column(name="numcredit",nullable = false)
    private String numCredit;
    @NotBlank(message = "You must enter a limit")
    @Column(name="credit_limit",nullable = false)
    private Long limit;
    @NotBlank(message = "You must enter a interest")
    @Column(name="interest",nullable = false)
    private Long interest;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_product_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @JsonBackReference // or @JsonIgnore
    private BankProductEntity bankProductEntity;
}
