package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signUpText = findViewById(R.id.signUpText);
        signUpText.setOnClickListener(this::onSignUpClickHandler);
    }

    private void onSignUpClickHandler(View v) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}