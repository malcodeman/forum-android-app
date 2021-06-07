package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class CreatePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        Button postBtn = findViewById(R.id.postBtn);
        postBtn.setOnClickListener(this::onPostHandler);

        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.text_post);
    }

    private void onPostHandler(View v) {
        EditText title = findViewById(R.id.titleInput);
        EditText text = findViewById(R.id.textInput);
        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());

        if (title.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Title too short!", Toast.LENGTH_LONG).show();
            title.requestFocus();
        } else {
            Post post = new Post(title.getText().toString(), text.getText().toString());
            db.postDao().insertPosts(post);
            Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
            startActivity(intent);
        }
    }

}