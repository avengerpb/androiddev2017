package com.example.sieunhan.github_client.model;

/**
 * Created by dannyle on 05/12/2016.
 */
import com.google.gson.annotations.SerializedName;
public class GithubRepo {
    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    public GithubRepo (String language, String description, String name){
        this.setLanguage(language);
        this.setDescription(description);
        this.setName(name);
    }

    String getName(){
        return name;
    }

    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setLanguage(String language){this.language = language;}

    public String getDescription(){return description;}
    public String getLanguage(){return language;}

}
