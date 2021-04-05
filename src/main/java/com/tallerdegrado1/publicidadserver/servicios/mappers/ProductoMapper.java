package com.tallerdegrado1.publicidadserver.servicios.mappers;

import com.tallerdegrado1.publicidadserver.modelo.DetalleProducoNegocio;
import com.tallerdegrado1.publicidadserver.modelo.Producto;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.ProductoRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.ProductoResponse;

import java.util.List;

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
        String fotoProducto = null;
        List<DetalleProducoNegocio> detalleProducoNegocios = producto.getDetalles();
        if(detalleProducoNegocios!=null && !detalleProducoNegocios.isEmpty()){
            fotoProducto = detalleProducoNegocios.get(0).getFoto();
        }
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getIdCategoria(),
                fotoProducto
        );
    }
}
