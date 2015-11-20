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


    public static final String ARGS_POSITION = "name";
    private int MaxDate = 0;
    private int Date = 0;
    private String Month;



    public DayAdapter(FragmentManager fm,int MaxDate,int Date,String Month) {
        super(fm);
        this.MaxDate = MaxDate;
        this.Date = Date;
        this.Month = Month;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FragmentDay();
        Bundle Arg = new Bundle();
        Arg.putInt(ARGS_POSITION,position+1);
        fragment.setArguments(Arg);

        return fragment;
    }

    @Override
    public int getCount() {

        return MaxDate;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return (position + 1)+"";
    }




}
