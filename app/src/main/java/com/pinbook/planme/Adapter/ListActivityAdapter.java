package com.pinbook.planme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinbook.planme.Model.ListActivityModel;
import com.pinbook.planme.R;

import java.util.ArrayList;

/**
 * Created by Miki on 11/15/2015.
 */
public class ListActivityAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListActivityModel> listActivityModel;
    private int[] statusImg = new int[]{R.drawable.minus, R.drawable.plus};


    public ListActivityAdapter(Context context, ArrayList<ListActivityModel> listActivityModel) {
        this.context = context;
        this.listActivityModel = listActivityModel;
    }

    @Override
    public int getCount() {
        return listActivityModel.size();
    }

    @Override
    public Object getItem(int position) {
        return listActivityModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imageStatus;
        TextView txtActivity,txtPrice;



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if( convertView == null){

            convertView = inflater.inflate(R.layout.adapter_list_activity,null);
            holder = new ViewHolder();

            holder.imageStatus = (ImageView)convertView.findViewById(R.id.imageStatus);
            holder.txtActivity = (TextView)convertView.findViewById(R.id.txtActivity);
            holder.txtPrice = (TextView)convertView.findViewById(R.id.txtPrice);
            convertView.setTag(holder);



        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        ListActivityModel b = listActivityModel.get(position);
        holder.txtActivity.setText(b.getActivity());
        int abs = b.getPrice();
        if (abs<0){
            abs*=-1;
        }
        holder.txtPrice.setText(abs+" THB");
        holder.imageStatus.setImageResource(statusImg[Integer.parseInt(b.getStatus())]);


        return convertView;
    }

    public void swapItems(ArrayList<ListActivityModel> items) {
        this.listActivityModel = items;
        notifyDataSetChanged();
    }
}
