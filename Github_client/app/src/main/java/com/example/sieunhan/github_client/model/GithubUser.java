package com.example.sieunhan.github_client.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dannyle on 05/12/2016.
 */

public class GithubUser {
    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String name;

    @SerializedName("followers")
    private String followers;

    @SerializedName("following")
    private String following;

    @SerializedName("avatar_url")
    private String avatar;

    @SerializedName("email")
    private String email;

    public GithubUser(String login, String name, String followers, String following, String avatar, String email){
        this.login = login;
        this.name = name;
        this.followers = followers;
        this.following = following;
        this.avatar = avatar;
        this.email = email;
    }

    public String getLogin(){return login;}
    public String getName(){return name;}
    public String getFollowers(){return followers;}
    public String getFollowing(){return following;}
    public String getAvatar(){return avatar;}
    public String getEmail(){return email;}

    public void setLogin(String login){this.login = login;}
    public void setName(String name){this.login = name;}
    public void setFollowers(String followers){this.followers = followers;}
    public void setFollowing(String following){this.following = following;}
    public void setAvatar(String avatar){this.avatar = avatar;}
    public void setEmail(String email){this.email = email;}

}
