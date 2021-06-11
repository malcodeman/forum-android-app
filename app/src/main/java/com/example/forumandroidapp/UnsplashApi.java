package com.example.forumandroidapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UnsplashApi {
    @GET("random?face")
    Call<ResponseBody> getRandom();
}
