package com.example.admin.bai11;

/**
 * Created by admin on 5/19/2017.
 */

public class NhanVien {
    String name;
    String ma;
    boolean check;

    public NhanVien() {
    }

    public NhanVien(String name, String ma, boolean check) {
        this.name = name;
        this.ma = ma;
        this.check = check;
    }

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

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return this.ma+" - "+this.name;
    }
}
