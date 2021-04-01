package com.tallerdegrado1.publicidadserver.servicios.impl;

import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioRegistradoExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioNoEncontrado;
import com.tallerdegrado1.publicidadserver.modelo.Negocio;
import com.tallerdegrado1.publicidadserver.modelo.Usuario;
import com.tallerdegrado1.publicidadserver.repositorios.NegocioRepositorio;
import com.tallerdegrado1.publicidadserver.repositorios.UsuarioRepositorio;
import com.tallerdegrado1.publicidadserver.servicios.NegocioServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.NegocioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.NegocioResponse;
import com.tallerdegrado1.publicidadserver.servicios.mappers.NegocioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegocioServicioImpl implements NegocioServicio {
    @Autowired
    private NegocioRepositorio negocioRepositorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    private final NegocioMapper negocioMapper = new NegocioMapper();

    @Override
    public NegocioResponse registrarNegocio(NegocioRequest negocioRequest) throws NegocioExcepcion, UsuarioExcepcion {
        Usuario usuario = usuarioRepositorio.findById(negocioRequest.getIdUsuario()).orElseThrow(UsuarioNoEncontrado::new);
        List<Negocio> negociosUsuario = negocioRepositorio.getAllByIdUsuario(usuario.getId());
        for (Negocio negocio : negociosUsuario) {
            if (negocio.getNombre().equals(negocioRequest.getNombre())) {
                throw new NegocioRegistradoExcepcion();
            }
        }
        Negocio negocio = negocioMapper.toEntity(negocioRequest);
        Negocio negocioRegistrado = negocioRepositorio.saveAndFlush(negocio);
        return negocioMapper.toDto(negocioRegistrado);
    }

    @Override
    public List<NegocioResponse> listarNegocios() {
        List<Negocio> negocios = negocioRepositorio.findAll();
        return negocioMapper.toDto(negocios);
    }

    @Override
    public List<NegocioResponse> listarPorUsuario(Integer idUsuario) throws UsuarioExcepcion {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElseThrow(UsuarioNoEncontrado::new);
        List<Negocio> negocios = negocioRepositorio.getAllByIdUsuario(usuario.getId());
        return negocioMapper.toDto(negocios);
    }
}
