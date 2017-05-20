package com.example.admin.bai11;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText, editText1, ebs;
    RadioGroup radioGroup;
    CheckBox c1, c2, c3;
    ListView listView;
    ArrayList<NhanVien> arrayList;
    ImageView imageView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();

    }

    private void init() {
        listView = (ListView) findViewById(R.id.listview);
        imageView = (ImageView) findViewById(R.id.xoa);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.ten);
        editText1 = (EditText) findViewById(R.id.ma);
        radioGroup = (RadioGroup) findViewById(R.id.radi);
        arrayList = new ArrayList<NhanVien>();
        myAdapter = new MyAdapter(this, R.layout.activity_listview, arrayList);
        listView.setAdapter(myAdapter);
    }

    private void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
    }

    private void AddData() {
        int id = radioGroup.getCheckedRadioButtonId();
        if (editText.getText() == null || editText1.getText() == null) {
            Toast.makeText(this, "Mời Nhập dữ liệu", Toast.LENGTH_SHORT).show();

        } else {
            if (id == R.id.nu)
                arrayList.add(new NhanVien(editText.getText() + "", editText1.getText() + "", false));
            else
                arrayList.add(new NhanVien(editText.getText() + "", editText1.getText() + "", true));
            myAdapter.notifyDataSetChanged();
            editText.setText("");
            editText1.setText("");
            radioGroup.clearCheck();
            editText1.requestFocus();
        }

    }

    private void delete() {
        for (int i = listView.getChildCount() - 1; i >= 0; i--) {
                View view = listView.getChildAt(i);
                CheckBox checkBox = (CheckBox)view.findViewById(R.id.check);
            if(checkBox.isChecked())arrayList.remove(i);
        }
        myAdapter.notifyDataSetChanged();
    }
}
