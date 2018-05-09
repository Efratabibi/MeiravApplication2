package com.javahelps.com.javahelps.externaldatabasedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class Report extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        barChart=(BarChart) findViewById(R.id.barchart);

         barChart.setDrawBarShadow(false);
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


    }

}