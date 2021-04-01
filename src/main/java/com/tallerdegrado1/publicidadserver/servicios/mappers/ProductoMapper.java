package com.tallerdegrado1.publicidadserver.servicios.mappers;

import com.tallerdegrado1.publicidadserver.modelo.Producto;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.ProductoRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.ProductoResponse;

public class ProductoMapper extends BaseMapper<ProductoRequest, ProductoResponse, Producto> {
    @Override
    public Producto toEntity(ProductoRequest productoRequest) {
        Producto producto = new Producto();
        producto.setNombre(productoRequest.getNombre());
        producto.setIdCategoria(productoRequest.getIdCategoria());
        return producto;
    }

    @Override
    public ProductoResponse toDto(Producto producto) {
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getIdCategoria()
        );
    }
}
