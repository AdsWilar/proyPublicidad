package com.tallerdegrado1.publicidadserver.rest;


import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaExcepcion;
import com.tallerdegrado1.publicidadserver.servicios.CategoriaServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.CategoriaRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.CategoriaResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaRest {
    @Autowired
    private CategoriaServicio categoriaServicio;

    @PostMapping("/registrar")
    public GeneralResponse registrarCategoria(@RequestBody CategoriaRequest request) throws CategoriaExcepcion {
        CategoriaResponse categoriaResponse = categoriaServicio.registrarCategoria(request);
        return new GeneralResponse(true, categoriaResponse, "Categoria registrada con éxito");
    }

    @GetMapping("/listar")
    public GeneralResponse listarCategorias() {
        List<CategoriaResponse> response = categoriaServicio.listarCategorias();
        return new GeneralResponse(true, response, "Categorias listadas con éxito");
    }


}
