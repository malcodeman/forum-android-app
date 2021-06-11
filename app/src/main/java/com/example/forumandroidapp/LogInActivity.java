package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView signUpText = findViewById(R.id.signUpText);
        Button logInButton = findViewById(R.id.logInButton);
        signUpText.setOnClickListener(this::onSignUpClickHandler);
        logInButton.setOnClickListener(this::onLogInButtonClickHandler);
        preferences = new Preferences(this);
        if(preferences.getIsLoggedIn()){
            goToMain();
        }
    }

    private void goToMain(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private void onSignUpClickHandler(View v) {
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

    private void onLogInButtonClickHandler(View v) {
        EditText username = findViewById(R.id.logInUsername);
        EditText password = findViewById(R.id.logInPassword);
        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());

        if (username.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Username too short!", Toast.LENGTH_LONG).show();
            username.requestFocus();
        } else if (password.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Password too short!", Toast.LENGTH_LONG).show();
            password.requestFocus();
        } else {
            User user = db.userDao().getUserByUsernameAndPassword(username.getText().toString(), password.getText().toString());
            if (user != null) {
                preferences.saveUserId(user.uid);
                preferences.saveIsLoggedIn(true);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Username and password combination not found!", Toast.LENGTH_LONG).show();
            }
        }
    }
}