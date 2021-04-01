package com.tallerdegrado1.publicidadserver.excepciones.producto;

public class ProductoRegistradoExcepcion extends ProductoExcepcion{
    public ProductoRegistradoExcepcion() {
        this("Prodcuto ya Registrado");
    }
    public  ProductoRegistradoExcepcion(String mensaje)
    {super(mensaje);}
}
