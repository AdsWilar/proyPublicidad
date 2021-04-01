package com.tallerdegrado1.publicidadserver.servicios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleProductoResponse {

    private Integer idProducto;
    private String nombre;
    private Integer idCategoria;
    private String descripcion;
    private String foto;
    private Double precio;
    private Integer idNegocio;

}