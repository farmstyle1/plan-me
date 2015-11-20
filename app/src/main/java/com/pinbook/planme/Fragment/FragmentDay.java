package com.pinbook.planme.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.Adapter.ListActivityAdapter;
import com.pinbook.planme.AddWorkActivity;
import com.pinbook.planme.AutoResizeTextView;
import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.Model.ListActivityModel;
import com.pinbook.planme.R;

import java.util.ArrayList;


public class FragmentDay extends Fragment {
    private MyDBHelper dbHelper;
    private String date;
    private ArrayList<ListActivityModel> listActivityModel;
    private ListView listViewActivity;
    private AutoResizeTextView txtTotal;
    private ListActivityAdapter listActivityAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = 0;
        Bundle bundle = getArguments();
        position = bundle.getInt(DayAdapter.ARGS_POSITION);
        date = (position + "-11-2015");
        dbHelper = new MyDBHelper(getContext());
        listActivityModel = dbHelper.queryActivity(date);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_day, container, false);
        listActivityAdapter = new ListActivityAdapter(getContext(), listActivityModel);
        listViewActivity = (ListView) rootView.findViewById(R.id.listViewActivity);
        listViewActivity.setAdapter(listActivityAdapter);
        txtTotal = (AutoResizeTextView) rootView.findViewById(R.id.total);
        ImageView addition = (ImageView) rootView.findViewById(R.id.addition);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddWorkActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        listActivityModel = dbHelper.queryActivity(date);
        listActivityAdapter.swapItems(listActivityModel);
        int i = 0;
        int total = 0;
        for (i = 0; i < listActivityModel.size(); i++) {
            ListActivityModel b = listActivityModel.get(i);
            total += b.getPrice();
        }
        txtTotal.setText(String.valueOf(total) + " THB");
    }
}

