package com.digitalhouse.demo;

import com.digitalhouse.demo.persistencia.EmpleadoH2;
import com.digitalhouse.demo.util.ConsultaSQL;
import com.digitalhouse.demo.util.H2Gestor;
import com.digitalhouse.demo.util.LogGestor;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class Aplicacion {

    // Definir logger
    public static final Logger logger = Logger.getLogger(Aplicacion.class);

    public static void main(String[] args) throws SQLException {
        try {
            // Inicializar logger
            LogGestor.inicializar();

            // Indicar inicio de proceso
            logger.info("*** Inicio Proceso ****");

            Connection conn = H2Gestor.getConnection();

            if (!conn.isClosed()) {
                logger.info("Connection is open !!");
            }

            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_CREATE_TABLE);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_EMPLEADO1);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_EMPLEADO2);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_EMPLEADO3);

            // Inicializar SQL Empleado

            EmpleadoH2 empleadoDB = new EmpleadoH2();


            // Listar empleados
            empleadoDB.listarEmpleado(conn);


            // Eliminar empleado
            empleadoDB.eliminarEmpleadoporId(conn,2);
            logger.info(" Eliminacion de Empleado *** Inicio");
            // Listar empleados
            empleadoDB.listarEmpleado(conn);
            logger.info(" Eliminacion de Empleado *** Fin");

            // Forzar un error
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_EMPLEADO1);

        } catch (Exception e) {
            // Loggear error
            logger.error(e.getMessage());
            // e.printStackTrace();
        }

        // Indicar inicio de proceso
        logger.info("*** Fin de  Proceso ****");
    }

}

//TODO: Definir log de clase
//TODO: Inicializar log
//TODO: Indicar si la conexion esta abierta
//TODO: Indicar Inicio y fin de proceso

