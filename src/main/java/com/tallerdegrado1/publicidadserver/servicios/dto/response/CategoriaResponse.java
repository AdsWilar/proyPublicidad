package com.tallerdegrado1.publicidadserver.servicios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String foto;
}
