package com.digitalhouse.demo;

import com.digitalhouse.demo.persitencia.AnimalesH2;
import com.digitalhouse.demo.util.ConsultaSQL;
import com.digitalhouse.demo.util.H2Gestor;

import java.sql.Connection;
import java.sql.SQLException;

public class Aplicacion {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            conn = H2Gestor.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!conn.isClosed()) {
            System.out.println("Connection is open !!");
        }

        H2Gestor.executeSQL(conn, ConsultaSQL.SQL_CREATE_TABLE);

        H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL_1);
        H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL_2);
        H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL_3);
        H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL_4);
        H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL_5);

        AnimalesH2.listarAnimales(conn);

        AnimalesH2.eliminarAnimalPorId(conn, 1);
        System.out.println("**************************");
        AnimalesH2.listarAnimales(conn);

        conn.isClosed();
    }
}

//TODO: Definir las consultas. Clase de Constantes
//TODO: Definir clase utilitaria para 3el manejo de jdbc: getConnection, executeSQL y executeQuery
//TODO: Definir persistencia de Animaeles: listarAnimales y eliminarAnimal por ID
//TODO: Crear el programa princial, aq abra la conn, crear table e insertar los registros y eliminar un animal

