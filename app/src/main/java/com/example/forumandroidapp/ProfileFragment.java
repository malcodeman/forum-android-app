package com.example.forumandroidapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button editProfileButton = getView().findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(this::editProfileButtonOnClickHandler);
    }

    private void editProfileButtonOnClickHandler(View v) {
        Intent intent = new Intent(getActivity().getApplicationContext(), EditProfileActivity.class);
        startActivity(intent);
    }
}