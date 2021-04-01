package com.tallerdegrado1.publicidadserver.servicios.mappers;

import com.tallerdegrado1.publicidadserver.modelo.Negocio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.NegocioRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.NegocioResponse;

public class NegocioMapper extends BaseMapper<NegocioRequest, NegocioResponse,Negocio>{
    @Override
    public Negocio toEntity(NegocioRequest negocioRequest) {
        Negocio negocio = new Negocio();
        negocio.setNombre(negocioRequest.getNombre());
        negocio.setDescripcion(negocioRequest.getDescripcion());
        negocio.setTelefono(negocioRequest.getTelefono());
        negocio.setUbicacion(negocioRequest.getUbicacion());
        negocio.setFoto(negocioRequest.getFoto());
        negocio.setIdUsuario(negocioRequest.getIdUsuario());
        return negocio;
    }

    @Override
    public NegocioResponse toDto(Negocio negocio) {
        return new NegocioResponse(
                negocio.getId(),
                negocio.getNombre(),
                negocio.getDescripcion(),
                negocio.getTelefono(),
                negocio.getUbicacion(),
                negocio.getFoto(),
                negocio.getIdUsuario()
        );
    }
}
