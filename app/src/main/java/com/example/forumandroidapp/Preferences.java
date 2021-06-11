package com.example.forumandroidapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    public static final String PREFS_UID = "Preferences/UID";
    public static final String PREFS_IS_LOGGED_IN = "Preferences/IS_LOGGED_IN";

    SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void saveUserId(int uid) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREFS_UID, uid);
        editor.apply();
    }

    public int getSavedUserId() {
        return sharedPreferences.getInt(PREFS_UID, -1);
    }

    public void saveIsLoggedIn(boolean isLoggedIn) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PREFS_IS_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    public Boolean getIsLoggedIn() {
        return sharedPreferences.getBoolean(PREFS_IS_LOGGED_IN, false);
    }
}
