package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView logInText = findViewById(R.id.logInText);
        Button signUpButton = findViewById(R.id.signUpButton);
        logInText.setOnClickListener(this::onLogInClickHandler);
        signUpButton.setOnClickListener(this::onSignUpClickHandler);
    }

    private void onLogInClickHandler(View v) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

    private boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void onSignUpClickHandler(View v) {
        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
        EditText email = findViewById(R.id.email);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        if (email.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Email too short!",
                    Toast.LENGTH_LONG).show();
            email.requestFocus();
        } else if (!isEmailValid(email.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Email not valid!",
                    Toast.LENGTH_LONG).show();
            email.requestFocus();
        } else if (username.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Username too short!",
                    Toast.LENGTH_LONG).show();
            username.requestFocus();
        } else if (password.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Password too short!",
                    Toast.LENGTH_LONG).show();
            password.requestFocus();
        } else {
            User user = new User(email.getText().toString(), username.getText().toString(), password.getText().toString(), "", "");
            db.userDao().insertUsers(user);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}