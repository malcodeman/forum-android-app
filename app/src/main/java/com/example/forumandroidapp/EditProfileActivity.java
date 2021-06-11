package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Objects;

public class EditProfileActivity extends AppCompatActivity {
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.edit_profile);

        Button saveButton = findViewById(R.id.editProfileSaveButton);
        Button randomizeImage = findViewById(R.id.randomizeProfileImageButton);
        saveButton.setOnClickListener(this::onSaveClickHandler);
        randomizeImage.setOnClickListener(this::onRandomizeAvatarImage);
        preferences = new Preferences(this);
        initializeUserData();
    }

    private void onRandomizeAvatarImage(View v) {
        Runnable r = this::initializeUserData;
        ImageService.setAvatarImage(getApplicationContext(), r);
    }

    private void initializeUserData() {
        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
        User user = db.userDao().getById(preferences.getSavedUserId());
        EditText displayNameInput = findViewById(R.id.displayNameInput);
        EditText descriptionInput = findViewById(R.id.descriptionInput);
        ImageView avatarImage = findViewById(R.id.editAvatarImage);
        displayNameInput.setText(user.displayName);
        descriptionInput.setText(user.about);
        if (user.avatarImage.length() != 0) {
            Picasso.get().load(user.avatarImage).into(avatarImage);
        }
    }

    private void onSaveClickHandler(View v) {
        EditText displayNameInput = findViewById(R.id.displayNameInput);
        EditText descriptionInput = findViewById(R.id.descriptionInput);
        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
        User user = db.userDao().getById(preferences.getSavedUserId());
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