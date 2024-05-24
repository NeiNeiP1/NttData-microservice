package com.nttdata.proyecto.BankProduct.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
// Account Bank Request with validation
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountBankRequest {
    @NotBlank(message = "You must enter a account number")
    @Size(max = 50, message = "The name can have a maximum of  50 characters")
    private String accountNumber;
    @NotBlank(message = "You must enter a comision")
    private Long comission;
    @NotBlank(message = "You must enter a tipe account")
    private String typeAccount;
    @NotBlank(message = "You must enter a limit movemment")
    private Long limitMovement;
    @NotBlank(message = "You must enter a date movemment")
    private Date dateMovement;

}
