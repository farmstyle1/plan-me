package com.pinbook.planme.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.R;


public class FragmentDay extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        int position = 0;




        Bundle bundle = getArguments();
        position = bundle.getInt(DayAdapter.ARGS_POSITION);


        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_day,container,false);
        TextView greeting = (TextView)rootView.findViewById(R.id.greeting);
        LinearLayout linearLayout = (LinearLayout)rootView.findViewById(R.id.linear_layout);







        return rootView;
    }
}
