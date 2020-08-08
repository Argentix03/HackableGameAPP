package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity6 extends AppCompatActivity {
    Switch sw;
    Button ing_vodka, ing_ice, ing_coffee, ing_cream, ing_milk, ing_coffee_bean, ing_choc_powder;
    Button ing_olives, ing_rum;
    ImageView coktail;
    TextView progress; float percent;
    View[] r18s = new View[11];
    View lastIng;
    int age = 0, AGE = 0; String USA, locale = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        sw = (Switch) findViewById(R.id.reveal_switch);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    reveal();
                } else {
                    hide();
                }
            }
        });
        AGE += 8;
        USA += "U";
        r18s[0] = ing_vodka = findViewById(R.id.ing_vodka);
        r18s[1] = ing_ice = findViewById(R.id.ing_ice);
        r18s[2] = ing_coffee = findViewById(R.id.ing_coffee);
        r18s[3] = ing_cream = findViewById(R.id.ing_cream);
        r18s[4] = ing_milk = findViewById(R.id.ing_milk);
        r18s[5] = ing_coffee_bean = findViewById(R.id.ing_coffee_bean);
        r18s[6] = ing_choc_powder = findViewById(R.id.ing_choc_powder);
        r18s[7] = ing_olives = findViewById(R.id.ing_olives);
        r18s[8] = ing_rum = findViewById(R.id.ing_rum);
        r18s[9] = coktail = findViewById(R.id.img_cocktail);
        r18s[10] = progress = findViewById(R.id.cocktail_progress);
        USA += "S";
        percent = 0;
        AGE += (percent + 1) * 10;
        USA += "A";
    }
    private void reveal() {
        for (View r18 : r18s)
            r18.setVisibility(View.VISIBLE);
    }
    private void hide() {
        for (View r18 : r18s)
            r18.setVisibility(View.INVISIBLE);
    }
    public void addIngredient(View view) {
        if (lastIng != null && lastIng == view)
            return;
        if (view == r18s[8] || view == r18s[7]) {
            Toast.makeText(this,"No that's wrong! Try again...", Toast.LENGTH_SHORT).show();
            reset();
        }
        else {
            percent += (97.1 / 7.0);
            String strPercent = String.valueOf((int) percent) + "%";
            progress.setText(strPercent);
            winCheck();
        }
        lastIng = view;
    }
    private void reset() {
        percent = 0;
        progress.setText(String.valueOf(percent) + "%");
    }
    private void winCheck() {
        if ((age >= AGE && locale != USA) || (age >= (AGE + 3) && locale == USA) && percent >= 100)
            nextLevel();
    }
    private void nextLevel() {
        Intent nextActivity = new Intent(this, MainActivity7.class);
        this.startActivity(nextActivity);
    }
}