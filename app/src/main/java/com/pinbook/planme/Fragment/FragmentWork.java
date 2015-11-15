package com.pinbook.planme.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinbook.planme.R;

/**
 * Created by Miki on 11/15/2015.
 */
public class FragmentWork extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_work,container,false);
        return rootView;
    }
}
