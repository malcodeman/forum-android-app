package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView logInText = findViewById(R.id.logInText);
        logInText.setOnClickListener(this::onLogInClickHandler);
    }

    private void onLogInClickHandler(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}