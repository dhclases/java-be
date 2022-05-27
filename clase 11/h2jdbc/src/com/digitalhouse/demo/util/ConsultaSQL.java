package com.digitalhouse.demo.util;

public final class ConsultaSQL {

        /* Forma i
    public static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " TIPO varchar(100) NOT NULL "
            + " )";
    */


    public static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES
             (  ID INT PRIMARY KEY,
                NOMBRE varchar(100) NOT NULL,
                TIPO varchar(100) NOT NULL )
            """;

    public static final String SQL_INSERT_ANIMAL_1 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (1, 'Pancho', 'Perro')";
    public static final String SQL_INSERT_ANIMAL_2 = " INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (2, 'Pillo', 'Gato')";
    public static final String SQL_INSERT_ANIMAL_3 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (3, 'Cepillo', 'Elefante')";
    public static final String SQL_INSERT_ANIMAL_4 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (4, 'Pepe', 'Perro')";
    public static final String SQL_INSERT_ANIMAL_5 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (5, 'Rolo', 'Caballo')";


}
