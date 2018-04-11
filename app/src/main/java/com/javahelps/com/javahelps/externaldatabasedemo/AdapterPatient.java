package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.javahelps.com.javahelps.externaldatabasedemo.Patient;
import com.javahelps.com.javahelps.externaldatabasedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/14/2017.
 */

public class AdapterPatient extends ArrayAdapter<Patient> {

    private static final String TAG = "PatientListAdapter";

    private Context mContext;
    private int mResource;


    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public AdapterPatient(Context context, int resource,List<Patient> objects) {
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
        String id = getItem(position).getId();

        //Create the person object with the information
        Patient person = new Patient(id,name,zimontime);

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            TextView tvName=(TextView) convertView.findViewById(R.id.textView2);
            TextView tvZimon=(TextView) convertView.findViewById(R.id.textView1);

        tvName.setText(name);
        tvZimon.setText(zimontime);


        return convertView;
    }
}
