package com.example.sieunhan.github_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GithubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);
        Log.i("log1", "This is log from onCreate()");
        setContentView(R.layout.fragment_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("log1", "This is log from onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("log1", "This is log from onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("log1", "This is log from onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("log1", "This is log from onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("log1", "This is log from onDestroy()");
    }
}

