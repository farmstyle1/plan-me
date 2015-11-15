package com.pinbook.planme.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pinbook.planme.Fragment.FragmentExpense;
import com.pinbook.planme.Fragment.FragmentWork;

/**
 * Created by Miki on 11/15/2015.
 */
public class AddWorkAdapter extends FragmentPagerAdapter {
    private final int page_num = 2;

    public AddWorkAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new FragmentExpense();
        }else if(position == 1){
            return new FragmentWork();
        }
        return null;
    }

    @Override
    public int getCount() {
        return page_num;
    }
}
