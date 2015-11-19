package com.pinbook.planme;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.pinbook.planme.Adapter.ListActivityAdapter;
import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.Model.ListActivityModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends FragmentActivity {
    private MyDBHelper dbHelper;
    public int currentPage,dayOfMonth,monthMaxDays,thisMonth;
    private String date;
    private ArrayList<ListActivityModel> listActivityModel;
    private ListView listViewActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect DB
        dbHelper = new MyDBHelper(this);
        dbHelper.openDB();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = dateFormat.format(calendar.getTime());



        dbHelper = new MyDBHelper(MainActivity.this);
        listActivityModel = dbHelper.queryActivity(date);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        ListActivityAdapter listActivityAdapter = new ListActivityAdapter(MainActivity.this, listActivityModel);
        listViewActivity = (ListView) findViewById(R.id.listViewActivity);
        listViewActivity.setAdapter(listActivityAdapter);

        ImageView addition = (ImageView) findViewById(R.id.addition);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddWorkActivity.class);
                startActivity(intent);
            }
        });



    }


}
