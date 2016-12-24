package com.example.minjae.a1223;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<Stu> stus;

    public CustomAdapter(List<Stu> stus) {
        this.stus = stus;
    }

    @Override
    public int getCount() {
        return stus.size();
    }

    @Override
    public Object getItem(int i) {
        return stus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Context context = viewGroup.getContext();
        Stu stu = stus.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_student, viewGroup, false);
        }

        TextView textName = (TextView) view.findViewById(R.id.text_name);
        TextView textPhone = (TextView) view.findViewById(R.id.text_phone);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);

        textName.setText("이름 : " + stu.getName());
        textPhone.setText("나이 : " + stu.getPhone());
        Glide.with(viewGroup.getContext()).load("이미지 주소");

        return view;
    }

}