package com.example.mozeeb.kantinonline.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mozeeb.kantinonline.MainActivity;
import com.example.mozeeb.kantinonline.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //SplashScreen
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); //waktu pending 3 detik
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
            }
        });
        thread.start();

        this.setTitle("Selamat Datang");
    }
}