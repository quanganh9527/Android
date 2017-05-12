package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bai4 extends AppCompatActivity {
    Toolbar toolbar;
    EditText ed1, ed2;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        init();
        b1.setOnClickListener(onClickListener);
        b2.setOnClickListener(onClickListener);
        b3.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (v == b1)
                try {
                    ed2.setText(fsangc(Float.parseFloat(ed1.getText().toString())) + "");
                } catch (Exception e) {
                    Toast.makeText(Bai4.this, "Mời Bạn Nhập Độ F", Toast.LENGTH_SHORT).show();
                }
            else if (v == b2)
                try {
                    ed1.setText(csangf(Float.parseFloat(ed2.getText().toString())) + "");
                } catch (Exception e) {
                    Toast.makeText(Bai4.this, "Mời Bạn Nhập Độ C", Toast.LENGTH_SHORT).show();
                }
            else {
                try {
                    ed1.setText("");
                    ed2.setText("");
                    ed1.requestFocus();
                } catch (Exception e) {
                    Toast.makeText(Bai4.this, e + "", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    public void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar4);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        b3 = (Button) findViewById(R.id.clear);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 4");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private float csangf(float a) {
        return (a * (float)(9 / 5)) + (float)32;
    }

    private float fsangc(float a) {
        return (a - (float)32) * (float)(9 / 5);
    }
}
