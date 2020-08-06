package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int up_down = 1;
    int button_presses = 0;
    Button push_button;
    TextView wintext;
    Button skip_button;

    public void createMyButton() {push_button = findViewById(R.id.push_button_1);}
    public void createMyWinText() {wintext = findViewById(R.id.wintext);}
    public void createSkipButton() {skip_button = findViewById(R.id.menu_button);}

    @SuppressLint("ClickableViewAccessibility")
    public void pushTheButton(View view) {
        // The troll win
        if (button_presses == 10) {
            Toast.makeText(MainActivity.this, "WIN!!", Toast.LENGTH_SHORT).show();
            wintext = findViewById(R.id.wintext);
            wintext.setVisibility(View.VISIBLE);
            skip_button = findViewById(R.id.menu_button);
            skip_button.setVisibility(View.VISIBLE);
            up_down = 0; //reverse count
            button_presses -= 1;
            // The real Win
            if (button_presses >= 20) {
                nextLevel(view);
                //Intent secondActivity = new Intent(MainActivity.this, MainActivity2.class);
                //MainActivity.this.startActivity(secondActivity);
            }
        }
        else {
            if (up_down == 1)
                button_presses += 1;
            else
                button_presses -=1;
            Toast.makeText(MainActivity.this, "Push Harder! You only pressed " + button_presses +" times...", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextLevel(View view) {
        Intent nextActivity = new Intent(MainActivity.this, MainActivity2.class);
        MainActivity.this.startActivity(nextActivity);
    }

    public void goToMenu(View view) {
        Intent menuActivity = new Intent(this, MenuActivity.class);
        this.startActivity(menuActivity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
