package com.example.pushbutton;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class Listener {
    static int fails = 0;
    protected static Intent recieve(String msg, Activity act, TextView resBox) {
        if (!msg.contentEquals("let me pass")) {
            resBox.setText("Bad message:\n" + msg);
            fails++;
            if (fails >= 5) {
                resBox.setText("Try harder!");
                fails = 0;
            }
            return null;
        }
        else {
            Intent nextActivity = new Intent(act, MainActivity8.class);
            return nextActivity;
        }
    }

    protected static void time() {
        MainActivity8.cnt.cancel();
    }

    protected static Intent secret(String msg, Activity act) {
        String secret = "";
        for (int i = 0; i < msg.length(); i++) {
            if (Character.isUpperCase(msg.charAt(i)))
                secret += msg.charAt(i);
        }
        secret += "!!";
        //Log.w("Secret:", secret);
        if (secret.contentEquals("AWESOME!!"))
            return new Intent(act, MainActivity11.class);
        else
            return null;
    }
}
