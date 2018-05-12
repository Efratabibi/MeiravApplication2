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

public class ultra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultra);


        List<Patient> PatientsUltra;
        AdapterUltraPatient adapter;
        ListView mListView;
        mListView = (ListView) findViewById(R.id.listView);




        ImageButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(ultra.this, TechMainActivity.class);
                startActivity(macintoshIntent2);
            }
        });

        DatabaseAccess db = new DatabaseAccess(this);
        PatientsUltra = db.getAllUltraPatients();
        adapter = new AdapterUltraPatient(this, R.layout.adapter_ultra_layout, PatientsUltra);
        mListView.setAdapter(adapter);

    }
}
