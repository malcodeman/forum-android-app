package com.example.forumandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeNavigation();
        preferences = new Preferences(this);
        if(preferences.getSavedUserId() == -1){
            preferences.saveIsLoggedIn(false);
            Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
            startActivity(intent);
        }
    }

    private void initializeNavigation() {
        BottomNavigationView navView = findViewById(R.id.bottomNav);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.feedFragment, R.id.createPostFragment, R.id.profileFragment)
                .build();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navHostFragment);
        NavController controller = navHostFragment.getNavController();

        NavigationUI.setupActionBarWithNavController(this, controller, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, controller);
    }
}