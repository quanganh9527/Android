package com.example.admin.bai11;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/19/2017.
 */

public class MyAdapter extends ArrayAdapter<NhanVien> {
    Activity activity = null;
    ArrayList<NhanVien> arrayList = null;
    int layoutid;

    public MyAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.arrayList = objects;
        this.layoutid = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(layoutid, null);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageee);
        TextView textView = (TextView) convertView.findViewById(R.id.tennn);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check);
        NhanVien nv = arrayList.get(position);
        textView.setText(nv.toString());
        if (nv.isCheck())
            image.setImageResource(R.drawable.boy);
        else image.setImageResource(R.drawable.girl);
        return convertView;
    }
}
