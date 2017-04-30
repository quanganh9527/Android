package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Bai6 extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai6);
        toolbar=(Toolbar)findViewById(R.id.toolbar6) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 6");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        createButton();
    }
    public void createButton(){
        Button  bt = new Button(this){
            @Override
            public boolean performClick() {
                Toast.makeText(Bai6.this, "click", Toast.LENGTH_SHORT).show();
                return super.performClick();
            }
        };

        bt.setText("But9");
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear);
        linearLayout.addView(bt);
    }
}
