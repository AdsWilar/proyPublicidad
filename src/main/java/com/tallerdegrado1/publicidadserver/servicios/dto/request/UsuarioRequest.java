package com.tallerdegrado1.publicidadserver.servicios.dto.request;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String correo;
    private String foto;
    private String usu;
    private String pass;
}
