package com.example.forumandroidapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePostFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button postBtn = getView().findViewById(R.id.postBtn);
        postBtn.setOnClickListener(this::onPostHandler);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.text_post);
        return inflater.inflate(R.layout.fragment_create_post, container, false);
    }

    private void onPostHandler(View v) {
        EditText title = getView().findViewById(R.id.titleInput);
        EditText text = getView().findViewById(R.id.textInput);
        AppDatabase db = AppDatabase.getDbInstance(getActivity().getApplicationContext());

        if (title.getText().length() == 0) {
            Toast.makeText(getActivity().getApplicationContext(), "Title too short!", Toast.LENGTH_LONG).show();
            title.requestFocus();
        } else {
            Post post = new Post(title.getText().toString(), text.getText().toString());
            db.postDao().insertPosts(post);
            Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}