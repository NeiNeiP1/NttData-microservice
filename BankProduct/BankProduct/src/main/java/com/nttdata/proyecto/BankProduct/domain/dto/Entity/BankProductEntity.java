package com.nttdata.proyecto.BankProduct.domain.dto.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="tbl_bankproduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "You must enter a tipe of product bank")
    @Size(max = 50, message = "The name can have a maximum of  50 characters")
    @Column(name="typePB",nullable = false,length = 50)
    private String typePB;

    @NotBlank(message = "You must enter a balance")
    @Column(name="balance",nullable = false,length = 50)
    private Long balance;

}
