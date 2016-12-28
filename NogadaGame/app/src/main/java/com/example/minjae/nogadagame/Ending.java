package com.example.minjae.nogadagame;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        AlertDialog.Builder builder = new AlertDialog.Builder(Ending.this);
        builder.setMessage("당신은 페북이라는 감옥에서 탈출했습니다.\n당신이야말로 진정한 승자입니다.");
        builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}
