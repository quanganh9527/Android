package com.example.admin.bai12;

/**
 * Created by admin on 5/13/2017.
 */

public abstract class Employee {
    String name;
    String ma;
    public abstract double tinhluong();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Override
    public String toString() {
        return this.ma +" - " +this.name;
    }
}
