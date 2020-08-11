package com.example.pushbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity7 extends AppCompatActivity {

    Button send_button;
    TextView msgBox;
    TextView resBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        send_button = findViewById(R.id.send_message);
        msgBox = findViewById(R.id.message_box);
        resBox = findViewById(R.id.response);
    }

    public void sendMessage(View view) {
        String msg = msgBox.getText().toString();
        Intent intent = Listener.recieve(msg,this, resBox);
        if (intent != null)
            this.startActivity(intent);
    }
}
