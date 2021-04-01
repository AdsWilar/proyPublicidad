package com.tallerdegrado1.publicidadserver.excepciones.negocio;

public class NegocioRegistradoExcepcion extends NegocioExcepcion{
    public NegocioRegistradoExcepcion() {
        this("Negocio ya Registrado");
    }
    public  NegocioRegistradoExcepcion(String mensaje)
    {super(mensaje);}
}
