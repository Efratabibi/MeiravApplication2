package com.javahelps.com.javahelps.externaldatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SecMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_main);

        DatabaseAccess db = new DatabaseAccess(this);
        ListView mListView = (ListView) findViewById(R.id.listView);
        Log.d("Reading : ", "Reading all shops..");
        List<Patient> Patients = db.getAllPatients();

        for (Patient P : Patients) {
            String log = "id: " + P.getId() + "first name: " + P.getFirstName() + "zimon time: " + P.getZimonTime();
// Writing shops to log
            Log.d("Patient: : ",log);
        }


        //Add the Person objects to an ArrayList

        AdapterPatient adapter = new AdapterPatient(this, R.layout.adapter_view_layout, Patients);
        mListView.setAdapter(adapter);
  /*      lv = (ListView) findViewById(R.id.listView1);
        ArrayList<HashMap<String, String>> feedList= new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("date", "1/7");
        map.put("description", "gift her");
        map.put("price", "23");
        map.put("discount", "25");
        feedList.add(map);

        map = new HashMap<String, String>();
        map.put("date", "1/8");
        map.put("description", "nice phone");
        map.put("price", "67");
        map.put("discount", "50");
        feedList.add(map);

        map = new HashMap<String, String>();
        map.put("date", "1/6");
        map.put("description", "hello");
        map.put("price", "33");
        map.put("discount", "50");
        feedList.add(map);


        map = new HashMap<String, String>();
        map.put("date", "1/3");
        map.put("description", "yo");
        map.put("price", "123");
        map.put("discount", "33");
        feedList.add(map);



        map = new HashMap<String, String>();
        map.put("date", "1/2");
        map.put("description", "nice phone");
        map.put("price", "67");
        map.put("discount", "50");
        feedList.add(map);



        map = new HashMap<String, String>();
        map.put("date", "23/12");
        map.put("description", "nice car");
        map.put("price", "6700");
        map.put("discount", "50");
        feedList.add(map);


        map = new HashMap<String, String>();
        map.put("date", "4/3");
        map.put("description", "nice phone");
        map.put("price", "678");
        map.put("discount", "70");
        feedList.add(map);

        map = new HashMap<String, String>();
        map.put("date", "1/12");
        map.put("description", "Ymmy burger");
        map.put("price", "12");
        map.put("discount", "10");
        feedList.add(map);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, feedList, R.layout.activity_sec_main, new String[]{"date", "description", "price", "discount"}, new int[]{R.id.textViewDate, R.id.textViewDescription, R.id.textViewDiscount, R.id.textViewPrice});
        lv.setAdapter(simpleAdapter); */
    }


      /*  TextView = (ListView) findViewById(R.id.textView1);
        TextView=(ListView) findViewById(R.id.textView1);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> userNames = databaseAccess.getUserNames();
        List<String> Pass = databaseAccess.getPasswords();
        databaseAccess.close();

        ArrayAdapter<String> adapterName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userNames);
        this.listView.setAdapter(adapterName); */


      /*  int count = quotes.size();
        for(int i = 0; i < count; i++) {
            adapter.add(quotes.get(i));
            adapter.add(quotes.get(i));

        }
*/
    }





