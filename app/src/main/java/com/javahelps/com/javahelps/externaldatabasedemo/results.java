package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        List<Patient> PatientsResults;
        AdapterResultsPatient adapter;
        ListView mListView;
        mListView = (ListView) findViewById(R.id.listView);

        ImageButton fab = findViewById(R.id.fab);
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
