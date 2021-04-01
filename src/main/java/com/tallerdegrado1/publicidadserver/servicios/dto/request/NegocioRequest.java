package com.tallerdegrado1.publicidadserver.servicios.dto.request;

import lombok.Data;

@Data
public class NegocioRequest {
    private String nombre;
    private String descripcion;
    private Integer telefono;
    private String ubicacion;
    private String foto;
    private Integer idUsuario;
}
