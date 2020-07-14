package com.example.pruebadaggerlogin.login;

public interface LoginRepository {
    void saveUser(UserPojo user);

    UserPojo getUser();
}
