package com.dh.clinica.dao.impl;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.util.H2Gestor;
import com.dh.clinica.util.UtilFechas;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PacienteDaoH2 implements PatronDao<Paciente> {


    final static Logger log = Logger.getLogger(PacienteDaoH2.class);
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/clinica;";
    private final static String DB_USER = "";
    private final static String DB_PASSWORD = "";
    private UtilFechas utilFechas;

    private H2Gestor utilDb;

    public PacienteDaoH2() {
        this.utilDb = new H2Gestor();
        this.utilFechas = new UtilFechas();
        this.utilFechas = new UtilFechas();
    }

    public void crearTabla() throws SQLException {
        log.debug("Se crea la tabla de Paciente.");

        Connection conn = utilDb.getConnection();

        String sql_create_table = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE"
                + "("
                + "IDPACIENTE IDENTITY NOT NULL PRIMARY KEY,"
                + "APELLIDO VARCHAR(100) NOT NULL,"
                + "NOMBRE VARCHAR(100) NOT NULL,"
                + "DNI INT NOT NULL,"
                + "FECHA_DE_INGRESO DATE NOT NULL"
                + ")";

        utilDb.executeSQL(conn, sql_create_table);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        String PACIENTE_INSERT = "INSERT INTO PACIENTE(apellido,nombre,dni,FECHA_DE_INGRESO) VALUES(?,?,?,?)";
        log.debug("Registrando un nuevo paciente : " + paciente.toString());

        Connection connection;
        PreparedStatement psInsert;


        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            psInsert = connection.prepareStatement(PACIENTE_INSERT, Statement.RETURN_GENERATED_KEYS);
            //2.2 Colocar los parametro
            psInsert.setString(1, paciente.getApellido());
            psInsert.setString(2, paciente.getNombre());
            psInsert.setInt(3, paciente.getDni());
            psInsert.setDate(4,  utilFechas.convertirStringADate(paciente.getFechaIngreso()));

            //3 Ejecutar una sentencia SQL y seteamos el ID
            paciente.setId(utilDb.executeUpdateAndGetId(psInsert));

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        log.debug("Buscando Paciente con id : " + id);

        Connection connection;
        PreparedStatement preparedStatement;
        Paciente paciente = null;

        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTE where IDPACIENTE = ?");
            preparedStatement.setInt(1, id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados. Se mapean los resultado resultset vs Entidad
            while (result.next()) {
                paciente = crearObjectoPaciente(result);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return paciente;
    }

    @Override
    public void eliminarPorId(Integer id) {
        log.debug("Eliminando Paciente con id : " + id);

        Connection connection;
        PreparedStatement pDelete;


        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            pDelete = connection.prepareStatement("DELETE FROM PACIENTE where IDPACIENTE = ?");
            pDelete.setInt(1, id);

            utilDb.executeUpdate(pDelete);


        } catch (SQLException e) {
            log.error("ERROR: No implementado");
            log.error(e.getMessage());
        }
    }

    private Paciente crearObjectoPaciente(ResultSet result) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setId(result.getInt("IDPACIENTE"));
        paciente.setNombre(result.getString("NOMBRE"));
        paciente.setApellido(result.getString("APELLIDO"));
        paciente.setDni(result.getInt("DNI"));
        paciente.setFechaIngreso(utilFechas.convertirDateAString(result.getDate("FECHA_DE_INGRESO")));
        return paciente;
    }

    public List<Paciente> buscarTodos() {
        log.debug("Buscando todos los pacientes ");
        String PACIENTE_SELECT_ALL = "SELECT * FROM PACIENTE";

        Connection connection;
        PreparedStatement preparedStatement;
        List<Paciente> pacientes = new ArrayList<>();

        try {
            //1 Levantar el driver y Conectarnos
            connection = utilDb.getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement(PACIENTE_SELECT_ALL);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados. Se mapean los resultado resultset vs Entidad
            while (result.next()) {
                pacientes.add(crearObjectoPaciente(result));
            }

            preparedStatement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return pacientes;
    }
}