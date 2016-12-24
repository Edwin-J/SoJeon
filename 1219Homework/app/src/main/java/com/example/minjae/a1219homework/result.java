package com.example.minjae.a1219homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.view.View.Y;

public class result extends AppCompatActivity {
    TextView first;
    TextView second;
    TextView third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);
        third = (TextView) findViewById(R.id.third);

        int ai = Integer.parseInt(getIntent().getStringExtra("Y"));
        ai = ai % 10;
        int b = getIntent().getIntExtra("M", 0);
        int c = getIntent().getIntExtra("D", 0);

        switch (ai){
            case 0 : first.setText("외국에서");
                break;
            case 1 : first.setText("밤마다");
                break;
            case 2 : first.setText("어릴 적 부터");
                break;
            case 3 : first.setText("부모 잘못 만나서");
                break;
            case 4 : first.setText("타고나길");
                break;
            case 5 : first.setText("참하게 생겨서는");
                break;
            case 6 : first.setText("매일 아침마다");
                break;
            case 7 : first.setText("할 일없이");
                break;
            case 8 : first.setText("하루도 안 빠지고");
                break;
            case 9 : first.setText("재수 없게");
                break;
        }

        switch (b){
            case 1 : second.setText("남의 심부름만 하던");
                break;
            case 2 : second.setText("굶을 일은 없었던");
                break;
            case 3 : second.setText("돈만 펑펑 쓰던");
                break;
            case 4 : second.setText("쫄쫄 굶었던");
                break;
            case 5 : second.setText("개 끌고 산책만 하던");
                break;
            case 6 : second.setText("쳐먹기만 했던");
                break;
            case 7 : second.setText("사기를 잘 치던");
                break;
            case 8 : second.setText("밖을 싸돌아 다니던");
                break;
            case 9 : second.setText("남을 괴롭히기 좋아하던");
                break;
            case 10 : second.setText("애인을 갈아치우던");
                break;
            case 11 : second.setText("책 읽기를 좋아하던");
                break;
            case 12 : second.setText("밤일만 밝히던");
                break;
        }

        switch (b){
            case 1 : third.setText("미인대회 탈락자");
                break;
            case 2 : third.setText("조폭 두목");
                break;
            case 3 : third.setText("노름꾼");
                break;
            case 4 : third.setText("게이");
                break;
            case 5 : third.setText("내시");
                break;
            case 6 : third.setText("동네 바보");
                break;
            case 7 : third.setText("의사");
                break;
            case 8 : third.setText("친일파");
                break;
            case 9 : third.setText("백정");
                break;
            case 10 : third.setText("바람둥이");
                break;
            case 11 : third.setText("귀족");
                break;
            case 12 : third.setText("노숙자");
                break;
            case 13 : third.setText("빵셔틀");
                break;
            case 14 : third.setText("왕비");
                break;
            case 15 : third.setText("흥부네 막내");
                break;
            case 16 : third.setText("재별집 자식");
                break;
            case 17 : third.setText("돌쇠");
                break;
            case 18 : third.setText("왕초");
                break;
            case 19 : third.setText("대통령 자식");
                break;
            case 20 : third.setText("이장님");
                break;
            case 21 : third.setText("앞잡이");
                break;
            case 22 : third.setText("예술가");
                break;
            case 23 : third.setText("왕자");
                break;
            case 24 : third.setText("대통령");
                break;
            case 25 : third.setText("기생");
                break;
            case 26 : third.setText("사업가");
                break;
            case 27 : third.setText("추노");
                break;
            case 28 : third.setText("아랍 석유 재벌");
                break;
            case 29 : third.setText("노예");
                break;
            case 30 : third.setText("공주");
                break;
            case 31 : third.setText("빵집점원");
                break;
        }

    }
}
