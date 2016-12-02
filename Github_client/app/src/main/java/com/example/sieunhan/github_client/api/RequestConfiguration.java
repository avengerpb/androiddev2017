package com.example.sieunhan.github_client.api;

import android.text.TextUtils;

import java.io.IOException;

/**
 * Created by JiJi on 12/2/2016.
 */

public class RequestConfiguration implements okhttp3.Interceptor {
    private static final String HEADER_USER_AGENT = "ForkHub/2.0";
    private static final String HEADER_ACCEPT = "application/vnd.github.v3.html+json";

    private final Provider<GitHubAccount> accountProvider;

    public RequestConfiguration(final Provider<GitHubAccount> accountProvider) {
        this.accountProvider = accountProvider;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        String credentials;

        GitHubAccount account = accountProvider.get();
        String token = account.getAuthToken();
        if (!TextUtils.isEmpty(token)) {
            credentials = "token " + token;
        } else {
            credentials = "Basic " + EncodingUtils.toBase64(account.getUsername() + ':' + account.getPassword());
        }

        Request newRequest = originalRequest.newBuilder()
                .header("Authorization", credentials)
                .header("User-Agent", HEADER_USER_AGENT)
                .addHeader("Accept", HEADER_ACCEPT)
                .build();

        return chain.proceed(newRequest);
    }

}
