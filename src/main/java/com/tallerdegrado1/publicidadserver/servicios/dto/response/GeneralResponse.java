package com.tallerdegrado1.publicidadserver.servicios.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {
    private Boolean ok;
    private Object datos;
    private String mensaje;
}
