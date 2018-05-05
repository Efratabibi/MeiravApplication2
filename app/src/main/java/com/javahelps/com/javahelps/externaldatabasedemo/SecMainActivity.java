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
                            if (isInsert == true)
                                Toast.makeText(SecMainActivity.this, "GDfdsata Update", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(SecMainActivity.this, "NONONONO", Toast.LENGTH_LONG).show();
                        }

                        // Toast.makeText(SecMainActivity.this, "GData Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SecMainActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        initList();


                    }
                }
            }

        });

        Button Add = (Button) findViewById(R.id.Add);
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
                        if (isDeleted == -1)
                            Toast.makeText(SecMainActivity.this, "NONONONO", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SecMainActivity.this, "GDfdsata Update", Toast.LENGTH_LONG).show();
                        initList();
                    }
                }
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

   /*     initList();

        for (Patient P : Patients) {
            String log = "id: " + P.getId() + "first name: " + P.getFirstName() + "zimon time: " + P.getZimonTime();
// Writing shops to log
            Log.d("Patient: : ",log);
        } */


//Add the Person objects to an ArrayList



       /* editText.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {



            }



            @Override

            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {

                if(s.toString().equals("")){

                    // reset listview

                    initList();

                }

                else{

                    // perform search

                    searchItem(s.toString());

                }

            }



            @Override

            public void afterTextChanged(Editable s) {



            }

        });

    }



    public void searchItem(String textToSearch){

        for(String item:names){

            if(!item.contains(textToSearch)){

                Patients.remove(1);

            }

        }

        adapter.notifyDataSetChanged();


    }
    public void initList(){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        names = databaseAccess.getAllFullNames();
        adapter = new AdapterPatient(this, R.layout.adapter_view_layout, Patients);
        mListView.setAdapter(adapter); */


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