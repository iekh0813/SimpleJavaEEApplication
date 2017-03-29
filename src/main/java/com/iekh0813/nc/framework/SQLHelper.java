package com.iekh0813.nc.framework;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

public class SQLHelper {

    public static Connection getConnection() {
        return SQLConnectionHelper.getInstance().getConnection();
    }

    public static void cleanUp(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            System.out.println("failed to close SQL ResultSet");
            System.out.println(e);
        }

        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            System.out.println("failed to close SQL Statement");
            System.out.println(e);
        }

        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("failed to close SQL Connection");
            System.out.println(e);
        }
    }

    public static void setupParameters(PreparedStatement stmt, Object[] parameters) throws SQLException {
        if (parameters != null) {
            for (int i = 1; i <= parameters.length; i++) {
                Object param = parameters[i - 1];
                if (param == null)
                    throw new NullPointerException("parameter #" + i + " is null");
                else if (param instanceof BigDecimal)
                    stmt.setBigDecimal(i, (BigDecimal) param);
                else if (param instanceof BigInteger)
                    stmt.setBigDecimal(i, TypesConverter.bigIntegerToBigDecimal((BigInteger) param));
                else if (param instanceof Integer)
                    stmt.setInt(i, ((Integer) param).intValue());
                else if (param instanceof String)
                    stmt.setString(i, (String) param);
                else
                    throw new IllegalArgumentException("parameter type is not supported, "
                            + param.getClass().toString());
            }
        }
    }

    public static String fetchSingleValue(String query, Object[] parameters) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(query);
            setupParameters(stmt, parameters);
            rs = stmt.executeQuery();
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException e) {
            System.out.println("failed to execute query\n" + query);
            System.out.println(e);
            throw new RuntimeException(e);
        } finally {
            cleanUp(conn, stmt, rs);
        }
    }
}
