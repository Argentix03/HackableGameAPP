package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    // An array of exclusively Activity objects compatible as an intent parameter. ordered by level.
    Class[] levels = {MainActivity.class, MainActivity2.class, MainActivity3.class, MainActivity4.class, MainActivity5.class, MainActivity6.class, MainActivity7.class, MainActivity8.class, MainActivity9.class, MainActivity10.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToLevel(int level) {
        level -= 1;
        Intent levelActivity = new Intent(this, levels[level]);
        this.startActivity(levelActivity);
    }

    public void goToLevel(View view) {
        int level = Integer.parseInt(view.getTag().toString());
        goToLevel(level);
    }

}