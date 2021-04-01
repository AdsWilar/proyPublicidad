package com.tallerdegrado1.publicidadserver.rest;


import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaNoEncontrada;
import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioNoEncontrado;
import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioRegistradoExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.producto.ProductoExcepcion;
import com.tallerdegrado1.publicidadserver.servicios.ProductoServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.ProductoRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.DetalleProductoResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.GeneralResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.ProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoRest {

    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping("/registrar")
    public GeneralResponse registrarProducto(@RequestBody ProductoRequest request) throws CategoriaNoEncontrada,
            NegocioNoEncontrado {
        DetalleProductoResponse productoResponse = productoServicio.registrarProducto(request);
        return new GeneralResponse(true, productoResponse, "Producto registrado con éxito");
    }

    @GetMapping("/listar")
    public GeneralResponse listarProductos() {
        List<ProductoResponse> response = productoServicio.listarProductos();
        return new GeneralResponse(true, response, "Producto listados con éxito");
    }

    @GetMapping("/listar/{idCategoria}")
    public GeneralResponse listarProductos(@PathVariable("idCategoria") Integer idCategoria) throws CategoriaExcepcion {
        List<ProductoResponse> response = productoServicio.listarPorCategoria(idCategoria);
        return new GeneralResponse(true, response, "Producto listados con éxito");
    }
}
