package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity {
    TextView secret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        secret = findViewById(R.id.secret);
    }

    public void sendString(View view) {
        Intent nextLevel = Listener.secret(secret.getText().toString(), this);
        if (nextLevel != null)
            this.startActivity(nextLevel);
    }
}