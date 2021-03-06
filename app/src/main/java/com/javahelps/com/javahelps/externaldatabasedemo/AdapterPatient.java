package com.javahelps.com.javahelps.externaldatabasedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.javahelps.com.javahelps.externaldatabasedemo.Patient;
import com.javahelps.com.javahelps.externaldatabasedemo.R;

import java.util.ArrayList;
import java.util.List;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * Created by User on 3/14/2017.
 */

public class AdapterPatient extends ArrayAdapter<Patient> {

    private static final String TAG = "PatientListAdapter";

    private Context mContext;
    private int mResource;
    private static List<Patient> mObjects;


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
        mObjects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        Patient p=getPosition(position);
        String name = getItem(position).getFirstName();
        String zimontime = getItem(position).getZimonTime();
        String id = getItem(position).getId();
        String EnterTime = getItem(position).getEnterTime();
        String test = getItem(position).getTest();

        //Create the person object with the information


            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            TextView tvName=(TextView) convertView.findViewById(R.id.textView2);
            TextView tvZimon=(TextView) convertView.findViewById(R.id.textView1);

        Boolean check = getItem(position).getcheckbox();
        CheckBox cbBuy = (CheckBox) convertView.findViewById(R.id.CheckBox);
        cbBuy.setOnCheckedChangeListener(myCheckChangList);
        cbBuy.setTag(position);
        cbBuy.setChecked(p.box);

        Patient person = new Patient(id,name,zimontime,EnterTime,test);

        if (EnterTime==null) {
            tvName.setText(name);
            tvZimon.setText(zimontime);
        }


        return convertView;
    }

    private Patient getPosition(int position) {
        return ((Patient) getItem(position));
    }

    static ArrayList<Patient> getBox() {
        ArrayList<Patient> box = new ArrayList<Patient>();
        for (Patient p : mObjects) {
            if (p.box)
                box.add(p);
        }
        return box;
    }

    OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            if (isChecked) getPosition((Integer) buttonView.getTag()).box = true;
            else getPosition((Integer) buttonView.getTag()).box = false;
        }


    };
}
