package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.edit_profile);

        Button saveButton = findViewById(R.id.editProfileSaveButton);
        saveButton.setOnClickListener(this::onSaveClickHandler);
    }

    private void onSaveClickHandler(View v) {
        EditText displayNameInput = findViewById(R.id.displayNameInput);
        EditText descriptionInput = findViewById(R.id.descriptionInput);
        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
        User user = db.userDao().getById(1);
        user.displayName = displayNameInput.getText().toString();
        user.about = descriptionInput.getText().toString();
        db.userDao().update(user);
        Toast.makeText(getApplicationContext(), "Saved successfully!", Toast.LENGTH_LONG).show();
        goToMain();
    }

    private void goToMain() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}