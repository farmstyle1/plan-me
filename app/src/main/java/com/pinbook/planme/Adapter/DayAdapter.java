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


    public static final String ARGS_POSITION = "name", ARGS_MONTH = "month";
    private int MaxDate = 0;
    private int Date = 0;
    private String MonthName;



    public DayAdapter(FragmentManager fm,int MaxDate,int Date,String MonthName) {
        super(fm);
        this.MaxDate = MaxDate;
        this.Date = Date;
        this.MonthName = MonthName;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FragmentDay();
        Bundle Arg = new Bundle();
        Arg.putInt(ARGS_POSITION,position+1);
        Arg.putString(ARGS_MONTH,MonthName);
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
