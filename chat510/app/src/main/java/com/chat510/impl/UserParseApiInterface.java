package com.chat510.impl;

import com.chat510.entity.User;

/**
 * Created by MoNyA on 23.12.2014.
 */
public interface UserParseApiInterface {
    //get user from Parse
    public User getUser();
    //Save user to Parse
    public void saveUser(User user);

}
