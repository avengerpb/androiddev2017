package com.example.sieunhan.github_client.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sieunhan.github_client.R;

/**
 * Created by Admin on 11/18/2016.
 */

public class RepoFragment extends Fragment {
    public RepoFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.repositories, container, false);
        return v;
    }
}
