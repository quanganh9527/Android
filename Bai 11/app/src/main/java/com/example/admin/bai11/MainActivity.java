package com.example.admin.bai11;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText, editText1,ebs;
    RadioGroup radioGroup;
    CheckBox c1, c2, c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();

    }

    private void init() {
        button = (Button) findViewById(R.id.butto);
        editText = (EditText) findViewById(R.id.ten);
        editText1 = (EditText) findViewById(R.id.cmnd);
        radioGroup = (RadioGroup) findViewById(R.id.radi);
        c1 = (CheckBox) findViewById(R.id.db);
        c2 = (CheckBox) findViewById(R.id.ds);
        c3 = (CheckBox) findViewById(R.id.dc);
        ebs=(EditText)findViewById(R.id.bosung);
    }

    private void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try{
                  testinfo(); dialog();
              }catch (Exception e){
                  Toast.makeText(MainActivity.this, "Chưa nhập thông tin", Toast.LENGTH_SHORT).show();
              }
            }
        });
    }

    private void testinfo() {
        ktTen();
        ktCMND();
        ktBang();
        sothich();
    }

    private void ktTen() {
        String tr = editText.getText().toString();
        tr.trim();
        if (tr.length() < 3) {
            editText.requestFocus();
            editText.selectAll();
            Toast.makeText(this, "Tên Không Hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    private void ktCMND() {
        String tr = editText1.getText().toString();
        if (tr.length() != 9) {
            editText1.requestFocus();
            editText1.selectAll();
            Toast.makeText(this, "CMND phải có 9 ký tự", Toast.LENGTH_SHORT).show();
        }
    }

    private String sothich() {
        String like = "";
        if (c1.isChecked())
            like += c1.getText() + "\n";
        if (c2.isChecked())
            like += c2.getText() + "\n";
        if (c3.isChecked())
            like += c3.getText() + "\n";
        return like;
    }

    private void ktBang() {
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == -1)
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_SHORT).show();
    }
    private void dialog(){
        final Dialog dialog = new Dialog(this);
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton)findViewById(id) ;

        dialog.setContentView(R.layout.showdialog);
        Button button = (Button)dialog.findViewById(R.id.button);
        TextView ten=(TextView)dialog.findViewById(R.id.tenn);
        TextView cm=(TextView)dialog.findViewById(R.id.cmndd);
        TextView bc=(TextView)dialog.findViewById(R.id.bcc);
        TextView like=(TextView)dialog.findViewById(R.id.likee);
        TextView bs=(TextView)dialog.findViewById(R.id.bss);
        ten.setText( editText.getText().toString());
        cm.setText(editText1.getText().toString());
        bs.setText(ebs.getText().toString());
        bc.setText(radioButton.getText().toString());
        like.setText(sothich());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
