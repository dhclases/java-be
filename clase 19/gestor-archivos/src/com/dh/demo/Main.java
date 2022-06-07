package com.dh.demo;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Perro dog1 = new Perro(1,"Tyson");
        Perro dog2 = new Perro(2,"Tokyo");

        List<Perro> perros = new ArrayList<>();
        List<Perro> perros2 ;

        perros.add(dog1);
        perros.add(dog2);

        ArchivoHelper fileHelper =new ArchivoHelper();

       // fileHelper.guardarListaPerros(perros);
       fileHelper.guardarListaPerrosV2(perros);

        perros2 = fileHelper.recuperListaPerrosV2();

        for (Perro perro : perros2)
        {
            System.out.println(perro.getNombre() + " -" + perro.getEdad());
        }

        String contents = "Epa Team !!! \n Saludos NIO";
        fileHelper.escribirArchivoWithNIO(contents);
        fileHelper.leerArchivoWithNIO();

    }
}
