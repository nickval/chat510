package com.chat510;

import com.chat510.datamodel.Message;
import com.chat510.entity.User;
import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

public class ChatApplication extends Application {
    private static final String YOUR_APPLICATION_ID = "VkdStfheqPagUrO7Hvprrxg92M389hk5xSwf6Umh";
    private static final String YOUR_CLIENT_KEY = "ybvqCrhbRlyuo3fmzXqcUkOlWikzB5fGWb4Imekp";

    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models here
        ParseObject.registerSubclass(Message.class);
        ParseObject.registerSubclass(User.class);
        // Existing initialization happens after all classes are registered
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);

    }
}
