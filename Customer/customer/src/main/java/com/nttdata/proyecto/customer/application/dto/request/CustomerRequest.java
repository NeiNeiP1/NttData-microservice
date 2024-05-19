package com.nttdata.proyecto.customer.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "You must enter a name")
    @Size(max = 50, message = "The name can have a maximum of  50 characters")
    private String name;
    @NotBlank(message = "You must enter a number of doc")
    @Pattern(regexp = "^\\d{8}$", message = "You must enter the correct data")
    private String doc;
    @NotNull
    private Long typeDoc;
    @NotBlank(message = "You must enter a status")
    @Size(max = 50, message = "The status can have a maximum of  50 characters")
    private String status;
    @NotBlank(message = "You must enter a location")
    @Size(max = 50, message = "The location can have a maximum of  50 characters")
    private String location;
    @NotBlank(message = "You must enter a phone number")
    @Size(max = 20, message = "The phone number can have a maximum of  20 characters")
    private String phonenumber;
    @NotBlank(message = "You must enter a email")
    @Size(max = 50, message = "The email can have a maximum of  50 characters")
    private String email;
    @NotNull
    private Long typeCustomer;

}
