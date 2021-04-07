package com.tallerdegrado1.publicidadserver.rest;

import com.tallerdegrado1.publicidadserver.excepciones.LoginExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioExcepcion;
import com.tallerdegrado1.publicidadserver.modelo.Usuario;
import com.tallerdegrado1.publicidadserver.servicios.UsuarioServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.LoginRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.UsuarioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.GeneralResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.LoginResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.UsuarioResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/registrar")
    public GeneralResponse registrarUsuario(@RequestBody UsuarioRequest request) throws UsuarioExcepcion {
        UsuarioResponse usuarioResponse= usuarioServicio.registrarUsuario(request);
        return new GeneralResponse(true, usuarioResponse, "Usuario registrado con éxito");
    }

    @GetMapping("/listar")
    public GeneralResponse listarUsuarios() {
        List<UsuarioResponse> response = usuarioServicio.listarUsuarios();
        return new GeneralResponse(true, response, "Usuarios listados con éxito");
    }
    @PostMapping("/login")
    public GeneralResponse login(@RequestBody LoginRequest loginRequest) throws UsuarioExcepcion, LoginExcepcion {
        LoginResponse  login = usuarioServicio.login(loginRequest);
        return new GeneralResponse(true, login, " éxito");

    }


}
