package com.dh.clinica.util;


import org.apache.log4j.Logger;

import java.sql.*;

public class H2Gestor {

    public static final String H2_URL = "jdbc:h2:mem:clinica;DB_CLOSE_DELAY=-1";
    final static Logger log = Logger.getLogger(H2Gestor.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    public Connection getConnection()  {

        try {
            return DriverManager.getConnection(H2_URL);
        } catch (SQLException  e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void executeSQL(Connection conn, String sql) {
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet executeQuery(Connection conn, String sql) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void executeUpdate(PreparedStatement ps) {
        try {
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

    }


    public Integer executeUpdateAndGetId(PreparedStatement ps) {
        int id = 0;
        try {
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next())
                id = keys.getInt(1);
            ps.close();
        } catch (SQLException e) {
            log.error(e.getMessage());

        }
        return id;

    }

}
