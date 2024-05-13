package com.nttdata.proyecto.customer.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerResponse {
    private String message;
    private String code;

}
