package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PostDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        handleIntent();
    }

    private void handleIntent(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long uid = extras.getLong(FeedActivity.POST_ID);
            Post post = AppDatabase.getDbInstance(getApplicationContext()).postDao().getById((int) uid);

            TextView title = findViewById(R.id.postDetailsTitle);
            TextView text = findViewById(R.id.postDetailsText);

            title.setText(post.getTitle());
            text.setText(post.getText());
        }
    }

}