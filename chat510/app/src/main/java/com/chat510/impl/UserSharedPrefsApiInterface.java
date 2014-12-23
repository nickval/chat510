package com.chat510.impl;

import com.chat510.entity.User;

/**
 * Created by MoNyA on 23.12.2014.
 */
public interface UserSharedPrefsApiInterface {

    //Get user from SharedPrefs
    public User getUser();
    //Set user to SharedPrefs
    public void setUser(User user);
}
