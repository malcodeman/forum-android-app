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
import android.widget.ListView;
import android.widget.TextView;


public class ProfileFragment extends Fragment {
    Preferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("");
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button editProfileButton = getView().findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(this::editProfileButtonOnClickHandler);
        preferences = new Preferences(getContext());
        initializeUserData();
    }

    private void initializeUserData() {
        User user = preferences.getSavedUserInfo();
        TextView displayNameText = getView().findViewById(R.id.profileDisplayName);
        TextView usernameText = getView().findViewById(R.id.profileUsername);
        TextView aboutText = getView().findViewById(R.id.profileAbout);
        displayNameText.setText(user.displayName);
        usernameText.setText(user.username);
        aboutText.setText(user.about);
    }

    private void editProfileButtonOnClickHandler(View v) {
        Intent intent = new Intent(getActivity().getApplicationContext(), EditProfileActivity.class);
        startActivity(intent);
    }
}