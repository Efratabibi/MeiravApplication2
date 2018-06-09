package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class TechOnTheWay extends AppCompatActivity {
    AdapterPatientWithoutCheckbox adapter;
    List<Patient> Patients;
    ListView mListView;
    EditText editText;
    SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_on_the_way);
        mListView = (ListView) findViewById(R.id.listView);
        DatabaseAccess db = new DatabaseAccess(this);
        Patients = db.getAllPatientsTech();
        adapter = new AdapterPatientWithoutCheckbox(this, R.layout.adapter_view_layout_without_checkbox, Patients);
        CheckBox checkB = (CheckBox) findViewById(R.id.checkbox);
        mListView.setAdapter(adapter);

        ImageButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(TechOnTheWay.this, TechMainActivity.class);
                startActivity(macintoshIntent2);
            }
        });
    }
}
