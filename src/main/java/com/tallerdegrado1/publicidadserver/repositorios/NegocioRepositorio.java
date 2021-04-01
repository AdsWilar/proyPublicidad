package com.tallerdegrado1.publicidadserver.repositorios;

import com.tallerdegrado1.publicidadserver.modelo.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NegocioRepositorio extends JpaRepository<Negocio,Integer> {

    Optional<Negocio> getNegocioByNombre(String nombre);
    List<Negocio> getAllByIdUsuario(Integer idUsuario);
    List<Negocio> getNegocioById(Integer idNegocio);
}
