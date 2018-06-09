package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.widget.Toast;


public class  MainActivity extends AppCompatActivity {
    private ListView listView;
    private static int Splash_Time_Out=1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(homeIntent);
                finish();

            }
        },Splash_Time_Out);



        /*Button Start = (Button) findViewById(R.id.button);*/

       /* this.listView = (ListView) findViewById(R.id.listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> Meirav = databaseAccess.getMeirav();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Meirav);
        this.listView.setAdapter(adapter); */


       /* Start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent loginintent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginintent);
                Toast.makeText(MainActivity.this, "שלום", Toast.LENGTH_LONG).show();

            }
        }); */
    }
}


