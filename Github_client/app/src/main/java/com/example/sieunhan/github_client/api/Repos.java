package com.example.sieunhan.github_client.api;

/**
 * Created by Admin on 12/2/2016.
 */

public class Repos {
    String name;
    boolean fork;
    String git_commit_url;
    String language;
    int forks_count;
    int watcher;

    @Override
    public String toString() {
        return(name);
    }
}
