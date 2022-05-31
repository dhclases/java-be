package com.dh.medicamentos.dao.impl;

import com.dh.medicamentos.dao.PatronDao;
import com.dh.medicamentos.model.Medicamento;
import org.apache.log4j.Logger;


import java.sql.*;


public class MedicamentoDaoH2 implements PatronDao<Medicamento> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    private final static String DB_URL = "jdbc:h2:~/test;";
    private final static String DB_USER ="";
    private final static String DB_PASSWORD = "";

    final static Logger log = Logger.getLogger(MedicamentoDaoH2.class);


    @Override
    public Medicamento guardar(Medicamento medicamento) {
        log.debug("Registrando un nuevo medicamento : "+ medicamento.toString());

        Connection connection = null;
        PreparedStatement psInsert = null;

        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            psInsert = connection.prepareStatement("INSERT INTO medicamentos(nombre,laboratorio,cantidad,precio) VALUES(?,?,?,?)");
            //2.2 Colocar los parametro

            psInsert.setString(1, medicamento.getNombre());
            psInsert.setString(2, medicamento.getLaboratorio());
            psInsert.setInt(3, medicamento.getCantidad());
            psInsert.setDouble(4, medicamento.getPrecio());

            //3 Ejecutar una sentencia SQL
            psInsert.executeUpdate();
            psInsert.close();

        } catch (SQLException | ClassNotFoundException e) {
            log.error("Upps");
            log.error(e.getMessage());
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        log.debug("Buscando medicamento con id : "+id);

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamento = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id,nombre,laboratorio,cantidad,precio  FROM medicamentos where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados. Se mapean los resultado resultset vs Entidad
            while (result.next()) {
                 // Forma 1
                int idMedicamento = result.getInt("id");
                String nombre = result.getString("nombre");
                String laboratorio = result.getString("laboratorio");
                Integer cantidad = result.getInt("cantidad");
                Double precio = result.getDouble("precio");
                medicamento = new Medicamento(idMedicamento,nombre,laboratorio,cantidad,precio);



                /* Forma 2

                Medicamento medicamento2 = new Medicamento();
                medicamento.setId(result.getInt("id"));
                medicamento.setNombre(result.getString("nombre"));
                medicamento.setCantidad(result.getInt("cantidad"));
                medicamento.setLaboratorio(result.getString("laboratorio"));
                medicamento.setPrecio(result.getDouble("precio"));


                 */

            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }

        return medicamento;
    }
}