package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity4 extends AppCompatActivity {
    int counter;
    int left, top, right, bottom = 0;
    int stage = 0;
    TextView getMeHere;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getMeHere = findViewById(R.id.get_me_here);
        btn = (Button) findViewById(R.id.button_level4);
    }

    @SuppressLint("ClickableViewAccessibility")
    public void onPress(View view) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) btn.getLayoutParams();
        //left += 10; top += 10; right += 10; bottom += 10;
        //params.setMargins(left, top, right, bottom);
        if (stage == 0 && params.leftMargin <= 240 && params.topMargin <= 240) stage = 1;
        else if (stage == 1 && params.leftMargin >= 240 && params.topMargin <= 600) stage = 2;
        else if (stage == 2 && params.leftMargin <= 650 && params.topMargin >= 600) stage = 3;
        else if (stage == 3 && params.leftMargin >= 400) stage = 4;
        else if (stage == 4 && params.leftMargin <= 750) stage = 5;
        else if (stage == 5 && params.leftMargin >= 800) stage = 6;
        else if (stage == 6 && params.topMargin >= 1600) stage = 7;
        else if (stage == 7 && params.leftMargin <= 400) stage = 8;
        else if (stage == 8 && params.topMargin >= 1650) stage = 9;

        switch (stage) {
            case 1:
                params.leftMargin += 35;
                params.topMargin += 35;
                break;
            case 2:
                params.topMargin += 35;
                break;
            case 3:
                params.leftMargin += 35;
                break;
            case 4:
                params.topMargin -= 35;
                break;
            case 5:
                params.leftMargin += 35;
                break;
            case 6:
                params.topMargin += 35;
                break;
            case 7:
                params.leftMargin -= 35;
                break;
            case 8:
                params.topMargin += 35;
                break;
            case 9:
                params.leftMargin += 35;
                break;
        }
        Log.w("btn (stage:" + stage + ") margins:\t","top: " + params.topMargin + "\tleft: " +
                params.leftMargin + "\tbottom: " + params.bottomMargin + "\tright: " + params.bottomMargin);
        btn.setLayoutParams(params);
        winCheck();
    }

    public void winCheck() {
        ViewGroup.MarginLayoutParams goalParams = (ViewGroup.MarginLayoutParams) getMeHere.getLayoutParams();
        ViewGroup.MarginLayoutParams btnParams = (ViewGroup.MarginLayoutParams) btn.getLayoutParams();
        switch (goalParams.bottomMargin - btnParams.bottomMargin) {
            case 0:
                nextLevel();
        }
    }

    public void nextLevel() {
        Intent nextActivity = new Intent(this, MainActivity4.class);
        this.startActivity(nextActivity);
    }
}