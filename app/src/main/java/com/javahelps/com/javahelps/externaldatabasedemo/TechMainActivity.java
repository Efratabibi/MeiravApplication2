package com.javahelps.com.javahelps.externaldatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.text.CollationElementIterator;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import android.content.Intent;
import android.widget.Toast;




public class TechMainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_main);
        Calendar c = Calendar.getInstance();
        System.out.println("זמן נוכחי => "+c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd\nHH:mm");
        String formattedDate = df.format(c.getTime());
        this.textView=(TextView) findViewById(R.id.textView2);
        textView.setText(formattedDate);
        this.textView2=(TextView) findViewById(R.id.textView1);
        textView2.setText("ברוכה הבאה");
        Button buttonwaiting = (Button) findViewById(R.id.b3);
        buttonwaiting.setOnClickListener(new OnClickListener() {

                                                  public void onClick(View view) {
                                                      Intent macintoshIntent = new Intent(TechMainActivity.this, memo.class);
                                                      startActivity(macintoshIntent);
                                                  }
                                              });

       /* Start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent loginintent = new Intent(TechMainActivity.this, LoginActivity.class);
                startActivity(loginintent);
                Toast.makeText(TechMainActivity.this, "שלום", Toast.LENGTH_LONG).show();

            }
        }); */



    }
}
