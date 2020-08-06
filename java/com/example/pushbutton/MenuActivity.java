package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    // An array of exclusively Activity objects compatible as an intent parameter. ordered by level.
    Object[] levels = {MainActivity.class, MainActivity2.class, MainActivity3.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    // Polymorph generic Object into MainActivity with a cast using the wrapper class from the level array with an index
    public void goToLevel(int level) {
        Intent levelActivity = new Intent(this, (Class<MainActivity>) levels[level]);
        this.startActivity(levelActivity);
    }

    public void level1(View view) { goToLevel(1); }
    public void level2(View view) { goToLevel(2); }
    public void level3(View view) { goToLevel(3); }
    public void level4(View view) { goToLevel(4); }
    public void level5(View view) { goToLevel(5); }
    public void level6(View view) { goToLevel(6); }
    public void level7(View view) { goToLevel(7); }
    public void level8(View view) { goToLevel(8); }
    public void level9(View view) { goToLevel(9); }
    public void level10(View view) { goToLevel(10); }
    public void level11(View view) { goToLevel(11); }
}