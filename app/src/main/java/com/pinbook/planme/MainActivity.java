package com.pinbook.planme;


import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.pinbook.planme.Adapter.DayAdapter;

import java.util.Calendar;


public class MainActivity extends FragmentActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get Day of Month & How many Day
        Calendar c = Calendar.getInstance();
        int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
       // Log.i("Check",String.valueOf(dayOfMonth));

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        DayAdapter adapter = new DayAdapter(getSupportFragmentManager(),monthMaxDays,dayOfMonth);
        viewPager.setAdapter(adapter);





    }


}
