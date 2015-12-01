package com.pinbook.planme;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.Adapter.ListActivityAdapter;
import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.Model.ListActivityModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends FragmentActivity {
    private MyDBHelper dbHelper;
    public int dayOfMonth,monthMaxDays,monthNum;
    private String  monthName;
    private ArrayList<ListActivityModel> listActivityModel;
    private ListView listViewActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect DB
        dbHelper = new MyDBHelper(this);
        dbHelper.openDB();
        // Get Day of Month & How many Day
        Calendar c = Calendar.getInstance();
        monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        monthName = String.format(Locale.ENGLISH,"%tB",c);
        monthNum = c.get(Calendar.MONTH);




        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        DayAdapter adapter = new DayAdapter(getSupportFragmentManager(),monthMaxDays,dayOfMonth,monthName);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(dayOfMonth - 1);

    }



}
