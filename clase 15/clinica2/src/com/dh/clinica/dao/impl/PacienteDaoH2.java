package com.dh.clinica.dao.impl;

import com.dh.clinica.dao.PatronDao;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.util.H2Gestor;
import org.apache.log4j.Logger;


import java.sql.*;


public class PacienteDaoH2 implements PatronDao<Paciente> {


    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/test;";
    private final static String DB_USER = "";
    private final static String DB_PASSWORD = "";
    H2Gestor utilDb;

    final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public PacienteDaoH2() {
        this.utilDb = new H2Gestor();
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        log.debug("Registrando un nuevo paciente : " + paciente.toString());

        Connection connection = null;
        PreparedStatement psInsert = null;


        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            psInsert = connection.prepareStatement("INSERT INTO medicamentos(nombre,laboratorio,cantidad,precio) VALUES(?,?,?,?)");
            //2.2 Colocar los parametro
            psInsert.setString(1, paciente.getNombres());
            psInsert.setString(2, paciente.getApellidos());

            //3 Ejecutar una sentencia SQL
            utilDb.executeUpdate(psInsert);

        } catch (SQLException  e) {
            log.error(e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        log.debug("Buscando medicamento con id : " + id);

        Connection connection;
        PreparedStatement preparedStatement;
        Paciente paciente = null;

        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id,nombre,laboratorio,cantidad,precio  FROM medicamentos where id = ?");
            preparedStatement.setInt(1, id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados. Se mapean los resultado resultset vs Entidad
            while (result.next()) {

                paciente = new Paciente();
                paciente.setId(result.getInt("id"));
                paciente.setNombres(result.getString("nombres"));
                paciente.setApellidos(result.getString("nombres"));

            }

            preparedStatement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return paciente;
    }

    @Override
    public void EliminarPorId(Integer id) {
        log.error("ERROR: No implementado");
    }
}