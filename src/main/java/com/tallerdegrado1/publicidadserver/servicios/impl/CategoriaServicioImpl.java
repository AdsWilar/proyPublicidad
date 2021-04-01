package com.tallerdegrado1.publicidadserver.servicios.impl;

import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaRegistroExcepcion;
import com.tallerdegrado1.publicidadserver.modelo.Categoria;
import com.tallerdegrado1.publicidadserver.repositorios.CategoriaRepositorio;
import com.tallerdegrado1.publicidadserver.servicios.CategoriaServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.CategoriaRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.CategoriaResponse;
import com.tallerdegrado1.publicidadserver.servicios.mappers.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    private final CategoriaMapper categoriaMapper = new CategoriaMapper();

    @Override
    public CategoriaResponse registrarCategoria(CategoriaRequest categoriaRequest) throws CategoriaExcepcion {
        Optional<Categoria> categorias = categoriaRepositorio.getCategoriaByNombre(categoriaRequest.getNombre());
        if (categorias.isPresent()) {
            throw new CategoriaRegistroExcepcion();
        }
        Categoria categoria = categoriaMapper.toEntity(categoriaRequest);
        Categoria categoriaRegistrada = categoriaRepositorio.saveAndFlush(categoria);
        return categoriaMapper.toDto(categoriaRegistrada);
    }

    @Override
    public List<CategoriaResponse> listarCategorias() {
        List<Categoria> categorias = categoriaRepositorio.findAll();
        return categoriaMapper.toDto(categorias);
    }
}
