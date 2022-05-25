package com.digitalhouse.demo;

import com.digitalhouse.demo.model.Leon;
import com.digitalhouse.demo.model.Tigre;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class Aplicacion {
    private static final Logger logger = Logger.getLogger(Aplicacion.class);
    public static final String RUTA_ABSOLUTA_ARCHIVO_PROPIEDADES = "/home/rcastillo/ws/ws-digital/modulos/c10 Logueo y Traza/Randy's Class/logytraza/logytraza/src/config/log4j.properties";

    public static void main(String[] args) {
        File log4jfile = new File(RUTA_ABSOLUTA_ARCHIVO_PROPIEDADES);
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());

        logger.info("Test de logger");

        Leon leon = new Leon();
        leon.setEdad(4);
        leon.setNombre("Leon de prueba");
        leon.setEsAlfa(true);
        leon.correr();
        try {
            leon.esMayorA10();
        } catch (Exception e) {
            logger.error("La edad del leon " + leon.getNombre() + "es incorrecto");
        }

        Leon leon2 = new Leon();
        leon2.setEdad(-1);
        leon2.setNombre("Leon de prueba");
        leon2.setEsAlfa(true);
        leon2.correr();

        leon2.correr();
        try {
            leon2.esMayorA10();
        } catch (Exception e) {
            logger.error("La edad del leon " + leon2.getNombre() + "es incorrecto");
        }




    }
}
