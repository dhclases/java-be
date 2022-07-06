package com.dh.demo.saa;

public class SistemaAireAcondicionado {

    private Termometro termometro;
    private double limiteTemperatura;
    private boolean activar;

    public SistemaAireAcondicionado () {
        activar = false;
    }

    public void verificarTemperatura() {
        this.activar = (termometro.getTemperatura() >= limiteTemperatura);
    }

    public boolean isActivo() {
        return activar;
    }

    public void setTermometro(Termometro termometro) {
        this.termometro = termometro;
    }

    public void setLimiteTemperatura(double limiteTemperatura) {
        this.limiteTemperatura = limiteTemperatura;
    }
}
