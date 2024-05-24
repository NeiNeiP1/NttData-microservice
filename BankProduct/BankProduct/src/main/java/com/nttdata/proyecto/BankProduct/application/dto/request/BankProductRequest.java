package com.nttdata.proyecto.BankProduct.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// Bank Product Request with validation


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankProductRequest {
    @NotBlank(message = "You must enter a tipe")
    @Size(max = 50, message = "The name can have a maximum of  50 characters")
    private String typePB;
    @NotNull
    private Long balance;

}
