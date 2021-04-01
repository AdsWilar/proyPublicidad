package com.tallerdegrado1.publicidadserver.servicios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NegocioResponse {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer telefono;
    private String ubicacion;
    private String foto;
    private Integer idUsuario;
}
