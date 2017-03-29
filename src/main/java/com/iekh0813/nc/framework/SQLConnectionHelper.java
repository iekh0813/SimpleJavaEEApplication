package com.iekh0813.nc.framework;


import javax.ejb.EJBException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnectionHelper {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/todo_service";
    static final String USER = "root";
    static final String PASS = "root";

    private static SQLConnectionHelper instance = null;

    public static SQLConnectionHelper getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (SQLConnectionHelper.class) {
            if (instance != null) {
                return instance;
            }
            instance = new SQLConnectionHelper();

            return instance;
        }
    }

    public Connection getConnection() throws EJBException {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
