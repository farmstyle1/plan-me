package com.pinbook.planme.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.Adapter.ListActivityAdapter;
import com.pinbook.planme.Model.ListActivityModel;
import com.pinbook.planme.R;

import java.util.ArrayList;


public class FragmentDay extends Fragment {

    ArrayList<ListActivityModel>  listActivityModel;
    ListView listViewActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        int position = 0;
        Bundle bundle = getArguments();
        position = bundle.getInt(DayAdapter.ARGS_POSITION);

        // Sample add varible to Model

        listActivityModel = new ArrayList<ListActivityModel>();
        for (int i=0;i<=30;i++){
            ListActivityModel activityModel = new ListActivityModel("aaa",10,"15-11-2015","plus");
            listActivityModel.add(activityModel);
        }





        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_day,container,false);
        LinearLayout linearLayout = (LinearLayout)rootView.findViewById(R.id.linear_layout);

        ListActivityAdapter listActivityAdapter = new ListActivityAdapter(getContext(),listActivityModel);
        listViewActivity = (ListView)rootView.findViewById(R.id.listViewActivity);
        listViewActivity.setAdapter(listActivityAdapter);

        ImageView addition = (ImageView)rootView.findViewById(R.id.addition);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("check","button");
            }
        });









        return rootView;
    }
}

