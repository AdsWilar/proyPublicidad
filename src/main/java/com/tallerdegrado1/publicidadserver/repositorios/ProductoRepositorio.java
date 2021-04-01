package com.tallerdegrado1.publicidadserver.repositorios;

import com.tallerdegrado1.publicidadserver.modelo.DetalleProducoNegocio;
import com.tallerdegrado1.publicidadserver.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    Optional<Producto> getByNombre(String nombre);

    List<Producto> getAllByIdCategoria(Integer idCategoria);

}
