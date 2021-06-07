package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FeedActivity extends AppCompatActivity {
    public static final String POST_ID = "FeedActivity/POST_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        ListView listView  = findViewById(R.id.postsListView);
        floatingActionButton.setOnClickListener(this::onActionButtonClickHandler);
        listView.setOnItemClickListener(this::listItemOnClickHandler);
        initializeListAdapter();
    }

    private void listItemOnClickHandler(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), PostDetailsActivity.class);
        intent.putExtra(POST_ID, id);
        startActivity(intent);
    }

    private void initializeListAdapter() {
        List<Post> items = AppDatabase.getDbInstance(getApplicationContext()).postDao().getAll();
        PostListAdapter adapter = new PostListAdapter(this, items);
        ListView listView = findViewById(R.id.postsListView);
        listView.setAdapter(adapter);
    }

    private void onActionButtonClickHandler(View v) {
        Intent intent = new Intent(getApplicationContext(), CreatePostActivity.class);
        startActivity(intent);
    }
}