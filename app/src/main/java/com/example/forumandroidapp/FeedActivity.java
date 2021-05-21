package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> users = db.userDao().getAllUsers();
        for (User user : users) {
            Log.e("TAG", user.username);
        }
    }
}