package com.task03;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sunrin on 2016-12-21.
 */
public class CustomAdapter extends BaseAdapter {

    private List<Stu> stuList;

    public CustomAdapter(List<Stu> stuList) {
        this.stuList = stuList;
    }

    @Override
    public int getCount() {
        return stuList.size();
    }

    @Override
    public Object getItem(int position) {
        return stuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //xml 불러오고
        //데이터를 직접 넣어주고
        Stu stu = stuList.get(position);

        boolean isleft = stu.isleft();
        String id = String.valueOf(stu.getId());
        String name = stu.getName();

        if(isleft == true) {
            View view
                    = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textViewId = (TextView) view.findViewById(R.id.textViewId);
            TextView textViewName = (TextView) view.findViewById(R.id.textViewName);

            // 여러 학생중 특정 position에 있는 한 학생을 불러온다.


            textViewId.setText(id);
            textViewName.setText(name);

            return view;
        }

        else {
            View view2
                    = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, null);

            ImageView imageView2 = (ImageView) view2.findViewById(R.id.imageView);
            TextView textViewId2 = (TextView) view2.findViewById(R.id.textViewId);
            TextView textViewName2 = (TextView) view2.findViewById(R.id.textViewName);

            textViewId2.setText(id);
            textViewName2.setText(name);

            return view2;
        }
    }
}













