package com.digitalhouse.demo.util;

public final class ConsultaSQL {
    public static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " EMPRESA varchar(100) NOT NULL, "
            + " EDAD INT NOT NULL,"
            + " FECHA_INICIO varchar(100) NOT NULL"
            + " )";
    public static final String SQL_INSERT_EMPLEADO1 =  "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (1,'Javier','Digital',28,'12/10/2020')";
    public static final String SQL_INSERT_EMPLEADO2 =  "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (2,'Pepe','Facebook',40,'09/11/2020')";
    public static final String SQL_INSERT_EMPLEADO3 =  "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (3,'Diego','Google',33,'12/20/2021')";
}
