package com.tallerdegrado1.publicidadserver.excepciones.usuario;

public class UsuarioRegistradoExcepcion extends UsuarioExcepcion{
    public UsuarioRegistradoExcepcion(){
        this("Usuario ya registrado");
    }
    public UsuarioRegistradoExcepcion(String mensaje) {
        super(mensaje);
    }
}
