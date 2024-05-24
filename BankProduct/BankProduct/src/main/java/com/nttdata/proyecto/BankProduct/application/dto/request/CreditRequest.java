package com.nttdata.proyecto.BankProduct.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
// Request with validation
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditRequest {
    @NotBlank(message = "You must enter a number credit")
    private String numCredit;
    @NotBlank(message = "You must enter a limit")
    private Long limit;
    @NotBlank(message = "You must enter a interest")
    private Long interest;

}
