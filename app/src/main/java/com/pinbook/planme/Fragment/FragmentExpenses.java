package com.pinbook.planme.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pinbook.planme.DB.MyDBHelper;
import com.pinbook.planme.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by admin on 16/11/2558.
 */
public class FragmentExpenses extends Fragment {

    private MyDBHelper dbHelper;
    private RadioGroup radioGroup;
    private Button btnCancel, btnOK;
    private EditText listExpenses, expenses;
    private String date, txtListExpenses, txtExpenses;
    private int priceTag, total = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_expense, container, false);

        listExpenses = (EditText)rootView.findViewById(R.id.listExpenses);
        expenses = (EditText)rootView.findViewById(R.id.expenses);

        Bundle bundle = this.getArguments();
        date = bundle.getString("date");



        btnCancel = (Button) rootView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        btnOK = (Button) rootView.findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtListExpenses = listExpenses.getText().toString();
                txtExpenses = expenses.getText().toString();

                if(txtListExpenses.matches("") || txtExpenses.matches("")) {

                }else{
                    priceTag =Integer.parseInt(txtExpenses);
                    radioGroup = (RadioGroup)rootView.findViewById(R.id.radioGroup);
                    int radioButtonID = radioGroup.getCheckedRadioButtonId();
                    View radioButton = radioGroup.findViewById(radioButtonID);
                    int position = radioGroup.indexOfChild(radioButton);
                    if(position==0){
                        priceTag*=-1;
                    }

                    dbHelper = new MyDBHelper(getContext());
                    total = dbHelper.queryTotal();
                    total+=priceTag;
                    dbHelper.updateTotal(total);
                    dbHelper.addExpenses(txtListExpenses, priceTag, date, String.valueOf(position));
                    getActivity().finish();
                }


            }
        });
        return rootView;
    }


}
