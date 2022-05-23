package com.dh.chainofresponsability.chain;

import com.dh.chainofresponsability.model.Correo;

public class ProcesadorCorreoComercial extends ProcesadorCorreo {

    public ProcesadorCorreoComercial() {
        this.correoAsignado = "comercial@micolmena.com";
        this.asuntoporProcesar = "comercial";
    }

    @Override
    public String comprobar(Correo email) {
        String mensaje = "";

        if (this.esValidoElCorreo(email)) {
            mensaje = "Enviando a Comercial";
        } else {
            if (this.getSiguiente() != null) {
                mensaje = this.getSiguiente().comprobar(email);
            }
        }
        return mensaje;
    }
}
