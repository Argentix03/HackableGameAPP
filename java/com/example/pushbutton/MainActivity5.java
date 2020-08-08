package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity5 extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 5000;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    private Button startPause;
    private TextView countdown;
    private CountDownTimer countDownTimer;
    private boolean running;
    final int minRNG = 400;
    final int maxRNG = 4000;
    int rng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        rng = new Random().nextInt((maxRNG - minRNG) + 1) + minRNG;
        startPause = findViewById(R.id.holdButton);
        countdown = findViewById(R.id.text_view_countdown);
        startPause.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startTimer();
                        break;
                    case MotionEvent.ACTION_UP:
                        stopTimer();
                        break;
                }
                return false;
            }
        });
    }
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 10) {
            @Override
            public void onTick(long millisUntillFinish) {
                timeLeftInMillis = millisUntillFinish;
                running = true;
                updateCountDownText();
                if (timeLeftInMillis <= rng)
                    stopTimer();
            }

            @Override
            public void onFinish() {
                stopTimer();
            }
        }.start();
        startPause.setText("Dont let go");
    }
    private void stopTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        countDownTimer.cancel();
        running = false;
        rng = new Random().nextInt((maxRNG - minRNG) + 1) + minRNG;
        startPause.setText("Hold");
    }
    private void updateCountDownText() {
        int seconds = (int) (timeLeftInMillis / 1000);
        long millis = timeLeftInMillis / 10;
        millis %= 100;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", seconds, millis);
        countdown.setText(timeLeftFormatted);
    }
    private void winCheck() {
        if (timeLeftInMillis <= 42 && rng <= 42)
            nextLevel();
    }
    public void nextLevel() {
        Intent nextActivity = new Intent(this, MainActivity6.class);
        this.startActivity(nextActivity);
    }

}