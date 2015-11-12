package com.pinbook.planme;


import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.pinbook.planme.Adapter.DayAdapter;



public class MainActivity extends FragmentActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        DayAdapter adapter = new DayAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);



    }
}
