package com.tallerdegrado1.publicidadserver.servicios.dto.request;

import lombok.Data;

@Data
public class CategoriaRequest {
    private String nombre;
    private  String descripcion;
    private String foto;
}
