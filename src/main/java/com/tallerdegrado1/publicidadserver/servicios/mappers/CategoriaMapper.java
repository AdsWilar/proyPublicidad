package com.tallerdegrado1.publicidadserver.servicios.mappers;


import com.tallerdegrado1.publicidadserver.modelo.Categoria;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.CategoriaRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.CategoriaResponse;

public class CategoriaMapper extends BaseMapper<CategoriaRequest, CategoriaResponse, Categoria>{

    @Override
    public Categoria toEntity(CategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequest.getNombre());
        categoria.setDescripcion(categoriaRequest.getDescripcion());
        categoria.setFoto(categoriaRequest.getFoto());
        return categoria;
    }

    @Override
    public CategoriaResponse toDto(Categoria categoria) {
        return new CategoriaResponse(
          categoria.getId(),
          categoria.getNombre(),
          categoria.getDescripcion(),
          categoria.getFoto()
        );
    }
}
