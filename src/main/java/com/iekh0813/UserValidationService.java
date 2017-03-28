package com.iekh0813;

public class UserValidationService {

    public boolean isUserValid(String user, String password) {
        return "aaa".equals(user) && ("bbb".equals(password));
    }
}
