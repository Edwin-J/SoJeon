package com.example.minjae.a1219homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.Y;

public class MainActivity extends AppCompatActivity {
    //EditText year
    EditText month;
    EditText date;
    Button btn;
    Spinner year;
    ArrayList<Integer> arrayList;
    private Object a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        year = (Spinner) findViewById(R.id.year);
        month = (EditText) findViewById(R.id.month);
        date = (EditText) findViewById(R.id.date);
        btn = (Button) findViewById(R.id.button);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        year.setPrompt("연도");
        year.setAdapter(adapter);
        year.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                a=parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Month = month.getText().toString();
                final int M = Integer.valueOf(Month);
                String Date = date.getText().toString();
                final int D = Integer.valueOf(Date);

                    Intent intent = new Intent(MainActivity.this, result.class);
                    intent.putExtra("Y", a.toString());
                    intent.putExtra("M", 0);
                    intent.putExtra("D", 0);
                    startActivity(intent);
                    finish();
                }
            });

    }

}

