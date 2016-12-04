package com.example.sieunhan.github_client.api.service;

import com.example.sieunhan.github_client.api.model.Repository;
import com.example.sieunhan.github_client.api.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Admin on 12/4/2016.
 */

public interface UserService {
    @GET("/users/{user}")
    Call<User> loadQuestions(@Query("tagged") String tags);
}
