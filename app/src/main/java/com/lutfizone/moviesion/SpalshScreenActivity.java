package com.lutfizone.moviesion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SpalshScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    private PreferenceLogin login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        login = PreferenceLogin.getInstance(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (login.isLogin()) {
                    Intent intent = new Intent(SpalshScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    startActivity(new Intent(SpalshScreenActivity.this, LoginActivity.class));
                }
            }
        }, SPLASH_TIME_OUT);
    }
}