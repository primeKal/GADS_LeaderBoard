package com.kalu.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivtiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_activtiy);
        Thread background=new Thread(){
            public void run(){
                try {
                    sleep(3*1000);
                    Intent i=new Intent(getBaseContext(),TabLayOut.class);
                    startActivity(i);
                    finish();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        background.start();
    }

}
