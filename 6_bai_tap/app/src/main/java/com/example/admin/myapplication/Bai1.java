package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai1 extends AppCompatActivity {
    Button tong, hieu, tich, thuong, butxoa;
    TextView kq;
    EditText editTexta, editTextb;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        init();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 1");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setEvent();

    }

    public void setEvent() {
        tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    kq.setText(Integer.parseInt(editTexta.getText().toString()) + Integer.parseInt(editTextb.getText().toString()) + "");
                } catch (Exception e) {
                    Toast.makeText(Bai1.this, "Mời Nhập a,b", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    kq.setText(Integer.parseInt(editTexta.getText().toString()) - Integer.parseInt(editTextb.getText().toString()) + "");
                } catch (Exception e) {
                    Toast.makeText(Bai1.this, "Mời Nhập a,b", Toast.LENGTH_SHORT).show();
                }
            }
        });
        thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    kq.setText(Integer.parseInt(editTexta.getText().toString()) * Integer.parseInt(editTextb.getText().toString()) + "");
                } catch (Exception e) {
                    Toast.makeText(Bai1.this, "Mời Nhập a,b", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    kq.setText(Integer.parseInt(editTexta.getText().toString()) / Integer.parseInt(editTextb.getText().toString()) + "");
                } catch (Exception e) {
                    Toast.makeText(Bai1.this, "Mời Nhập a,b", Toast.LENGTH_SHORT).show();
                }
            }
        });
        butxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kq.setText("");
                editTexta.setText("");
                editTextb.setText("");
                editTexta.forceLayout();
                editTexta.requestFocus();
            }
        });
    }

    public void init() {
        tong = (Button) findViewById(R.id.tong);
        hieu = (Button) findViewById(R.id.hieu);
        tich = (Button) findViewById(R.id.tich);
        thuong = (Button) findViewById(R.id.thuong);
        editTexta = (EditText) findViewById(R.id.soa);
        editTextb = (EditText) findViewById(R.id.sob);
        kq = (TextView) findViewById(R.id.kq);
        butxoa = (Button) findViewById(R.id.xoa);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
