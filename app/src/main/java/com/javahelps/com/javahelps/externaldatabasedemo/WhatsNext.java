package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WhatsNext extends AppCompatActivity {
    UpdateQueue MyQueue;
    final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_next);
        MyQueue = new UpdateQueue(this);

        Button insertmemo = (Button) findViewById(R.id.memob);
        Button insertultra = (Button) findViewById(R.id.ultrab);
        Button insertresults = (Button) findViewById(R.id.resultsb);
        Button insertunknown = (Button) findViewById(R.id.unknownb);
        Button transfer = (Button) findViewById(R.id.transferb);
        Button finish = (Button) findViewById(R.id.finishb);
        this.textView=(TextView) findViewById(R.id.textview1);
        Globals g = Globals.getInstance();
        textView.setText("מה השלב הבא בתהליך הטיפול של "+g.getPatientName()+"?");
        final String id=g.getPatientId();
        final String test=g.getTest();
        insertmemo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Globals g = Globals.getInstance();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                String formattedDate = df.format(c.getTime());
                boolean updateLeaveTime = MyQueue.updateLeaveTime(id,test,formattedDate.toString());
                boolean IsUpdated = MyQueue.updateIsActive(id,"0");
                boolean IsInsert = MyQueue.insertData(id, formattedDate.toString(), "", "1", "1");
                Intent macintoshIntent = new Intent(WhatsNext.this, memo.class);
                startActivity(macintoshIntent);
                Toast.makeText(WhatsNext.this, "הפציינטית נכנסה לתור לממוגרפיה", Toast.LENGTH_LONG).show();

                /* boolean IsInsert = MyQueue.insertData(IDToRemove, formattedDate.toString(), "", "1", "1"); */
            }
        });

        insertultra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Globals g = Globals.getInstance();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                String formattedDate = df.format(c.getTime());
                boolean updateLeaveTime = MyQueue.updateLeaveTime(id,test,formattedDate.toString());
                boolean IsUpdated = MyQueue.updateIsActive(id,"0");
                boolean IsInsert = MyQueue.insertData(id, formattedDate.toString(), "", "2", "1");
                Intent macintoshIntent = new Intent(WhatsNext.this, memo.class);
                startActivity(macintoshIntent);
                Toast.makeText(WhatsNext.this, "הפציינטית נכנסה לתור לאולטרסאונד", Toast.LENGTH_LONG).show();

                /* boolean IsInsert = MyQueue.insertData(IDToRemove, formattedDate.toString(), "", "1", "1"); */
            }
        });

        insertresults.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Globals g = Globals.getInstance();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                String formattedDate = df.format(c.getTime());
                boolean updateLeaveTime = MyQueue.updateLeaveTime(id,test,formattedDate.toString());
                boolean IsUpdated = MyQueue.updateIsActive(id,"0");
                boolean IsInsert = MyQueue.insertData(id, formattedDate.toString(), "", "3", "1");
                Intent macintoshIntent = new Intent(WhatsNext.this, ultra.class);
                startActivity(macintoshIntent);
                Toast.makeText(WhatsNext.this, "הפציינטית נכנסה לתור לתוצאות", Toast.LENGTH_LONG).show();

                /* boolean IsInsert = MyQueue.insertData(IDToRemove, formattedDate.toString(), "", "1", "1"); */
            }
        });


        insertunknown.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                finish();
                /* boolean IsInsert = MyQueue.insertData(IDToRemove, formattedDate.toString(), "", "1", "1"); */
            }
        });


        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Globals g = Globals.getInstance();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                String formattedDate = df.format(c.getTime());
                boolean updateLeaveTime = MyQueue.updateLeaveTime(id,test,formattedDate.toString());
                boolean IsUpdated = MyQueue.updateIsActive(id,"0");
                Intent macintoshIntent = new Intent(WhatsNext.this, TechMainActivity.class);
                startActivity(macintoshIntent);
                finish();
                /* boolean IsInsert = MyQueue.insertData(IDToRemove, formattedDate.toString(), "", "1", "1"); */
            }
        });


    }
}