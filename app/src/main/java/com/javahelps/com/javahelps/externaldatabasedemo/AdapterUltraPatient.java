package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.javahelps.com.javahelps.externaldatabasedemo.Patient;
import com.javahelps.com.javahelps.externaldatabasedemo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by User on 3/14/2017.
 */

public class AdapterUltraPatient extends ArrayAdapter<Patient> {

    private static final String TAG = "PatientListAdapter";

    private Context mContext;
    private int mResource;
    UpdateQueue MyQueue;


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public AdapterUltraPatient(Context context, int resource,List<Patient> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        String name = getItem(position).getFirstName();
        String zimontime = getItem(position).getZimonTime();
        final String id = getItem(position).getId();
        String EnterTime = getItem(position).getEnterTime();
        String test = "2";

        //Create the person object with the information
        Patient person = new Patient(id,name,zimontime,EnterTime,test);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName=(TextView) convertView.findViewById(R.id.textView2);
        TextView tvZimon=(TextView) convertView.findViewById(R.id.textView1);

  /*      if ((EnterTime!=null)&&(test.equals('2'))) {
            tvName.setText(name);
            tvZimon.setText(EnterTime);
        }
        else
        {
            tvName.setVisibility(View.INVISIBLE);
            tvZimon.setVisibility(View.INVISIBLE);
            bt.setVisibility(View.INVISIBLE);
        } */

        final Button bt=(Button) convertView.findViewById(R.id.button_id);
        final int[] clickcount = {0};
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clickcount[0] = clickcount[0] +1;
                if (clickcount[0] ==2)
                {
                    Globals g = Globals.getInstance();
                    g.setPatientId(id);
                    g.setTest("2");
                    Intent macintoshIntent = new Intent(mContext.getApplicationContext(),WhatsNext.class);
                    mContext.startActivity(macintoshIntent);

                }
                else {
                    bt.setBackgroundResource(R.drawable.exit);
                    Globals g = Globals.getInstance();
                    g.setPatientId(id);
                    Calendar c = Calendar.getInstance();
                    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                    String formattedDate = df.format(c.getTime());
                }
            }
        });

        tvName.setText(name);
        tvZimon.setText(EnterTime);


        return convertView;
    }
}
