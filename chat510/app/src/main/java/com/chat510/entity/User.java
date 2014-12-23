package com.chat510.entity;

import java.util.Date;

/**
 * Created by MoNyA on 23.12.2014.
 */
public class User {
    private String login;
    private String password;
    private UserData userData;

    public User(String password, String login) {
        this.password = password;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }


}
