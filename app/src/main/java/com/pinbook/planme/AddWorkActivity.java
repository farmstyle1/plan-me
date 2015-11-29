package com.pinbook.planme;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.pinbook.planme.Fragment.FragmentExpenses;
import com.pinbook.planme.Fragment.FragmentWorks;

public class AddWorkActivity extends FragmentActivity {


    private Button btnExpenses;
    private Button btnWorks;
    private final int[] colors = {
            Color.rgb(255, 255, 255),
            Color.rgb(244, 244, 244)
    };
    private String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);

        Bundle bundle = getIntent().getExtras();
        date = bundle.getString("date");
        firstRun();

        btnExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWorks.setBackgroundColor(colors[1]);
                btnExpenses.setBackgroundColor(colors[0]);
                FragmentExpenses fragmentExpenses = new FragmentExpenses();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layoutFragment, fragmentExpenses);
                transaction.commit();
                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                fragmentExpenses.setArguments(bundle);


            }
        });

        btnWorks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnExpenses.setBackgroundColor(colors[1]);
                btnWorks.setBackgroundColor(colors[0]);
                FragmentWorks fragmentWorks = new FragmentWorks();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layoutFragment, fragmentWorks);
                transaction.commit();
            }
        });


    }

    private void firstRun(){

        btnExpenses = (Button) findViewById(R.id.btnExpenses);
        btnWorks = (Button) findViewById(R.id.btnWorks);
        btnWorks.setBackgroundColor(colors[1]);

        FragmentExpenses fragmentExpenses = new FragmentExpenses();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutFragment, fragmentExpenses);
        transaction.commit();
        Bundle bundle = new Bundle();
        bundle.putString("date", date);
        fragmentExpenses.setArguments(bundle);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_work, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
