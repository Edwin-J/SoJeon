package com.task03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private List<Stu> stuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stuList.add(new Stu(true, "홍길동", 13));
        stuList.add(new Stu(false, "짱구", 14));
        stuList.add(new Stu(true, "철수", 15));
        stuList.add(new Stu(true, "유리", 16));
        stuList.add(new Stu(false, "짱아", 17));
        stuList.add(new Stu(false, "태준", 18));
        stuList.add(new Stu(false, "정우", 19));
        stuList.add(new Stu(true, "미어캣", 20));
        stuList.add(new Stu(false, "호랑이", 21));
        stuList.add(new Stu(true, "은표", 22));
        stuList.add(new Stu(true, "코난", 23));
        stuList.add(new Stu(false, "최도이", 24));


        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(stuList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}










