package com.tallerdegrado1.publicidadserver.servicios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {
    private Integer id;
    private String nombre;
    private Integer idCategoria;

}
