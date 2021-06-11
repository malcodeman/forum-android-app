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
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {
    Preferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("");
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button editProfileButton = getView().findViewById(R.id.editProfileButton);
        Button logOutButton = getView().findViewById(R.id.logOutButton);
        editProfileButton.setOnClickListener(this::editProfileButtonOnClickHandler);
        logOutButton.setOnClickListener(this::logOutButtonHandler);
        preferences = new Preferences(getContext());
        initializeUserData();
    }

    private void logOutButtonHandler(View v) {
        preferences.saveIsLoggedIn(false);
        Intent intent = new Intent(getActivity().getApplicationContext(), LogInActivity.class);
        startActivity(intent);
    }

    private void initializeUserData() {
        AppDatabase db = AppDatabase.getDbInstance(getActivity().getApplicationContext());
        User user = db.userDao().getById(preferences.getSavedUserId());
        TextView displayNameText = getView().findViewById(R.id.profileDisplayName);
        TextView usernameText = getView().findViewById(R.id.profileUsername);
        TextView aboutText = getView().findViewById(R.id.profileAbout);
        ImageView avatar = getView().findViewById(R.id.profileAvatar);
        displayNameText.setText(user.displayName);
        usernameText.setText(user.username);
        aboutText.setText(user.about);
        if (user.avatarImage.length() != 0) {
            Picasso.get().load(user.avatarImage).into(avatar);
        }
    }

    private void editProfileButtonOnClickHandler(View v) {
        Intent intent = new Intent(getActivity().getApplicationContext(), EditProfileActivity.class);
        startActivity(intent);
    }
}