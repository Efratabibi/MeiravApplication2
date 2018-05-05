package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Button button = (Button)findViewById(R.id.button4);
        Button button2 = (Button)findViewById(R.id.button5);
        Button button3 = (Button)findViewById(R.id.button6);
        Button button4 = (Button)findViewById(R.id.button7);
        button3.setFocusable(true);
        button3.setFocusableInTouchMode(true);///add this line
        button3.requestFocus();
        button.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);

        List<Patient> PatientsResults;
        AdapterResultsPatient adapter;
        ListView mListView;
        mListView = (ListView) findViewById(R.id.listView);

        Button ultra = (Button) findViewById(R.id.button3);
        ultra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent macintoshIntent = new Intent(results.this, ultra.class);
                startActivity(macintoshIntent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(results.this, TechMainActivity.class);
                startActivity(macintoshIntent2);
            }
        });

        DatabaseAccess db = new DatabaseAccess(this);
        PatientsResults = db.getAllResultsPatients();
        adapter = new AdapterResultsPatient(this, R.layout.adapter_results_layout, PatientsResults);
        mListView.setAdapter(adapter);

    }
}
