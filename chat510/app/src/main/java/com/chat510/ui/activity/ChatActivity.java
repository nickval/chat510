package com.chat510.ui.activity;

import java.util.ArrayList;
import java.util.List;

import com.chat510.ui.adapters.ChatListAdapter;
import com.chat510.entity.Message;
import com.chat510.R;
import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class ChatActivity extends Activity {
	private static final String TAG = ChatActivity.class.getName();
	private static String sUserId;

	public static final String USER_ID_KEY = "userId";

	private EditText etMessage;
	private Button btSend;
	
	private ListView lvChat;
	private ArrayList<Message> mMessages;
	private ChatListAdapter mAdapter;
	
	private String url510 = "http://510.com.ua";
	private String urlYoutube = "https://m.youtube.com/user/GennadiyBalashov/";
	
	// Create a handler which can run code periodically
	private Handler handler = new Handler();

	private static final int MAX_CHAT_MESSAGES_TO_SHOW = 100;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		// User login
		if (ParseUser.getCurrentUser() != null) { // start with existing user
			startWithCurrentUser();
		} else { // If not logged in, login as a new anonymous user
			login();
		}
		// Youtube Button Code
        ImageButton btnYoutube = (ImageButton)findViewById(R.id.btYoutube);
		btnYoutube.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("YoutubeButton", urlYoutube);
				startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(urlYoutube)));
			}
		});

        ImageButton btn510 = (ImageButton)findViewById(R.id.bt510);
		btn510.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url510)));			
			}
		});
		
	    // Run the runnable object defined every 100ms
	    handler.postDelayed(runnable, 100);	    
	}
	
	// Defines a runnable which is run every 100ms
	private Runnable runnable = new Runnable() {
	    @Override
	    public void run() {
	       refreshMessages();
	       handler.postDelayed(this, 3000);
	    }
	};

	private void refreshMessages() {
	    receiveMessage(); 
	    Log.d("receive message", "done");
	}

	private void startWithCurrentUser() {
	    sUserId = ParseUser.getCurrentUser().getObjectId();  
	    setupMessagePosting();
	}


	// Create an anonymous user using ParseAnonymousUtils and set sUserId
	private void login() {
		ParseAnonymousUtils.logIn(new LogInCallback() {

			@Override
			public void done(ParseUser user, ParseException e) {
				// TODO Auto-generated method stub
				if (e != null) {
					Log.d(TAG, "Anonymous login failed.");
				} else {
					startWithCurrentUser();
				}
			}
		});
	}
	
	
	// Setup message field and posting
	private void setupMessagePosting() {
	        etMessage = (EditText) findViewById(R.id.etMessage);
	        btSend = (Button) findViewById(R.id.btSend);
	        lvChat = (ListView) findViewById(R.id.lvChat);
	        mMessages = new ArrayList<Message>();
	        mAdapter = new ChatListAdapter(ChatActivity.this, sUserId, mMessages);
	        lvChat.setAdapter(mAdapter);
	        btSend.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View v) {
	                String body = etMessage.getText().toString();
	                // Use Message model to create new messages now      
	                Message message = new Message();
	                message.setUserId(sUserId);
	                message.setBody(body);
	                message.saveInBackground(new SaveCallback() {
	                    @Override
	                    public void done(ParseException e) {
	                        receiveMessage();
	                    }
	                });
	                etMessage.setText("");
	            }
	    });
	}
	
	// Query messages from Parse so we can load them into the chat adapter
	private void receiveMessage() {
	                // Construct query to execute
	        ParseQuery<Message> query = ParseQuery.getQuery(Message.class);
	        query.setLimit(MAX_CHAT_MESSAGES_TO_SHOW);
	        query.orderByAscending("createdAt");
	                // Execute query for messages asynchronously
	        query.findInBackground(new FindCallback<Message>() {
	            public void done(List<Message> messages, ParseException e) {
	                if (e == null) {                    
	                    mMessages.clear();
	                    mMessages.addAll(messages);
	                    mAdapter.notifyDataSetChanged();
	                    lvChat.invalidate();
	                } else {
	                    Log.d("message", "Error: " + e.getMessage());
	                }
	            }
	        });
	}
}