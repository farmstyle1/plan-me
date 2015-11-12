package com.pinbook.planme.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.pinbook.planme.Fragment.FragmentDay;
import com.pinbook.planme.MainActivity;

import java.util.Calendar;


public class DayAdapter extends FragmentStatePagerAdapter{


    public static final String ARGS_POSITION = "name";
    int MaxDate = 0;
    int Date = 0;


    public DayAdapter(FragmentManager fm,int MaxDate,int Date) {
        super(fm);
        this.MaxDate = MaxDate;
        this.Date = Date;
        Log.i("Check Adapter",String.valueOf(Date));
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FragmentDay();
        Bundle Arg = new Bundle();
        Arg.putInt(ARGS_POSITION,Date);
        fragment.setArguments(Arg);

        return fragment;
    }

    @Override
    public int getCount() {

        return MaxDate;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return "" + (position + 1);
    }


}
