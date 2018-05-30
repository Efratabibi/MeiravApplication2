package com.javahelps.com.javahelps.externaldatabasedemo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.text.CollationElementIterator;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import android.content.Intent;
import android.widget.Toast;




public class TechMainActivity extends AppCompatActivity {
    private TextView textView2;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_main);
        Calendar c = Calendar.getInstance();
        System.out.println("זמן נוכחי => "+c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd\nHH:mm");
        String formattedDate = df.format(c.getTime());
        this.textView2=(TextView) findViewById(R.id.textView1);
        Globals g = Globals.getInstance();
        textView2.setText(g.getTechName()+", ברוכה הבאה! ");

        Button rep = (Button) findViewById(R.id.rep);
        rep.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent5 = new Intent(TechMainActivity.this, Report.class);
                startActivity(macintoshIntent5);
            }
        });

        Button buttonwaiting = (Button) findViewById(R.id.b1);
        buttonwaiting.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent = new Intent(TechMainActivity.this, memo.class);
                startActivity(macintoshIntent);
            }
        });

        Button buttonontheway = (Button) findViewById(R.id.b2);
        buttonontheway.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(TechMainActivity.this, TechOnTheWay.class);
                startActivity(macintoshIntent2);
            }
        });
        final LinearLayout lin=(LinearLayout) findViewById(R.id.lin);
        final Button navi = (Button) findViewById(R.id.b3);
        navi.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                lin.setLayoutParams(new LinearLayout.LayoutParams(1500, 180));
            }
        });
       /* Start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent loginintent = new Intent(TechMainActivity.this, LoginActivity.class);
                startActivity(loginintent);
                Toast.makeText(TechMainActivity.this, "שלום", Toast.LENGTH_LONG).show();

            }
        }); */
        Button logout = (Button) findViewById(R.id.b4);
        logout.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent3 = new Intent(TechMainActivity.this, LoginActivity.class);
                startActivity(macintoshIntent3);
            }
        });


        Button memo = (Button) findViewById(R.id.memo);
        memo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent1 = new Intent(TechMainActivity.this, memo.class);
                startActivity(macintoshIntent1);
            }
        });


        Button ultra = (Button) findViewById(R.id.ultra);
        ultra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(TechMainActivity.this, ultra.class);
                startActivity(macintoshIntent2);
            }
        });

        Button results = (Button) findViewById(R.id.results);
        results.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent3 = new Intent(TechMainActivity.this, results.class);
                startActivity(macintoshIntent3);
            }
        });


    }
}
