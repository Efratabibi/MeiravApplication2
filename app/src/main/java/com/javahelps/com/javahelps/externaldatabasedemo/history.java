package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        adapterfinish adapter;
        ListView mListView;
        mListView = (ListView) findViewById(R.id.listView);
        List<Patient> Patients;
        ImageButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(history.this, TechMainActivity.class);
                startActivity(macintoshIntent2);
            }
        });

        DatabaseAccess db = new DatabaseAccess(this);
        Patients = db.getAllOldMemoPatients();
        adapter = new adapterfinish(this, R.layout.activity_adapterfinish, Patients);
        mListView.setAdapter(adapter);


        List<Patient> Patients2;
        adapterfinish adapter2;
        ListView mListViewt;
        mListViewt = (ListView) findViewById(R.id.listView2);
        Patients2 = db.getAllOldUltraPatients();
        adapter2 = new adapterfinish(this, R.layout.activity_adapterfinish, Patients2);
        mListViewt.setAdapter(adapter2);

    }

}
