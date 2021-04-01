package com.tallerdegrado1.publicidadserver.repositorios;

import com.tallerdegrado1.publicidadserver.modelo.DetalleProducoNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoNegocioRepositorio  extends JpaRepository<DetalleProducoNegocio,Integer> {

}
