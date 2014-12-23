package com.chat510.controller;

import com.chat510.datamodel.Message;
import com.chat510.entity.User;

import java.util.ArrayList;

/**
 * Created by MoNyA on 23.12.2014.
 */
public class ChatController {

    private static ChatController instance;
    private User currentUser;
    private ArrayList<Message> messages;

    private ChatController() {
    }

    public static ChatController getInstance() {
        if (instance == null) {
            instance = new ChatController();
        }
        return instance;
    }

}
