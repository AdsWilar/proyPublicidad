package com.tallerdegrado1.publicidadserver.servicios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private String correo;
    private String foto;
    private String usu;

}
