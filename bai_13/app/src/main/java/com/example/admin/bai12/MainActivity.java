package com.example.admin.bai12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText ed1, ed2;
    Button button;
    RadioGroup radioGroup;
    Employee employee = null;
    ArrayList<Employee> arrayList;
    ArrayAdapter<Employee> arrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    nhapnv();
                    ed1.setText("");
                    ed2.setText("");
                    ed1.requestFocus();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Chưa Nhập thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init() {
        listView = (ListView) findViewById(R.id.listview);
        button = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.ma);
        ed2 = (EditText) findViewById(R.id.ten);
        radioGroup = (RadioGroup) findViewById(R.id.radi);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<Employee>(this,android.R.layout.simple_expandable_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    private void nhapnv() {
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == R.id.chinhthuc)
            employee = new FullTime();
        else employee = new PartTime();
        employee.setName(ed2.getText() + "");
        employee.setMa(ed1.getText() + "");
        arrayList.add(employee);
        arrayAdapter.notifyDataSetChanged();
    }
}
