package com.example.admin.bai12;

/**
 * Created by admin on 5/10/2017.
 */

public class KhachHang {
    String ten;
    int so;
    boolean vip;
    double tt;
    public KhachHang(String ten, int so, boolean vip,double tt) {
        this.ten = ten;
        this.so = so;
        this.vip = vip;
        this.tt=tt;
    }


    public int isVip() {
        if(this.vip)
            return 1;
        else return 0;
    }
    public double getTt() {
        return tt;
    }
}
