package com.example.forumandroidapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "displayName")
    public String displayName;

    @ColumnInfo(name = "about")
    public String about;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.displayName = "";
        this.about = "";
    }
}
