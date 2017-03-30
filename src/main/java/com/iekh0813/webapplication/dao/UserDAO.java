package com.iekh0813.webapplication.dao;


import com.iekh0813.nc.framework.SQLHelper;

public class UserDAO {
    public static Integer getHashCodeForUser(String userName) {
        final String query = "select password from users where name = ?";
        String result = SQLHelper.fetchSingleValue(query, new Object[]{userName});

        if (result != null) {
            return Integer.valueOf(result);
        }
        return null;
    }
}
