package com.tallerdegrado1.publicidadserver.excepciones.usuario;

public class UsuarioNoEncontrado extends UsuarioExcepcion{
    public UsuarioNoEncontrado(){
        this("Usuario no encontrado");
    }
    public UsuarioNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
