package com.example.forumandroidapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Post.class}, version = 4)

public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract PostDao postDao();

    private static final String NAME = "database-forum";
    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
