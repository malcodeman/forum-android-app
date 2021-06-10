package com.example.forumandroidapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FeedFragment extends Fragment {
    public static final String POST_ID = "FeedActivity/POST_ID";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = requireView().findViewById(R.id.postsListView);
        listView.setOnItemClickListener(this::listItemOnClickHandler);
        initializeListAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.home);
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    private void listItemOnClickHandler(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(getActivity().getApplicationContext(), PostDetailsActivity.class);
        intent.putExtra(POST_ID, id);
        startActivity(intent);
    }

    private void initializeListAdapter() {
        List<Post> items = AppDatabase.getDbInstance(getActivity().getApplicationContext()).postDao().getAll();
        PostListAdapter adapter = new PostListAdapter(getActivity().getApplicationContext(), items);
        ListView listView = getView().findViewById(R.id.postsListView);
        listView.setAdapter(adapter);
        if(items.size() == 0){
            TextView emptyState = getView().findViewById(R.id.emptyState);
            emptyState.setVisibility(View.VISIBLE);
        }
    }
}