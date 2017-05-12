package com.example.admin.myapplication;

import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai3 extends AppCompatActivity implements View.OnClickListener{

    Button button;
    EditText ed1 ,ed2,ed3,ed4,ed5;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        init();
    }
    public void init(){
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        ed1 =(EditText) findViewById(R.id.edten);
        ed2 =(EditText) findViewById(R.id.edcao);
        ed3 =(EditText) findViewById(R.id.ednang);
        ed4 =(EditText) findViewById(R.id.edBMi);
        ed5 =(EditText) findViewById(R.id.edkq);
        toolbar=(Toolbar)findViewById(R.id.toolbar3) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 3");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
            try{
               double BMI = BMI(Double.parseDouble(ed2.getText().toString()),Double.parseDouble(ed3.getText().toString()));
                String chuandoan="";
                if(BMI<18)chuandoan="Bạn gầy";
                else if(BMI<24.9)chuandoan="Bạn Bình Thường";
                else if(BMI<29.9) chuandoan="Bạn béo phì cấp độ 1";
                else if(BMI<34.9) chuandoan="Bạn béo phì cấp độ 2";
                else chuandoan="Bạn béo phì cấp độ 3";
                DecimalFormat decimalFormat = new DecimalFormat("#.0");
                ed5.setText(chuandoan);
                ed4.setText(decimalFormat.format(BMI));
            }
            catch (Exception e){
                Toast.makeText(this, "Bạn chưa nhập giá trị", Toast.LENGTH_SHORT).show();
            }


    }
    public double BMI(double a,double b){
            return b/(Math.pow(a,2));
    }
}
