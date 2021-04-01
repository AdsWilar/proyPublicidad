package com.tallerdegrado1.publicidadserver.repositorios;

import com.tallerdegrado1.publicidadserver.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio  extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> getUsuarioByUsu(String usu);
}
