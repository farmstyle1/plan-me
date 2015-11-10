package com.pinbook.planme.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pinbook.planme.Fragment.FragmentOne;
import com.pinbook.planme.Fragment.FragmentTwo;


public class DayAdapter extends FragmentPagerAdapter {

    private final int PAGE_NUM = 2;

    public DayAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new FragmentOne();
        }else if(position==1){
            return new FragmentTwo();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
