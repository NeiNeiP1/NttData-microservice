package com.nttdata.proyecto.customer;

import com.nttdata.proyecto.customer.application.dto.response.CustomerResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomerResponse> handleException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(CustomerResponse.builder()
                .code("400")
                //Mensaje de error personalizado
                //.message("Dato Erroneo")
                //Mensaje de error personalizado con el CustomerRequest
                .message(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build(), HttpStatus.BAD_REQUEST);

    }
    @org.springframework.web.bind.annotation.ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<CustomerResponse> noFound(ChangeSetPersister.NotFoundException exception){
        return new ResponseEntity<>(CustomerResponse.builder()
                .code("400")
                //Mensaje de error personalizado
                //.message("Dato Erroneo")
                //Mensaje de error personalizado con el CustomerRequest
                .message("No se encuentra la página")
                .build(), HttpStatus.NOT_FOUND);

    }
}
