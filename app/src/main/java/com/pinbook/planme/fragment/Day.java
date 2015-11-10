package com.pinbook.planme.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinbook.planme.R;

/**
 * Created by admin on 10/11/2558.
 */
public class Day extends Fragment {
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int position = 0;
        int[] color={
                Color.rgb(0xF6, 0x47, 0x47), // #F64747
                Color.rgb(0x9A, 0x12, 0xB3), // #9A12B3
                Color.rgb(0x22, 0xA7, 0xF0), // #22A7F0
                Color.rgb(0x4B, 0x77, 0xBE), // #4B77BE
                Color.rgb(0x1B, 0xBC, 0x9B), // #1BBC9B
                Color.rgb(0xF2, 0x79, 0x35)  // #F27935
        };

        ViewGroup rooView = (ViewGroup)inflater.inflate(R.layout.fragment_day,container,false);


        return rooView;
    }
}
