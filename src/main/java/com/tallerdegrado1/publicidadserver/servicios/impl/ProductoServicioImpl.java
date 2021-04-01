package com.tallerdegrado1.publicidadserver.servicios.impl;

import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.categoria.CategoriaNoEncontrada;
import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioNoEncontrado;
import com.tallerdegrado1.publicidadserver.excepciones.negocio.NegocioRegistradoExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.producto.ProductoExcepcion;
import com.tallerdegrado1.publicidadserver.excepciones.producto.ProductoNoEncontrado;
import com.tallerdegrado1.publicidadserver.excepciones.producto.ProductoRegistradoExcepcion;
import com.tallerdegrado1.publicidadserver.modelo.Categoria;
import com.tallerdegrado1.publicidadserver.modelo.DetalleProducoNegocio;
import com.tallerdegrado1.publicidadserver.modelo.Negocio;
import com.tallerdegrado1.publicidadserver.modelo.Producto;
import com.tallerdegrado1.publicidadserver.repositorios.CategoriaRepositorio;
import com.tallerdegrado1.publicidadserver.repositorios.DetalleProductoNegocioRepositorio;
import com.tallerdegrado1.publicidadserver.repositorios.NegocioRepositorio;
import com.tallerdegrado1.publicidadserver.repositorios.ProductoRepositorio;
import com.tallerdegrado1.publicidadserver.servicios.ProductoServicio;
import com.tallerdegrado1.publicidadserver.servicios.dto.request.ProductoRequest;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.DetalleProductoResponse;
import com.tallerdegrado1.publicidadserver.servicios.dto.response.ProductoResponse;
import com.tallerdegrado1.publicidadserver.servicios.mappers.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private NegocioRepositorio negocioRepositorio;
    @Autowired
    private DetalleProductoNegocioRepositorio detalleProductoNegocioRepositorio;
    private final ProductoMapper productoMapper = new ProductoMapper();

    @Override
    public DetalleProductoResponse registrarProducto(ProductoRequest productoRequest) throws CategoriaNoEncontrada,
            NegocioNoEncontrado {
        Negocio negocio = negocioRepositorio.findById(productoRequest.getIdNegocio())
                .orElseThrow(NegocioNoEncontrado::new);
        Optional<Producto> productoOptional =
                productoRepositorio.getByNombre(productoRequest.getNombre().toUpperCase());
        Producto producto;
        if (productoOptional.isPresent()) {
            producto = productoOptional.get();
        } else {
            Categoria categoria = categoriaRepositorio.findById(productoRequest.getIdCategoria())
                    .orElseThrow(CategoriaNoEncontrada::new);
            Producto nuevoProducto = productoMapper.toEntity(productoRequest);
            producto = productoRepositorio.saveAndFlush(nuevoProducto);
        }
        DetalleProducoNegocio nuevoDetalle = new DetalleProducoNegocio();
        nuevoDetalle.setDescripcion(productoRequest.getDescripcion());
        nuevoDetalle.setFoto(productoRequest.getFoto());
        nuevoDetalle.setPrecio(productoRequest.getPrecio());
        nuevoDetalle.setIdProducto(producto.getId());
        nuevoDetalle.setIdNegocio(negocio.getId());
        DetalleProducoNegocio detalleRegistrado = detalleProductoNegocioRepositorio.saveAndFlush(nuevoDetalle);

        return new DetalleProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getIdCategoria(),
                detalleRegistrado.getDescripcion(),
                detalleRegistrado.getFoto(),
                detalleRegistrado.getPrecio(),
                negocio.getId()
        );
    }

    @Override
    public List<ProductoResponse> listarProductos() {
        List<Producto> productos = productoRepositorio.findAll();
        return productoMapper.toDto(productos);
    }

    @Override
    public List<ProductoResponse> listarPorCategoria(Integer idCategoria) throws CategoriaExcepcion {
        Categoria categoria = categoriaRepositorio.findById(idCategoria).orElseThrow(CategoriaNoEncontrada::new);
        List<Producto> productos = productoRepositorio.getAllByIdCategoria(categoria.getId());
        return productoMapper.toDto(productos);
    }
}
