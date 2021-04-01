package com.tallerdegrado1.publicidadserver.servicios.dto.request;

import lombok.Data;

@Data
public class ProductoRequest {
    private String nombre;
    private Integer idCategoria;
    private String descripcion;
    private String foto;
    private Double precio;
    private Integer idNegocio;
}
