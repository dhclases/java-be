package com.dh.clinica.dao.impl;

import com.dh.clinica.model.Domicilio;
import com.dh.clinica.util.H2Gestor;
import org.apache.log4j.Logger;

import java.sql.*;

public class DomicilioDaoH2 implements PatronDao<Domicilio> {
    final static Logger log = Logger.getLogger(DomicilioDaoH2.class);
    private H2Gestor utilDb;
    public DomicilioDaoH2() {
        this.utilDb = new H2Gestor();
    }

    public void crearTabla() throws SQLException {
        log.debug("Se crea la tabla de Domicilio.");
        Connection conn = utilDb.getConnection();

        String sql_create_table = "DROP TABLE IF EXISTS DOMICILIO; CREATE TABLE DOMICILIO"
                + "("
                + "IDDOMICILIO IDENTITY NOT NULL PRIMARY KEY,"
                + "CALLE VARCHAR(100) NOT NULL,"
                + "NUMERO INT NOT NULL,"
                + "LOCALIDAD VARCHAR(100) NOT NULL,"
                + "PROVINCIA VARCHAR(100) NOT NULL,"
                + "IDPACIENTE LONG NOT NULL"
                + ")";

        utilDb.executeSQL(conn, sql_create_table);
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        String DOMICILIO_INSERT = "INSERT INTO DOMICILIO(CALLE,NUMERO,LOCALIDAD,PROVINCIA,IDPACIENTE) VALUES(?,?,?,?,?)";
        log.debug("Registrando un nuevo Domicilio : " + domicilio.toString());
        Connection connection;
        PreparedStatement psInsert;
        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia y CONFIGURAR EL OBTENER ID
            psInsert = connection.prepareStatement(DOMICILIO_INSERT, Statement.RETURN_GENERATED_KEYS);

            //2.2 Colocar los parametro
            psInsert.setString(1, domicilio.getCalle());
            psInsert.setInt(2, domicilio.getNumero());
            psInsert.setString(3, domicilio.getLocalidad());
            psInsert.setString(4, domicilio.getProvincia());
            psInsert.setInt(5, domicilio.getIdPaciente());

            //3 Ejecutar una sentencia SQL
            domicilio.setIdDomicilio(utilDb.executeUpdateAndGetId(psInsert));

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        String DOMICILIO_SELECT_BY_ID = "SELECT * FROM DOMICILIO where IDPACIENTE = ?";
        log.debug("Buscando Domicilio con id : " + id);

        Connection connection;
        PreparedStatement preparedStatement;
        Domicilio domicilio = null;

        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement(DOMICILIO_SELECT_BY_ID);
            preparedStatement.setInt(1, id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados. Se mapean los resultado resultset vs Entidad
            while (result.next()) {
                domicilio = crearObjetoDomicilio(result);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return domicilio;
    }

    @Override
    public void eliminarPorId(Integer id) {
        log.debug("Eliminando Domicilio con idPaciente : " + id);

        Connection connection;
        PreparedStatement dDelete;

        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            dDelete = connection.prepareStatement("DELETE FROM DOMICILIO where IDPACIENTE = ?");
            dDelete.setInt(1, id);

            // Ejecuta y Cierra
            utilDb.executeUpdate(dDelete);

        } catch (SQLException e) {
            log.error("ERROR: No implementado");
            log.error(e.getMessage());
        }

    }

    private Domicilio crearObjetoDomicilio(ResultSet result) throws SQLException {
        Domicilio domicilio = new Domicilio();
        domicilio.setIdDomicilio(result.getInt("IDDOMICILIO"));
        domicilio.setCalle(result.getString("CALLE"));
        domicilio.setNumero(result.getInt("NUMERO"));
        domicilio.setLocalidad(result.getString("LOCALIDAD"));
        domicilio.setProvincia(result.getString("PROVINCIA"));
        domicilio.setIdPaciente(result.getInt("IDPACIENTE"));
        return domicilio;
    }
}
