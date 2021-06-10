package com.example.forumandroidapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    public static final String PREFS_EMAIL = "Preferences/EMAIL";
    public static final String PREFS_PASSWORD = "Preferences/PASSWORD";
    public static final String PREFS_USERNAME = "Preferences/USERNAME";
    public static final String PREFS_DISPLAY_NAME = "Preferences/DISPLAY_NAME";
    public static final String PREFS_ABOUT = "Preferences/ABOUT";
    public static final String PREFS_IS_LOGGED_IN = "Preferences/IS_LOGGED_IN";

    SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveUserInfo(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFS_EMAIL, user.email);
        editor.putString(PREFS_USERNAME, user.username);
        editor.putString(PREFS_PASSWORD, user.password);
        editor.putString(PREFS_DISPLAY_NAME, user.displayName);
        editor.putString(PREFS_ABOUT, user.about);
        editor.apply();
    }

    public User getSavedUserInfo() {
        String email = sharedPreferences.getString(PREFS_EMAIL, "");
        String username = sharedPreferences.getString(PREFS_USERNAME, "");
        String password = sharedPreferences.getString(PREFS_PASSWORD, "");
        String displayName = sharedPreferences.getString(PREFS_DISPLAY_NAME, "");
        String about = sharedPreferences.getString(PREFS_ABOUT, "");
        return new User(email, username, password, displayName, about);
    }

    public void saveIsLoggedIn(boolean isLoggedIn) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PREFS_IS_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    public Boolean getIsLoggedIn() {
        return sharedPreferences.getBoolean(PREFS_IS_LOGGED_IN, false);
    }

    public void clearSavedData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
