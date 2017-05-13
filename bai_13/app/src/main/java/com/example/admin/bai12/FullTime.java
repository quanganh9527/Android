package com.example.admin.bai12;

/**
 * Created by admin on 5/13/2017.
 */

public class FullTime extends Employee {
    @Override
    public double tinhluong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString()+" FullTime"+"="+tinhluong();
    }
}
