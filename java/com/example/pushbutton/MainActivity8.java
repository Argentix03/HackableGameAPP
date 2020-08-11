package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity {
    int fails = 0;
    TextView patience;
    ProgressBar progressBar;
    public static CountDownTimer cnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        progressBar = findViewById(R.id.progressBar);
        patience = findViewById(R.id.patience);
        cnt = new CountDownTimer(5000, 5000) {
            @Override
            public void onTick(long l) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        patience.setVisibility(View.VISIBLE);
                    }
                }, 5000);
                Listener.time();
            }

            @Override
            public void onFinish() {
                Intent nextActivity = new Intent(MainActivity8.this, MainActivity9.class);
                MainActivity8.this.startActivity(nextActivity);
            }
        }.start();
    }


}