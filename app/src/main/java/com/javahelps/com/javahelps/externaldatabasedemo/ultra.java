package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ultra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra);
        Button button = (Button)findViewById(R.id.button4);
        Button button2 = (Button)findViewById(R.id.button5);
        Button button3 = (Button)findViewById(R.id.button6);
        Button button4 = (Button)findViewById(R.id.button3);
        button2.setFocusable(true);
        button2.setFocusableInTouchMode(true);///add this line
        button2.requestFocus();
        button.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);



        Button ultra = (Button) findViewById(R.id.button7);
        ultra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent = new Intent(ultra.this, results.class);
                startActivity(macintoshIntent);
            }
        });


        Button memo = (Button) findViewById(R.id.button3);
        memo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(ultra.this, memo.class);
                startActivity(macintoshIntent2);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(ultra.this, TechMainActivity.class);
                startActivity(macintoshIntent2);
            }
        });

    }
}
