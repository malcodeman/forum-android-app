package com.example.forumandroidapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE username=:username AND password=:password ")
    User getUserByUsernameAndPassword(String username, String password);

    @Insert
    void insertUsers(User... users);

    @Delete
    void deleteUser(User user);
}
