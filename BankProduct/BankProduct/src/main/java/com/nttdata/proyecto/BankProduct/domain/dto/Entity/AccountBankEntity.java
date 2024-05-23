package com.nttdata.proyecto.BankProduct.domain.dto.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity
@Table(name="tbl_accountbank")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountBankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "You must enter a account number")
    @Size(max = 50, message = "The name can have a maximum of  50 characters")
    @Column(name="accountNumber",nullable = false)
    private String accountNumber;
    @NotBlank(message = "You must enter a comision")
    @Column(name="comission",nullable = false)
    private Long comission;
    @NotBlank(message = "You must enter a tipe account")
    @Size(max = 50, message = "The name can have a maximum of  50 characters")
    @Column(name="type_Account",nullable = false)
    private String typeAccount;
    @NotBlank(message = "You must enter a limit movemment")
    @Column(name="limit_Mov",nullable = false)
    private Long limitMovement;

    @Column(name="date_Movement",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateMovement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_product_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @JsonBackReference // or @JsonIgnore
    private BankProductEntity bankProductEntity;
}
