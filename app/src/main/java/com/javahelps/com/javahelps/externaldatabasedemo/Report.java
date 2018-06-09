package com.javahelps.com.javahelps.externaldatabasedemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Report extends AppCompatActivity {

    BarChart barChart;
    HorizontalBarChart barChart2;
    final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


        barChart=(BarChart) findViewById(R.id.barchart);
        barChart.setMaxVisibleValueCount(20);
        ArrayList<BarEntry> bargroup1 = new ArrayList<>();

      YAxis leftAxis = barChart.getAxisLeft();
        YAxis rightAxis = barChart.getAxisRight();
        leftAxis.setEnabled(false);
       rightAxis.setEnabled(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setDescription(null);
        XAxis xAxis=barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.setPinchZoom(false);

        bargroup1.add(new BarEntry(Float.parseFloat("4"), 0));
        bargroup1.add(new BarEntry(Float.parseFloat("1"), 1));
        bargroup1.add(new BarEntry(Float.parseFloat("3"), 2));

// create BarEntry for Bar Group 1
        ArrayList<BarEntry> bargroup2 = new ArrayList<>();
        bargroup2.add(new BarEntry(Float.parseFloat("1"), 0));
        bargroup2.add(new BarEntry(Float.parseFloat("0"), 1));
        bargroup2.add(new BarEntry(Float.parseFloat("2"), 2));

        ArrayList<BarEntry> bargroup3 = new ArrayList<>();
        bargroup3.add(new BarEntry(Float.parseFloat("1"), 0));
        bargroup3.add(new BarEntry(Float.parseFloat("3"), 1));
        bargroup3.add(new BarEntry(Float.parseFloat("0"), 2));

// creating dataset for Bar Group1
        BarDataSet barDataSet1 = new BarDataSet(bargroup1, "ממוגרפיה");
        barDataSet1.setValueTextSize(10);
//barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(Collections.singletonList(Color.BLUE));
        barDataSet1.setValueTextSize(12f);
// creating dataset for Bar Group 2
        BarDataSet barDataSet2 = new BarDataSet(bargroup2, "אולטרסאונד");
        barDataSet2.setColors(Collections.singletonList(Color.argb((214), 109, 179, 99)));
        barDataSet2.setValueTextSize(10);
        barDataSet2.setValueTextSize(12f);

        BarDataSet barDataSet3 = new BarDataSet(bargroup3, "תוצאות");
        barDataSet3.setColors(Collections.singletonList(Color.GRAY));
        barDataSet3.setValueTextSize(10);
        barDataSet3.setValueTextSize(12f);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("אילנה");
        labels.add("לאה");
        labels.add("סיוון");

        ArrayList<BarDataSet> dataSets = new ArrayList<>();  // combined all dataset into an arraylist
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        dataSets.add(barDataSet3);

// initialize the Bardata with argument labels and dataSet
        BarData data = new BarData(labels, dataSets);
        barChart.setBorderColor(Color.RED);
        barChart.setBorderWidth(1f);
        barChart.setData(data);
        barChart.setGridBackgroundColor(Color.argb((214),214,204,220));
        barChart.setBorderColor(Color.BLACK);
        barChart.getXAxis().setTextSize(15f);
        barChart.setDescriptionTextSize(15f);


        //    YAxis leftAxis = barChart.getAxisLeft();
        //   YAxis rightAxis = barChart.getAxisRight();
        //    leftAxis.setEnabled(false);
        //   rightAxis.setEnabled(false);
        //     barChart.setDrawValueAboveBar(true);
       //    barChart.setDescription(null);

barChart2=(HorizontalBarChart) findViewById(R.id.barchart2);
 ArrayList<BarEntry> HorizontalBarChartGroup = new ArrayList<>();


        YAxis leftAxis2 = barChart2.getAxisLeft();
        YAxis rightAxis2 = barChart2.getAxisRight();
        leftAxis2.setEnabled(false);
        rightAxis2.setEnabled(false);
        barChart2.setDrawValueAboveBar(true);
        barChart2.setDescription(null);



 HorizontalBarChartGroup.add(new BarEntry(Float.parseFloat("29.4"),0));
 HorizontalBarChartGroup.add(new BarEntry(Float.parseFloat("23.5"),1));
 HorizontalBarChartGroup.add(new BarEntry(Float.parseFloat("9.2"),2));


        ArrayList<String> labels2 = new ArrayList<String>();
        labels2.add("ממוגרפיה");
        labels2.add("אולטרסאונד");
        labels2.add("תוצאות");


        BarDataSet set1;
        set1=new BarDataSet(HorizontalBarChartGroup,"");
        set1.setValueTextSize(10);
        set1.setBarSpacePercent(1f);
        set1.setColor(Color.argb((214),128,128,128));
        set1.setValueTextColor(Color.BLACK);
        BarData data2 = new BarData(labels2, set1);
        barChart2.setData(data2);
        barChart2.setGridBackgroundColor(Color.argb((214),214,204,220));
        barChart2.setBorderColor(Color.BLACK);
        barChart2.setDescriptionTextSize(15f);
        barChart2.getXAxis().setTextSize(15f);

        ImageButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent macintoshIntent2 = new Intent(Report.this, TechMainActivity.class);
                startActivity(macintoshIntent2);
            }
        });

  /*   barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);




        ArrayList<BarEntry> barEntries= new ArrayList<>();
        barEntries.add(new BarEntry(1,40f));
        barEntries.add(new BarEntry(2,44f));
        barEntries.add(new BarEntry(3,30f));

        ArrayList<BarEntry> barEntries1= new ArrayList<>();
        barEntries1.add(new BarEntry(1,44f));
        barEntries1.add(new BarEntry(2,54f));
        barEntries1.add(new BarEntry(3,60f));

        ArrayList<BarEntry> barEntries2= new ArrayList<>();
        barEntries2.add(new BarEntry(1,44f));
        barEntries2.add(new BarEntry(2,54f));
        barEntries2.add(new BarEntry(3,60f));

        BarDataSet barDataSet = new BarDataSet(barEntries,"Date Set1");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet1 = new BarDataSet(barEntries1,"Date Set1");
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(barEntries2,"Date Set1");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData data = new BarData(barDataSet,barDataSet1,barDataSet2);

        float groupspace=0.1f;
        float barSpace=0.02f;
        float barWidth=0.28f;

        barChart.setData(data);
        data.setBarWidth(barWidth);
        barChart.groupBars(1,groupspace,barSpace);

        String[] tech = new String[] {"א","לאה","אילנה","סיוון","ה"};
        XAxis XAxis=barChart.getXAxis();
        XAxis.setValueFormatter(new MyxAxisValueFormatter(tech));
        XAxis.setPosition(com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTH_SIDED);
        XAxis.setGranularity(1);
        XAxis.setCenterAxisLabels(true);
        XAxis.setAxisMinimum(1);

    }



    public class MyxAxisValueFormatter implements IAxisValueFormatter{
        private String[] mValues;
        public MyxAxisValueFormatter(String[] values){
            this.mValues=values;
        }
        public String getFormattedValue(float value, AxisBase axis)
        {return mValues[(int)value];}

*/
    }

}