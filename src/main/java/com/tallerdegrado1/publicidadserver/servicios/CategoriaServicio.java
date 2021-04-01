package com.tallerdegrado1.publicidadserver.servicios;

import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaExcepcion;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.CategoriaRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.CategoriaResponse;

import java.util.List;

public interface CategoriaServicio {
    CategoriaResponse registrarCategoria(CategoriaRequest categoriaRequest) throws CategoriaExcepcion;
    List<CategoriaResponse>listarCategorias();
}
