package com.pinbook.planme;


import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.Dialog.DialogFragmentDatePick;
import com.pinbook.planme.Model.ListActivityModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends FragmentActivity {
    private final String[] monthArr = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private MyDBHelper dbHelper;
    private int dayOfMonth, monthMaxDays, monthNum, year;
    private String monthName;
    private ArrayList<ListActivityModel> listActivityModel;
    private ListView listViewActivity;
    private ViewPager viewPager;
    private DayAdapter adapter;
    OnDateSetListener ondate = new OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int years, int month, int day) {

            monthNum = month;
            year = years;
            dayOfMonth = day;
            monthName = monthArr[monthNum];
            Calendar c = Calendar.getInstance();
            c.set(year,monthNum,dayOfMonth);
            monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            adapter = new DayAdapter(getSupportFragmentManager(), monthMaxDays, dayOfMonth, monthName, year, month);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(dayOfMonth - 1);


        }
    };
    private ImageView pickerDate;

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
        monthNum = c.get(Calendar.MONTH); // <----- month num
        year = c.get(Calendar.YEAR);
        monthName = String.format(Locale.ENGLISH, "%tB", c); //<----- month name
        pickerDate = (ImageView) findViewById(R.id.monthPicker);
        pickerDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });


        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new DayAdapter(getSupportFragmentManager(), monthMaxDays, dayOfMonth, monthName, year, monthNum);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(dayOfMonth - 1);


    }

    private void showDatePicker() {
        DialogFragmentDatePick date = new DialogFragmentDatePick();

        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", year);
        args.putInt("month", monthNum);
        args.putInt("day", dayOfMonth);
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(ondate);
        date.show(getSupportFragmentManager(), "Date Picker");
    }


}
