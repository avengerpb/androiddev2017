package com.example.sieunhan.github_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText inputUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_github);*/
        Log.i("log1", "This is log from onCreate()");
        setContentView(R.layout.fragment_login);
        Button button = (Button)findViewById(R.id.button);
        inputUser = (EditText) findViewById(R.id.user_name);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("user_name", inputUser.getText().toString());
                startActivity(i);
            }
        });
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

