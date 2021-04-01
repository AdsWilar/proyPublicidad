package com.tallerdegrado1.publicidadserver.servicios.mappers;

import com.tallerdegrado1.publicidadserver.modelo.Usuario;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.UsuarioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.UsuarioResponse;

public class UsuarioMapper extends BaseMapper<UsuarioRequest, UsuarioResponse, Usuario> {
    @Override
    public Usuario toEntity(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setApellido(usuarioRequest.getApellido());
        usuario.setTelefono(usuarioRequest.getTelefono());
        usuario.setCorreo(usuarioRequest.getCorreo());
        usuario.setFoto(usuarioRequest.getFoto());
        usuario.setUsu(usuarioRequest.getUsu());
        return usuario;

    }

    @Override
    public UsuarioResponse toDto(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getTelefono(),
                usuario.getCorreo(),
                usuario.getFoto(),
                usuario.getUsu()
        );
    }
}
