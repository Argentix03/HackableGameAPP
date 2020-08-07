package com.example.pushbutton;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TouchListener extends AppCompatActivity implements View.OnTouchListener {
    int counter = 0;
    public boolean onTouch(final View v, MotionEvent event) {
        final Button btn = findViewById(R.id.button_level4);
        Log.w("TAG", btn == null ? "NULL!!" : "Nah its fine");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.w("ACTION_Down: ", "rtyrty");
                new CountDownTimer(300000, 1000){
                    public void onTick(long millisUntilFinished){
                        counter++;
                        btn.setText("TIMER!");
                    }
                    public void onFinish(){
                        btn.setText("FINISH!!");
                    }
                }.start();
                break;

            case MotionEvent.ACTION_UP:
                btn.setText("Failed! You gave up so fast...");
                Log.w("ACTION_UP: ", "asdasd");

                break;
        }
        return true;
    }
}
