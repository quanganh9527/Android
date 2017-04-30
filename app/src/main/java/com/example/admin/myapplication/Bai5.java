package com.example.admin.myapplication;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai5 extends AppCompatActivity {
    Toolbar toolbar;
    Button bt1, bt2, bt3;
    TextView textView;
    EditText ed1, ed2, ed3;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == bt1) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                textView.setText("");
                ed1.requestFocus();
            } else if (v == bt2) {
                try {
                    giaipt(Double.parseDouble(ed1.getText().toString()), Double.parseDouble(ed2.getText().toString()), Double.parseDouble(ed3.getText().toString()));
                } catch (Exception e) {
                    Toast.makeText(Bai5.this, "Bạn chưa nhập giá trị", Toast.LENGTH_SHORT).show();
                }
            } else {
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);
        toolbar = (Toolbar) findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 5");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        inint();
        bt1.setOnClickListener(onClickListener);
        bt2.setOnClickListener(onClickListener);
        bt3.setOnClickListener(onClickListener);

    }


    public void inint() {
        bt1 = (Button) findViewById(R.id.tt);
        bt2 = (Button) findViewById(R.id.gt);
        bt3 = (Button) findViewById(R.id.exit);
        ed1 = (EditText) findViewById(R.id.eda);
        ed2 = (EditText) findViewById(R.id.edb);
        ed3 = (EditText) findViewById(R.id.edc);
        textView = (TextView) findViewById(R.id.kq);
    }

    public void giaipt(double a, double b, double c) {
        DecimalFormat dcf = new DecimalFormat("#.00");
        String kq = "";
        if (a == 0) {
            if (b == 0) {
                if (c == 0)
                    kq = "PT vô số nghiệm";
                else
                    kq = "PT vô nghiệm";
            } else {
                kq = "Pt có 1 No, x=" + dcf.format((-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                kq = "PT vô nghiệm";
            } else if (delta == 0) {
                kq = "Pt có No kép x1=x2=" + (double)(-b / (2 * a));
            } else {
                kq = "Pt có 2 No: x1 = " + (double)(-b - Math.sqrt(delta) / (double)(2 * a)) + "   x2 = " + (double)(-b + Math.sqrt(delta) / (double)(2 * a));
            }
        }
        textView.setText(kq);
    }
}
