package com.iekh0813.login;

public class LoginService {

    public boolean isUserValid(String user, String password) {
        //todo check by hashcode from DB
        return "aaa".equals(user) && ("bbb".equals(password));
    }
}
