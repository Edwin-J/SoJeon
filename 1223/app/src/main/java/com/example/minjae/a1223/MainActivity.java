package com.example.minjae.a1223;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter customAdapter;
    private List<Stu> stus = new ArrayList<>();

    private EditText editName, editPhone;
    private EditText editImage;
    private Button btnSave;


    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        editName = (EditText) findViewById(R.id.editName);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editImage = (EditText) findViewById(R.id.editImage);

        btnSave = (Button) findViewById(R.id.button);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                int phone = Integer.parseInt(editPhone.getText().toString());
                String image = editImage.getText().toString();

                realm.beginTransaction();
                Stu stu = realm.createObject(Stu.class);
                stu.setName(name);
                stu.setPhone(phone);
                stu.setImage(image);
                realm.commitTransaction();

                stus.add(stu);
                customAdapter = new CustomAdapter(getStus());
                listView.setAdapter(customAdapter);

            }
        });

        customAdapter = new CustomAdapter(getStus());
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RealmResults<Stu> all = realm.where(Stu.class).findAll();
                Stu stu = all.get(position);

                realm.beginTransaction();
                stu.deleteFromRealm();
                realm.commitTransaction();

                customAdapter = new CustomAdapter(getStus());
                listView.setAdapter(customAdapter);
            }
        });
    }

    private List<Stu> getStus() {
        //WHERE
        RealmResults<Stu> all = realm.where(Stu.class).findAll();
        stus = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            stus.add(all.get(i));
        }
        return stus;

    }


}
