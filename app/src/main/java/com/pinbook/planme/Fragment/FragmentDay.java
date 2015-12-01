package com.pinbook.planme.Fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.Adapter.ListActivityAdapter;
import com.pinbook.planme.AddWorkActivity;
import com.pinbook.planme.AutoResizeTextView;
import com.pinbook.planme.CallBack;
import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.Model.ListActivityModel;
import com.pinbook.planme.R;

import java.util.ArrayList;
import java.util.Calendar;

import javax.security.auth.callback.Callback;


public class FragmentDay extends Fragment implements CallBack  {
    private MyDBHelper dbHelper;
    private String date, monthName;
    private ArrayList<ListActivityModel> listActivityModel;
    private ListView listViewActivity;
    private ImageView addition, monthPicker;
    private AutoResizeTextView txtTotal, txtBalance, txtDate;
    private ListActivityAdapter listActivityAdapter;
    private int balance, day, monthNum, year;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = 0;
        Bundle bundle = getArguments();
        day = bundle.getInt(DayAdapter.ARGS_POSITION);
        monthName = bundle.getString(DayAdapter.ARGS_MONTH);
        year = bundle.getInt(DayAdapter.ARGS_YEAR);
        monthNum = bundle.getInt(DayAdapter.ARGS_MONTHNUM);


        date = (day+" "+monthName+" "+year);

        dbHelper = new MyDBHelper(getContext());
        listActivityModel = dbHelper.queryActivity(date);

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_day, container, false);
        listActivityAdapter = new ListActivityAdapter(getContext(), listActivityModel);
        listViewActivity = (ListView) rootView.findViewById(R.id.listViewActivity);
        listViewActivity.setAdapter(listActivityAdapter);


        txtBalance = (AutoResizeTextView)rootView.findViewById(R.id.balance);
        txtTotal = (AutoResizeTextView) rootView.findViewById(R.id.total);
        txtDate = (AutoResizeTextView) rootView.findViewById(R.id.date);
        txtDate.setText(day+"  "+monthName);

        addition = (ImageView) rootView.findViewById(R.id.addition);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddWorkActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

        monthPicker = (ImageView)rootView.findViewById(R.id.monthPicker);
        monthPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment picker = new DatePickerFragment();
                picker.show(getFragmentManager(), "datePicker");


            }
        });


        return rootView;
    }

    @Override
    public void setDate(String date) {

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
            if(b.getPrice() < 0 ){
                total += b.getPrice();
            }
        }
        if(total < 0){
            total*=-1;
        }
        balance = dbHelper.queryTotal();
        txtBalance.setText("Balance        "+ String.valueOf(balance) + " THB");
        txtTotal.setText(String.valueOf(total) + " THB");
    }
}

