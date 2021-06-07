package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        Button editProfileButton = findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(this::editProfileOnClickHandler);
    }


    private void editProfileOnClickHandler(View v){
        Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
        startActivity(intent);
    }
}