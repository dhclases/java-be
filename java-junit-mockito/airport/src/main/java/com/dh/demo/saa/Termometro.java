package com.dh.demo.saa;

public class Termometro {

    private double temperatura;
    private Sensor sensor;

    public double getTemperatura() {
        if (sensor.isBlocked()) {
            throw new RuntimeException("Sensor bloqueado");
        }
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

}
