package com.tallerdegrado1.publicidadserver.servicios.dto.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String usu;
    private String pass;
}
