package com.nttdata.proyecto.BankProduct.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BankProductResponse {
    private String message;
    private String code;
}
