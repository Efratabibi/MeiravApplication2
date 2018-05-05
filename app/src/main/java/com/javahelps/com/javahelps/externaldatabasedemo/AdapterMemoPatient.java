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
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.javahelps.com.javahelps.externaldatabasedemo.Patient;
import com.javahelps.com.javahelps.externaldatabasedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/14/2017.
 */

public class AdapterMemoPatient extends ArrayAdapter<Patient>  {

    private static final String TAG = "PatientListAdapter";

    private Context mContext;
    private int mResource;
    private Button bt;


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public AdapterMemoPatient(Context context, int resource,List<Patient> objects) {
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
        final String test = "1";

        //Create the person object with the information
        Patient person = new Patient(id,name,zimontime,EnterTime,test);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName=(TextView) convertView.findViewById(R.id.textView2);
        TextView tvZimon=(TextView) convertView.findViewById(R.id.textView1);
        final Button bt=(Button) convertView.findViewById(R.id.button_id);

        bt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if ( bt.getText()=="יציאה")
                {
                    Globals g = Globals.getInstance();
                    g.setPatientId(id);
                    g.setTest("1");
                    Intent macintoshIntent = new Intent(mContext.getApplicationContext(),WhatsNext.class);
                    mContext.startActivity(macintoshIntent);
                }
                else {
                    bt.setBackgroundColor(Color.RED);
                    bt.setText("יציאה");
                }
            }
        });

        tvName.setText(name);
        tvZimon.setText(EnterTime);

        /*
        if ((EnterTime!=null)&&(test.equals('1'))) {
            tvName.setText(name);
            tvZimon.setText(EnterTime);
        }
        else
        {
            tvName.setVisibility(View.INVISIBLE);
            tvZimon.setVisibility(View.INVISIBLE);
            bt.setVisibility(View.INVISIBLE);
        } */

        return convertView;
    }
}