package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatient extends AppCompatActivity {

    UpdateDB myDb;
    EditText editID, editFirstName, editLastname, editZimonDate, editZimonTime, editType, editMemo, editUs, editDoctor, editTech;
    Button AddPatient;
    Button Cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        myDb = new UpdateDB(this);


        editID = (EditText) findViewById(R.id.txtID);
        editFirstName = (EditText) findViewById(R.id.txtFirstName);
        editLastname = (EditText) findViewById(R.id.txtLastName);
        editZimonDate = (EditText) findViewById(R.id.txtZimonDate);

        editZimonTime = (EditText) findViewById(R.id.txtZimonTime);
        editType = (EditText) findViewById(R.id.txtType);
        editMemo = (EditText) findViewById(R.id.txtMemo);
        editUs = (EditText) findViewById(R.id.txtUS);
        editDoctor = (EditText) findViewById(R.id.txtDoctor);
        editTech = (EditText) findViewById(R.id.txtTech);

        AddPatient = (Button) findViewById(R.id.AddPatient);
        Cancel= (Button) findViewById(R.id.Cancel);

        AddPatient.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editID.getText().toString(),
                                editFirstName.getText().toString(),
                                editLastname.getText().toString(), editZimonDate.getText().toString(),
                                editZimonTime.getText().toString(), editType.getText().toString(),
                                editMemo.getText().toString(), editUs.getText().toString(),
                                editDoctor.getText().toString(), editTech.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(AddPatient.this, "Data Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddPatient.this, "Data not Updated", Toast.LENGTH_LONG).show();



                        Intent macintoshIntent = new Intent(AddPatient.this, SecMainActivity.class);
                        startActivity(macintoshIntent);
                        finish();

                    }


                });




        Cancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent macintoshIntent = new Intent(AddPatient.this, SecMainActivity.class);
                        startActivity(macintoshIntent);
                        finish();

                    }


                });


    }
}