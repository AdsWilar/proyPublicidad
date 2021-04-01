package com.tallerdegrado1.publicidadserver.servicios;

import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaNoEncontrada;
import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioNoEncontrado;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.ProductoRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.DetalleProductoResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.ProductoResponse;

import java.util.List;

public interface ProductoServicio {
    DetalleProductoResponse registrarProducto(ProductoRequest productoRequest) throws CategoriaNoEncontrada,
            NegocioNoEncontrado;

    List<ProductoResponse> listarProductos();

    List<ProductoResponse> listarPorCategoria(Integer idCategoria) throws CategoriaExcepcion;
}
