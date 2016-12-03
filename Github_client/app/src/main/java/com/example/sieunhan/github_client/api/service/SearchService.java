package com.example.sieunhan.github_client.api.service;

import com.example.sieunhan.github_client.api.model.Repository;
import com.example.sieunhan.github_client.api.model.SearchResult;
import com.example.sieunhan.github_client.api.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dannyle on 03/12/2016.
 */

public interface SearchService {
    @GET("search/users")
    Call<SearchResult<User>> searchUsers(
            @Query("q") String q,
            @Query("page") int page);


    @GET("search/repositories")
    Call<SearchResult<Repository>> searchRepositories(
            @Query("q") String q,
            @Query("page") int page);
}





