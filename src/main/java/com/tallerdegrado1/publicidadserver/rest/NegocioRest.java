package com.tallerdegrado1.publicidadserver.rest;

import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioExcepcion;
import com.tallerdegrado1.publicidadserver.servicios.NegocioServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.NegocioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.GeneralResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.NegocioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/negocio")
public class NegocioRest {
    @Autowired
    private NegocioServicio negocioServicio;

    @PostMapping("/registrar")
    public GeneralResponse registrarNegocio(@RequestBody NegocioRequest request) throws NegocioExcepcion, UsuarioExcepcion {
        NegocioResponse negocioResponse = negocioServicio.registrarNegocio(request);
        return new GeneralResponse(true, negocioResponse, "Negocio registrado con éxito");
    }

    @GetMapping("/listar")
    public GeneralResponse listarUsuarios() {
        List<NegocioResponse> response = negocioServicio.listarNegocios();
        return new GeneralResponse(true, response, "Negocios listados con éxito");
    }

    @GetMapping("/listar/{idUsuario}")
    public GeneralResponse listarUsuarios(@PathVariable("idUsuario") Integer idUsuario) throws UsuarioExcepcion {
        List<NegocioResponse> response = negocioServicio.listarPorUsuario(idUsuario);
        return new GeneralResponse(true, response, "Negocios listados con éxito");
    }
}
