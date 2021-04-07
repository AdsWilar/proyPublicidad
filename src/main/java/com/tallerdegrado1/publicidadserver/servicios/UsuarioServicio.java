package com.tallerdegrado1.publicidadserver.servicios;

import com.tallerdegrado1.publicidadserver.excepciones.LoginExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioExcepcion;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.LoginRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.UsuarioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.LoginResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.UsuarioResponse;

import java.util.List;

public interface UsuarioServicio {
    void registrarUsuario(UsuarioRequest usuarioRequest) throws UsuarioExcepcion;
    List<UsuarioResponse> listarUsuarios();
    LoginResponse login(LoginRequest loginRequest) throws UsuarioExcepcion, LoginExcepcion;
}
