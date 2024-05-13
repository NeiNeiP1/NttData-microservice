package com.nttdata.proyecto.customer.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "Debe ingresar un nombre")
    @Size(max = 50, message = "El nombre debe tener como máximo 50 caracteres")
    private String name;
    @NotBlank(message = "Debe ingresar un apellido")
    @Size(max = 50, message = "El apellido debe tener como máximo 50 caracteres")
    private String lastname;
    @NotBlank(message = "Debe ingresar un tipo de documento")
    private String typeDoc;
    @NotBlank(message = "Debe ingresar el número del documento")
    @Pattern(regexp = "^\\d(0)$", message = "Debe ingresar un dato correcto")
    private String doc;
    @NotBlank(message = "Debe ingresar el tipo de cliente")
    private String typeCustomer;

}
