package com.tallerdegrado1.publicidadserver.repositorios;

import com.tallerdegrado1.publicidadserver.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoriaRepositorio  extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> getCategoriaByNombre(String nombre);
}
