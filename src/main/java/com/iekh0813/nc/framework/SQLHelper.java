package com.iekh0813.nc.framework;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

public class SQLHelper {
    static final Logger logger = Logger.getLogger(SQLHelper.class);

    public static Connection getConnection() {
        return SQLConnectionHelper.getInstance().getConnection();
    }

    public static void cleanUp(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            logger.error("failed to close SQL ResultSet", e);
        }

        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            logger.error("failed to close SQL Statement", e);
        }

        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            logger.error("failed to close SQL Connection", e);
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
            logger.error("failed to execute query\n" + query, e);
            throw new RuntimeException(e);
        } finally {
            cleanUp(conn, stmt, rs);
        }
    }
}
