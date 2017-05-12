package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai2 extends AppCompatActivity {
    Button button;
    EditText ed1 ;
    TextView textView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        init();
        toolbar=(Toolbar)findViewById(R.id.toolbar2) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 2");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    textView.setText(ktcan(Integer.parseInt(ed1.getText().toString()))+" "+ktchi(Integer.parseInt(ed1.getText().toString())));
                }
                catch (Exception e){
                    Toast.makeText(Bai2.this, "Mời Nhập Năm", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void init(){
        button = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.nhap);
        textView= (TextView)findViewById(R.id.kq);
    }
    public String ktcan(int a ){
        int n = a%10;
        String s="";
        switch (n){
            case 0: s="Canh" ;break;
            case 1: s="Tân" ;break;
            case 2: s="Nhâm" ;break;
            case 3: s="Quý" ;break;
            case 4: s="Giáp" ;break;
            case 5: s="Ất" ;break;
            case 6: s="Bính" ;break;
            case 7: s="Đinh" ;break;
            case 8: s="Mậu" ;break;
            case 9: s="Kỷ" ;break;
        }
        return s;
    }
    public String ktchi(int a){
        int n = a%12;
        String s ="";
        switch (n){
            case 0: s="Thân" ;break;
            case 1: s="Dậu" ;break;
            case 2: s="Tất" ;break;
            case 3: s="Hợi" ;break;
            case 4: s="Tí" ;break;
            case 5: s="Sửu" ;break;
            case 6: s="Dần" ;break;
            case 7: s="Mẹo" ;break;
            case 8: s="Thìn" ;break;
            case 9: s="Tỵ" ;break;
            case 10: s="Ngọ" ;break;
            case 11: s="Mùi" ;break;
        }
        return s;
    }

}

