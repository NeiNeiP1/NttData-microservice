package com.nttdata.proyecto.BankProduct.application.dto.request;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nttdata.proyecto.BankProduct.domain.dto.Entity.BankProductEntity;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class CreditCardRequest {

    @NotBlank(message = "You must enter a number card")
    private String numberCard;
    @NotBlank(message = "You must enter a limit credit")
    private Long limitCredit;
    @NotBlank(message = "You must enter a available credit")
    private Long availableCredit;
    @NotBlank(message = "You must enter a type customer")
    private String typeCustomer;
    @NotBlank(message = "You must enter a credit id")
    private Long creditEntity;
}
