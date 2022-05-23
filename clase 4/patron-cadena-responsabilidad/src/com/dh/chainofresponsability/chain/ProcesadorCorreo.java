package com.dh.chainofresponsability.chain;

import com.dh.chainofresponsability.model.Correo;

public abstract class ProcesadorCorreo {

    // Atributos protegidos
    protected String correoAsignado;
    protected String asuntoporProcesar;
    protected ProcesadorCorreo siguienteProcesador;

    // Metodo cumun para las implementqacion
    public abstract String comprobar(Correo elMail);

    public ProcesadorCorreo getSiguiente() {
        return this.siguienteProcesador;
    }

    public void setSiguiente(ProcesadorCorreo processor) {
        this.siguienteProcesador = processor;
    }


    protected boolean esValidoElCorreo(Correo email) {

        return email.getDestino().equalsIgnoreCase(this.correoAsignado)
                || email.getAsunto().equalsIgnoreCase(this.asuntoporProcesar);
    }
}
