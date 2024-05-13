package com.nttdata.proyecto.customer.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String typeDoc;
    @NotBlank
    private String doc;
    @NotBlank
    private String typeCustomer;

}
