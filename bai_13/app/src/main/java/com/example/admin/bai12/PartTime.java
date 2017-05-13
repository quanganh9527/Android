package com.example.admin.bai12;

/**
 * Created by admin on 5/13/2017.
 */

public class PartTime extends Employee{

    @Override
    public double tinhluong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString()+" PartTime="+tinhluong();
    }
}
