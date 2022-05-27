package com.digitalhouse.demo.persistencia;

import com.digitalhouse.demo.model.Empleado;
import org.apache.log4j.Logger;

import java.sql.*;


public class EmpleadoH2 {
    public static final Logger logger = Logger.getLogger(EmpleadoH2.class);
    public void listarEmpleado(Connection connection) {
        String sql = "SELECT * FROM Empleado";
        try {
            Statement sqlSmt = connection.createStatement();
            ResultSet rs = sqlSmt.executeQuery(sql);
            // Proceso de Mapping Resultset to Object
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setID(rs.getInt("ID"));
                empleado.setNombre(rs.getString("NOMBRE"));
                empleado.setEmpresa(rs.getString("EMPRESA"));
                empleado.setEdad(rs.getInt("EDAD"));
                empleado.setFecha_inicio(rs.getString("FECHA_INICIO"));

                logger.info(empleado);

            }
            rs.close();
            sqlSmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void eliminarEmpleadoporId(Connection conn, int id) {
        String sql = "DELETE FROM EMPLEADO WHERE ID=?";

        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setInt(1, id);

            if (prepareStatement.execute()) {
                logger.info("Registro eliminado");
            }
            prepareStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
