package com.tallerdegrado1.publicidadserver.excepciones.producto;


public class ProductoNoEncontrado extends ProductoExcepcion {
    public ProductoNoEncontrado() {
        this("Producto no encontrado");
    }

    public ProductoNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
