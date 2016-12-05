package com.example.sieunhan.github_client.rest;

import com.example.sieunhan.github_client.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JiJi on 12/5/2016.
 */

public interface GithubRepoEndPoint {
    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> getRepo(@Path("user") String name);
}
