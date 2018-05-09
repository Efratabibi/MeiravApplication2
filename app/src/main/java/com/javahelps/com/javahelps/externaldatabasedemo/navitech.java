package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class navitech extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navitech);

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent = new Intent(navitech.this, TechMainActivity.class);
                startActivity(macintoshIntent);
            }
        });


        Button memo = (Button) findViewById(R.id.memo);
        memo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent1 = new Intent(navitech.this, memo.class);
                startActivity(macintoshIntent1);
            }
        });


        Button ultra = (Button) findViewById(R.id.ultra);
        ultra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(navitech.this, ultra.class);
                startActivity(macintoshIntent2);
            }
        });

        Button results = (Button) findViewById(R.id.results);
        results.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent3 = new Intent(navitech.this, results.class);
                startActivity(macintoshIntent3);
            }
        });

    }

}
