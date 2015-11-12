package com.pinbook.planme.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.pinbook.planme.Fragment.FragmentDay;
import com.pinbook.planme.MainActivity;


public class DayAdapter extends FragmentStatePagerAdapter{

    public static final String ARGS_POSITION = "name";
    private final int PAGE_NUM = 31;

    public DayAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FragmentDay();
        Bundle Arg = new Bundle();
        Arg.putInt(ARGS_POSITION,position);
        fragment.setArguments(Arg);

        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
