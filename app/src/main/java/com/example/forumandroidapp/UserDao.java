package com.example.forumandroidapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE username=:username AND password=:password")
    User getUserByUsernameAndPassword(String username, String password);

    @Query("SELECT * FROM user WHERE uid=:id")
    User getById(int id);

    @Insert
    long insertUsers(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void update(User... user);
}
