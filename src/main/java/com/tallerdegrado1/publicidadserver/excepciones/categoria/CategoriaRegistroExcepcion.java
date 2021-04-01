package com.tallerdegrado1.publicidadserver.excepciones.categoria;

public class CategoriaRegistroExcepcion extends CategoriaExcepcion{
    public CategoriaRegistroExcepcion() {
        this("Categoria ya registrada");
    }
    public CategoriaRegistroExcepcion(String mensaje) {
        super(mensaje);
    }
}
