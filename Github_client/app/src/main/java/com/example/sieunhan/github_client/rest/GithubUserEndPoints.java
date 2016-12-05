package com.example.sieunhan.github_client.rest;

import com.example.sieunhan.github_client.model.GithubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JiJi on 12/5/2016.
 */

public interface GithubUserEndPoints {
    @GET("/users/{user}")
    Call<GithubUser> getUser(@Path("user") String user);
}
