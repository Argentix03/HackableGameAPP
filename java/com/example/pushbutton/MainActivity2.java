package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    int[] sequence = {1,3,1,2,4,2,5}; // 5 is impossible cuz no button for 5
    static int sequencePosition = 0; // game is won when position reaches the end of the sequence array
    int fails = 0; // too many fails spawn menu button for noobs who give up

    // checks if the number is the next one and progress the sequence if true, else reset.
    public boolean inSequence(int button_num) {
        if (button_num == sequence[sequencePosition]) {
            sequencePosition += 1;
            winCheck();
            return true;
        } else {
            sequencePosition = 0;
            return false;
        }
    }

    // Sends to next level if game is won
    public void winCheck() {
        if (sequencePosition == sequence.length) {
            Toast.makeText(MainActivity2.this, "Success!", Toast.LENGTH_SHORT).show();
            nextLevel();
        }
    }

    // Send button presses to inSequence and give user feedback
    public void buttonPress(int button_num, View view) {
        if (inSequence(button_num))
            Toast.makeText(MainActivity2.this, "Correct!", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(MainActivity2.this, "Wrong! All progress has been reset...", Toast.LENGTH_SHORT).show();
            fails += 1;
            if (fails >= 5) {
                Button menu_button = findViewById(R.id.menu_button_2);
                menu_button.setVisibility(View.VISIBLE);
            }
        }
    }

    // Button listeners just sends the button's num to buttonPress() to handle the rest
    public void pressButton1(View view) {buttonPress(1, view);}
    public void pressButton2(View view) {buttonPress(2, view);}
    public void pressButton3(View view) {buttonPress(3, view);}
    public void pressButton4(View view) {buttonPress(4, view);}

    public void nextLevel() {
        Intent nextActivity = new Intent(MainActivity2.this, MainActivity3.class);
        this.startActivity(nextActivity);
    }

    public void goToMenu(View view) {
        Intent menuActivity = new Intent(this, MenuActivity.class);
        this.startActivity(menuActivity);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}