package com.pinbook.planme.Fragment;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinbook.planme.R;


/**
 * Created by Miki on 11/15/2015.
 */
public class FragmentExpense extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_expense,container,false);
        return rootView;
    }
}
