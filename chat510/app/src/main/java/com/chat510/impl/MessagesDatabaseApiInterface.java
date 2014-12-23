package com.chat510.impl;

import java.util.ArrayList;

/**
 * Created by MoNyA on 23.12.2014.
 */
public interface MessagesDatabaseApiInterface {
    //Insert last 20 messagees
    public void insertMessages(ArrayList<String> messages);
    //Clean messages
    public void deleteMessages();
    //get last 20 messages
    public ArrayList<String> getMessages();
}
