package com.pinbook.planme.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.pinbook.planme.Adapter.DayAdapter;
import com.pinbook.planme.Adapter.ListActivityAdapter;
import com.pinbook.planme.AddWorkActivity;
import com.pinbook.planme.AutoResizeTextView;
import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.Dialog.DialogFragmentDeleteActivity;
import com.pinbook.planme.Model.ListActivityModel;
import com.pinbook.planme.MyTextView;
import com.pinbook.planme.R;

import java.util.ArrayList;


public class FragmentDay extends DialogFragment  {
    private MyDBHelper dbHelper;
    private String date, monthName;
    private ArrayList<ListActivityModel> listActivityModel;
    private ListView listViewActivity;
    private ImageView addition, monthPicker;
    private ListActivityAdapter listActivityAdapter;
    private int balance, day, monthNum, year;
    private MyTextView txtTotal, txtDate;




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
        listViewActivity.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final ListActivityModel ls = listActivityModel.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


                builder.setTitle("DELETE");
                builder.setMessage(getResources().getString(R.string.Delete));
                builder.setNegativeButton(getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.deleteActivity(ls.getId());
                        int total = dbHelper.queryTotal();
                        total-=ls.getPrice();
                        dbHelper.updateTotal(total);
                        onResume();

                    }
                });

                builder.show();


                return true;
            }
        });

        //txtBalance = (AutoResizeTextView)rootView.findViewById(R.id.balance);
        txtTotal = (MyTextView) rootView.findViewById(R.id.total);
        txtDate = (MyTextView) rootView.findViewById(R.id.date);

        txtDate.setText(day + "  " + monthName + " " + year);

        addition = (ImageView) rootView.findViewById(R.id.addition);
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
            if(b.getPrice() < 0 ){
                total += b.getPrice();
            }
        }
        if(total < 0){
            total*=-1;
        }
        balance = dbHelper.queryTotal();
        //txtBalance.setText("Balance        "+ String.valueOf(balance) + " THB");
        txtTotal.setText(String.valueOf(total) + "   THB");
    }
}

