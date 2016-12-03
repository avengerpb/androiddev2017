package com.example.sieunhan.github_client.api.service;

import com.example.sieunhan.github_client.api.model.Notification;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dannyle on 03/12/2016.
 */

public interface NotificationService {
    @GET("notifications")
    Call<List<Notification>> listNotifications(
            @Query("all") boolean all,
            @Query("page") int page);


    @PATCH("notifications/threads/{id}")
    Call<ResponseBody> markAsRead(@Path("id") int id);
}





