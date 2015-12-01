package com.pinbook.planme;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.Adapter.ListActivityAdapter;
import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.Model.ListActivityModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends FragmentActivity {
    private MyDBHelper dbHelper;
    public int dayOfMonth, monthMaxDays, month, year;
    private String monthName;
    private ArrayList<ListActivityModel> listActivityModel;
    private ListView listViewActivity;
    private ViewPager viewPager;
    private DayAdapter adapter;



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
        month = c.get(Calendar.MONTH); // <----- month num
        year = c.get(Calendar.YEAR);
        monthName = String.format(Locale.ENGLISH, "%tB", c); //<----- month name



        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new DayAdapter(getSupportFragmentManager(),monthMaxDays,dayOfMonth,monthName,year,month);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(dayOfMonth - 1);

    }


}
