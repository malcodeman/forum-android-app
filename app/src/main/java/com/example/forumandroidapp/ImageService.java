package com.example.forumandroidapp;

import android.content.Context;
import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageService {
    public static void setAvatarImage(Context context, Runnable fun) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://source.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        UnsplashApi service = retrofit.create(UnsplashApi.class);
        Call<ResponseBody> randomImage = service.getRandom();
        randomImage.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {
                    AppDatabase db = AppDatabase.getDbInstance(context);
                    Preferences preferences = new Preferences(context);
                    User user = db.userDao().getById(preferences.getSavedUserId());
                    user.avatarImage = response.raw().request().url().toString();
                    db.userDao().update(user);
                    fun.run();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.toString());
            }
        });
    }
}
