package com.tallerdegrado1.publicidadserver.servicios;

import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioExcepcion;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.NegocioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.NegocioResponse;

import java.util.List;

public interface NegocioServicio {
    NegocioResponse registrarNegocio(NegocioRequest negocioRequest) throws NegocioExcepcion, UsuarioExcepcion;

    List<NegocioResponse> listarNegocios();

    List<NegocioResponse> listarPorUsuario(Integer idUsuario) throws UsuarioExcepcion;
}
