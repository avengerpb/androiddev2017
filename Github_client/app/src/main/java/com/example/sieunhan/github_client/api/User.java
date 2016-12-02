package com.example.sieunhan.github_client.api;

/**
 * Created by Admin on 12/2/2016.
 */

public class User {
    String login;
    String avatar_url;
    String repos_url;
    String gists_url;

    @Override
    public String toString() {
        return(login);
    }
}
