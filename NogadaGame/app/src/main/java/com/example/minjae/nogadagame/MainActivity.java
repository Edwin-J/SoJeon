package com.example.minjae.nogadagame;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout main;
    private ImageButton call;
    private ImageButton shop;
    private ImageButton setting;

    private ImageView touch;

    private AlertDialog.Builder shopping = new AlertDialog.Builder(this);

    int cnt;
    int power = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = (LinearLayout)findViewById(R.id.activity_main);
        call = (ImageButton)findViewById(R.id.call);
        shop = (ImageButton)findViewById(R.id.shop);
        setting = (ImageButton)findViewById(R.id.setting);
        touch = (ImageView)findViewById(R.id.touch);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.setImageDrawable();
                cnt += power;
                if(cnt >= 50)
                    touch.setImageDrawable();
                else if(cnt >= 500)
                    touch.setImageDrawable();
                else if(cnt >= 1000)
                    touch.setImageDrawable();
                else if(cnt >= 30000)
                    touch.setImageDrawable();
                else if(cnt >= 100000)
                    touch.setImageDrawable();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopping.setTitle("무기 강화");
                shopping.setMessage("무기를 강화하시겠습니까?");
                shopping.setCancelable(false);
                shopping.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        power *= 2;
                        finish();
                    }
                });
                shopping.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                shopping.create();
                shopping.show();
            }
        });


    }
}
