package com.pinbook.planme;


import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.pinbook.planme.Adapter.DayAdapter;

import java.util.Calendar;
import java.util.Locale;


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
        String month = String.format(Locale.ENGLISH,"%tB",c);
        //Log.i("Check",month);
        Log.i("Check",String.valueOf(dayOfMonth));

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        DayAdapter adapter = new DayAdapter(getSupportFragmentManager(),monthMaxDays,dayOfMonth,month);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(dayOfMonth-1);







    }


}
