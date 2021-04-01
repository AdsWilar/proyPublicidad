package com.tallerdegrado1.publicidadserver.excepciones;

import com.tallerdegrado1.publicidadserver.servicios.dto.response.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseExcepcion {

    GeneralResponse response;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralResponse> exception(Exception e) {
        response = new GeneralResponse(false, null, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}