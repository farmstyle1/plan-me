package com.pinbook.planme.Model;

/**
 * Created by Miki on 11/15/2015.
 */
public class ListActivityModel {
    public int id;
    public String activity;
    public int price;
    public String date;
    public String status;

    public ListActivityModel(int id, String activity, int price, String date,String status) {
        this.id=id;
        this.activity = activity;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivity() {
        return activity;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
