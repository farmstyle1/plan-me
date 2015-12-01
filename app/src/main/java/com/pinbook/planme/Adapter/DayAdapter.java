package com.pinbook.planme.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.pinbook.planme.Fragment.FragmentDay;
import com.pinbook.planme.MainActivity;
import com.pinbook.planme.Model.ListActivityModel;

import java.util.ArrayList;
import java.util.Calendar;


public class DayAdapter extends FragmentStatePagerAdapter{


    public static final String ARGS_POSITION = "position", ARGS_MONTH = "month", ARGS_YEAR="year", ARGS_MONTHNUM="monthnum";
    private int MaxDate, year,monthNum;
    private String month;




    public DayAdapter(FragmentManager fm,int MaxDate,int Date,String month,int year,int monthNum) {
        super(fm);
        this.MaxDate = MaxDate;
        this.month = month;
        this.year = year;
        this.monthNum = monthNum;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FragmentDay();
        Bundle Arg = new Bundle();
        Arg.putInt(ARGS_POSITION,position+1);
        Arg.putString(ARGS_MONTH, month);
        Arg.putInt(ARGS_YEAR, year);
        Arg.putInt(ARGS_MONTHNUM, monthNum);
        fragment.setArguments(Arg);

        return fragment;
    }

    @Override
    public int getCount() {

        return MaxDate;
    }


    // Tab Fragment
    //@Override
    //public CharSequence getPageTitle(int position) {
    //    return (position + 1)+"";
    //}




}
