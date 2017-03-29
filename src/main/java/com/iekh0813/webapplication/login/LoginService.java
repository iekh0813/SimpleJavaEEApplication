package com.iekh0813.webapplication.login;

import com.iekh0813.dao.UserDAO;

public class LoginService {
    String password;

    public LoginService() {
    }

    public boolean isUserValid(String userName, Integer password) {
        System.out.println("login: " + userName + ", password: " + password);
        return password.equals(UserDAO.getHashCodeForUser(userName));
    }
}
