package com.example.sieunhan.github_client.core;

/**
 * Created by Admin on 12/6/2016.
 */


/**
 * Load listener callback
 *
 * @param <V>
 */
public interface OnLoadListener<V> {

    /**
     * Loaded callback
     *
     * @param data
     */
    void loaded(V data);
}