package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import static android.graphics.Color.parseColor;

public class MainActivity3 extends AppCompatActivity {
    // A colour string for each button compatible with parseColor
    String[] colours = {"#245a8c", "#245a8c","#c9dbba","#021c1a","#c9dbba","#021c1a","#400214","#4a81e0","#400214"};
    int flippedCard = 0; // keeps record of the last flipped card. 0 means no card is flipped.
    int fails = 0; // reveals menu on 5 fails
    ArrayList<Button> buttons = new ArrayList<Button>(); // contains buttons active, clears on reset.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void flipCard(int button_num, View view, int buttonID) {
        Button button = findViewById(buttonID);
        button.setBackgroundColor(parseColor(colours[button_num - 1]));
        if (!buttons.contains(button))
            buttons.add(button);
        //Toast.makeText(this, "buttons.size: "+buttons.size(), Toast.LENGTH_SHORT).show();
        if (flippedCard != 0) {
            if (checkPair(flippedCard, button_num)) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                winCheck();
            }
            else {
                fails += 1;
                Toast.makeText(this, "Wrong! All progress has been reset...", Toast.LENGTH_SHORT).show();
                // Some copy pasted android wait code from stackoverflow
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        reset();
                    }
                }, 500);
                if (fails >= 5) {
                    Button menu_button = findViewById(R.id.menu_button_3);
                    menu_button.setVisibility(View.VISIBLE);
                }
            }
            flippedCard = 0;
        } else
            flippedCard = button_num;
    }

    public boolean checkPair(int button1, int button2) {
        return (colours[button1 - 1] == colours[button2 - 1]);
    }

    public void reset() {
        for (Button button : buttons) {
            button.setBackgroundResource(android.R.drawable.btn_default);
        }
        buttons.clear();
    }

    public void winCheck() {
        if (buttons.size() >= colours.length+1)
            nextLevel();
    }

    public void nextLevel() {
        Intent nextActivity = new Intent(this, MainActivity4.class);
        this.startActivity(nextActivity);
    }

    public void button1(View view) { flipCard(1, view, R.id.button_1); }
    public void button2(View view) { flipCard(2, view, R.id.button_2); }
    public void button3(View view) { flipCard(3, view, R.id.button_3); }
    public void button4(View view) { flipCard(4, view, R.id.button_4); }
    public void button5(View view) { flipCard(5, view, R.id.button_5); }
    public void button6(View view) { flipCard(6, view, R.id.button_6); }
    public void button7(View view) { flipCard(7, view, R.id.button_7); }
    public void button8(View view) { flipCard(8, view, R.id.button_8); }
    public void button9(View view) { flipCard(9, view, R.id.button_9); }

    public void goToMenu(View view) {
        Intent menuActivity = new Intent(this, MenuActivity.class);
        this.startActivity(menuActivity);
    }
}