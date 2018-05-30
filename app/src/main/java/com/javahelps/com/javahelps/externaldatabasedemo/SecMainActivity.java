package com.javahelps.com.javahelps.externaldatabasedemo;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.view.View.OnClickListener;
import android.widget.SearchView.OnQueryTextListener;

//import static com.javahelps.com.javahelps.externaldatabasedemo.DatabaseAccess.RemoveID;

public class SecMainActivity extends AppCompatActivity {
    AdapterPatient adapter;
    List<Patient> Patients;
    ListView mListView;
    String IDToRemove;
    SearchView sv;
    Button Arrival;
    UpdateDB MyDB;
    UpdateQueue MyQueue;
    EditText editText;
    String IdToEdit;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_main);
        mListView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.txtsearch);
        initList();

        MyDB = new UpdateDB(this);
        MyQueue= new UpdateQueue(this);
        Button Arrival = (Button) findViewById(R.id.confirm);
        Arrival.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                for (Patient p : AdapterPatient.getBox()) {
                    if (p.box) {
                        String IDToRemove = p.getId();
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                        String formattedDate = df.format(c.getTime());
                        // String idtoremove="201946287";
                        boolean isUpdate = MyDB.updateData(IDToRemove, formattedDate.toString());
                        if (isUpdate == true) {
                            boolean isInsert = MyQueue.insertData(IDToRemove, formattedDate.toString(), "null", "1", "1");
                        }

                        // Toast.makeText(SecMainActivity.this, "GData Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SecMainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        initList();


                    }
                }
            }

        });

        ImageButton Add = (ImageButton) findViewById(R.id.Add);
        Add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent macintoshIntent = new Intent(SecMainActivity.this, AddPatient.class);
                startActivity(macintoshIntent);
                finish();
            }

        });


        Button Delete = (Button) findViewById(R.id.Delete);
        Delete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                for (Patient p : AdapterPatient.getBox()) {
                    if (p.box) {
                        String IDToRemove = p.getId();
                        // String idtoremove="201946287";
                        Integer isDeleted = MyDB.deleteData(IDToRemove);
                        initList();
                    }
                }
            }
        });


        Button logout = (Button) findViewById(R.id.b5);
        logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent macintoshIntent3 = new Intent(SecMainActivity.this, LoginActivity.class);
                startActivity(macintoshIntent3);
            }
        });








        //     / //  Toast.makeText(SecMainActivity.this, ((String)result+"\n"+"Total Amount:="+totalAmount), Toast.LENGTH_LONG).show();
        // }



        editText.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {


            }


            @Override

            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {

                if (s.toString().equals("")) {

                    // reset listview

                    initList();

                } else {

                    // perform search

                    searchItem(s.toString());

                }

            }


            @Override

            public void afterTextChanged(Editable s) {


            }

        });

    }


    public void searchItem(String textToSearch) {
        for (int i = 0; i < Patients.size(); i++) {
            if (!Patients.get(i).getFirstName().contains(textToSearch)) {

                Patients.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }


    public void initList() {
        DatabaseAccess db = new DatabaseAccess(this);
        Patients = db.getAllPatients();
        adapter = new AdapterPatient(this, R.layout.adapter_view_layout, Patients);
        mListView.setAdapter(adapter);


    }




    public String GetIDToEdit() {
        return IdToEdit;
    }






}

