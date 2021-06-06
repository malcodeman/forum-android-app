package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this::onActionButtonClickHandler);
        listPosts();
    }

    private void onActionButtonClickHandler(View v) {
        Intent intent = new Intent(getApplicationContext(), CreatePostActivity.class);
        startActivity(intent);
    }

    private void listPosts() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Post> posts = db.postDao().getAll();
        ListView listView = (ListView) findViewById(R.id.postsListView);
        String[] titles = new String[posts.size()];
        for (int i = 0; i < posts.size(); i++) {
            titles[i] = posts.get(i).getTitle();
        }
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, titles));
    }
}