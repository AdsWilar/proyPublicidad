package com.tallerdegrado1.publicidadserver.excepciones.negocio;

public class NegocioNoEncontrado extends NegocioExcepcion {
    public NegocioNoEncontrado() {
        this("Negocio no encontrado");
    }

    public NegocioNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
