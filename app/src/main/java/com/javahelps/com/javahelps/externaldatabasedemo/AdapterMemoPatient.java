package com.javahelps.com.javahelps.externaldatabasedemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        final int[] clickcount = {0};
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                clickcount[0] = clickcount[0] +1;
                if (clickcount[0] ==2)
                {
                    Globals g = Globals.getInstance();
                    g.setPatientId(id);



                AlertDialog.Builder alertbox = new AlertDialog.Builder(view.getRootView().getContext());
                    alertbox.setMessage("האם יש צורך בבדיקה חוזרת?").setCancelable(false).setPositiveButton("כן", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();


                        }
                    })
                            .setNegativeButton("לא", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });


                    alertbox.show();


                /*    Intent macintoshIntent = new Intent(mContext.getApplicationContext(),WhatsNext.class);
                    mContext.startActivity(macintoshIntent); */

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
