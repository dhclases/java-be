package com.dh.demo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ArchivoHelper {

    public static final String PERROS_TXT = "perros.txt";

    public void guardarListaPerros(List<Perro> perros) {
        //Definimos el Stream
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(PERROS_TXT);

            // Creamos  ObjectOutputStream
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            // Escribimos el  output stream
            objOut.writeObject(perros);

            //Cerramos el objeto
            fileOut.close();

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }

    public List<Perro> recuperListaPerros() {
        //Recuperamos toda la colección con cada una de las paginas del archivo
        List<Perro> perros = null;
        try {
            // Definimos el objeto stream de archivo
            FileInputStream fileIn = new FileInputStream(PERROS_TXT);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            // Leemos los objetos perros
            perros = (ArrayList<Perro>) objIn.readObject();

            // Cerramos los recursos
            objIn.close();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
        return perros;
    }

    public void guardarListaPerrosV2(List<Perro> perros) {
        //Definimos el Stream
        try (FileOutputStream fileOut = new FileOutputStream(PERROS_TXT)) {
            // Creamos  ObjectOutputStream
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            // Escribimos el  output stream
            objOut.writeObject(perros);

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }

    public List<Perro> recuperListaPerrosV2() {
        //Recuperamos toda la colección con cada una de las paginas del archivo
        List<Perro> perros = null;
        try (FileInputStream fileIn = new FileInputStream(PERROS_TXT);
             ObjectInputStream objIn = new ObjectInputStream(fileIn)) {

            // Leemos los objetos perros
            perros = (ArrayList<Perro>) objIn.readObject();


        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
        return perros;
    }

    public void escribirArchivoWithNIO(String contents) {
        try {
            // Escribir archivo saludos
            Files.write(Paths.get("saludo.txt"), contents.getBytes());

        } catch (IOException e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }

    public void leerArchivoWithNIO() {
        try {
            // Leer todas las lineas saludo
            List<String> lines = Files.readAllLines(Paths.get("saludo.txt"));

            // imprimir todas las lineas
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void agregarLineaArchivoWithNIO(String linea, String nombreArchivo){
        try {

            // append to file
            Files.write(Paths.get(nombreArchivo), linea.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

