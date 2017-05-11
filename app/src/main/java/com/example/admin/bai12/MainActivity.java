package com.example.admin.bai12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, e1, e2, e3;
    Button button, b2, b3;
    CheckBox checkBoxl;
    TextView tt;
    ArrayList<KhachHang> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tt.setText(tinh() + "");
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Mời nhập thông tin Kh", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tt();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Mời nhập thông tin Kh", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
                    e1.setText(arrayList.size()+"");
                    e2.setText(vip() + "");
                    e3.setText(tongtien() + "");
//                } catch (Exception e) {
//                    Toast.makeText(MainActivity.this, "Chưa có thông tin khách hàng", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    public void init() {
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        b2 = (Button) findViewById(R.id.tiep);
        b3 = (Button) findViewById(R.id.thongke);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        checkBoxl = (CheckBox) findViewById(R.id.check);
        button = (Button) findViewById(R.id.tinhtien);
        tt = (TextView) findViewById(R.id.tt);
        arrayList = new ArrayList<>();
    }

    private double tinh() {
        if (checkBoxl.isChecked())
            return (Double.parseDouble(ed2.getText().toString()) - Double.parseDouble(ed2.getText().toString()) * 10 / 100)*20000;
        else return Double.parseDouble(ed2.getText().toString())*20000;
    }

    private void tt() {
        KhachHang kh = new KhachHang(ed1.getText().toString(), Integer.parseInt(ed2.getText().toString()), checkBoxl.isChecked(), tinh());
        arrayList.add(kh);
        ed1.setText("");
        ed1.requestFocus();
        ed2.setText("");
        tt.setText("");
        checkBoxl.setChecked(false);
    }

    private int vip() {
        int dem = 0;
        for (KhachHang k : arrayList)
            dem += k.isVip();
        return dem;
    }

    private double tongtien() {
        double s = 0;
        for (KhachHang k : arrayList)
            s += k.getTt();
        return s;
    }
}
