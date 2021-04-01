package com.tallerdegrado1.publicidadserver.excepciones.categoria;

import com.tallerdegrado1.publicidadserver.excepciones.usuario.UsuarioExcepcion;

public class CategoriaNoEncontrada extends CategoriaExcepcion {
    public CategoriaNoEncontrada() {
        this("Categoria no encontrado");
    }

    public CategoriaNoEncontrada(String mensaje) {
        super(mensaje);

    }
}
