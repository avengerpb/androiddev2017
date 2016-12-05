<<<<<<< HEAD
=======

>>>>>>> rebuilt-version
package com.example.sieunhan.github_client.api.model;

import com.squareup.moshi.Json;

import java.util.List;

<<<<<<< HEAD
/**
 * Created by dannyle on 03/12/2016.
 */

public class SearchResult<V> {
    public int total_count;


    @Json(name = "incomplete_results")
    public boolean has_incomplete_results;


    public List<V> items;
}


=======
public class SearchResult<V> {
    public int total_count;

    @Json(name = "incomplete_results")
    public boolean has_incomplete_results;

    public List<V> items;
}
>>>>>>> rebuilt-version
