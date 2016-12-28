package com.example.minjae.nogadagame;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    private LinearLayout main;

    private Button changeprofile;
    private Button video;
    private Button loving;
    private Button timeline;

    private TextView s;
    private TextView p;
    private TextView m;

    private ImageView image;

    private int stress;
    private int popularity;
    private int money;
    private int psa;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private Drawable one;
    private Drawable two;
    private Drawable three;
    private Drawable four;
    private Drawable five;
    private Drawable six;
    private Drawable defalt;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.sim);
        changeprofile = (Button) findViewById(R.id.changeProfile);
        video = (Button) findViewById(R.id.uploadVideo);
        loving = (Button) findViewById(R.id.loving);
        timeline = (Button) findViewById(R.id.timeLine);
        s = (TextView) findViewById(R.id.stress);
        p = (TextView) findViewById(R.id.popularity);
        m = (TextView) findViewById(R.id.money);

        one = getResources().getDrawable(R.drawable.one);
        two = getResources().getDrawable(R.drawable.two);
        three = getResources().getDrawable(R.drawable.three);
        four = getResources().getDrawable(R.drawable.four);
        five = getResources().getDrawable(R.drawable.five);
        six = getResources().getDrawable(R.drawable.six);
        defalt = getResources().getDrawable(R.drawable.main);

        sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        stress = sharedPreferences.getInt("stress", 0);
        popularity = sharedPreferences.getInt("popularity", 0);
        money = sharedPreferences.getInt("money", 0);
        psa = sharedPreferences.getInt("psa", 10);

        switch (psa){
            case 1 : image.setImageDrawable(one);
            case 2 : image.setImageDrawable(two);
            case 3 : image.setImageDrawable(three);
            case 4 : image.setImageDrawable(four);
            case 5 : image.setImageDrawable(five);
            case 6 : image.setImageDrawable(six);
            case 10 : image.setImageDrawable(defalt);
        }

        s.setText("스트레스 : " + stress);
        p.setText("인지도 : " + popularity);
        m.setText("활동지수 : " + money);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int cnt = random.nextInt(100)+1;

                money += cnt;
                editor.putInt("money", money);
                editor.commit();
                m.setText("활동지수 : " + money);
            }
        });

        if(stress >= 100){
            editor.clear();
            editor.commit();
            Intent intent = new Intent(MainActivity.this, Death.class);
            startActivity(intent);
            finish();
        }
        else if(popularity >= 100 && popularity % 100 == 0){
            AlertDialog.Builder ending = new AlertDialog.Builder(MainActivity.this);
            ending.setMessage("인지도 킹이 되었습니다. 당신의 계정을 사려는 사람들이 많습니다.\n계정을 판매하시겠습니까?");
            ending.setCancelable(false).setNegativeButton("더 할래요!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).setPositiveButton("좋아요!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    editor.clear();
                    editor.commit();
                    Intent intent = new Intent(MainActivity.this, Ending.class);
                    startActivity(intent);
                    finish();
                }
            });
           ending.show();
        }
        else if(popularity >= 100 && popularity % 10 == 0){
            final AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
            ad.setMessage("인지도가 높습니다. 광고 계약 문의가 끊이지 않네요.\n광고 계약을 하시겠습니까? 인지도가 떨어집니다.");
            ad.setCancelable(false).setNegativeButton("아니요,,", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).setPositiveButton("네!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    money += 200000;
                    popularity -= 5;
                    editor.putInt("money", money);
                    editor.putInt("popularity", popularity);
                    editor.commit();
                    AlertDialog.Builder check = new AlertDialog.Builder(MainActivity.this);
                    check.setMessage("활동지수 +200000, 인지도 -5");
                    ad.setCancelable(false).setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    check.show();
                    m.setText("활동지수 : " + money);
                }
            });
            ad.show();
        }

        changeprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (money < 10000) {
                    AlertDialog.Builder nomoney = new AlertDialog.Builder(MainActivity.this);
                    nomoney.setMessage("활동지수가 부족합니다!");
                    nomoney.setCancelable(false).setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    nomoney.show();
                } else {
                    AlertDialog.Builder pro = new AlertDialog.Builder(MainActivity.this);
                    pro.setMessage("프로필 사진을 바꾸시겠습니까?\n스트레스가 쌓입니다.");
                    pro.setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            stress += 10;
                            popularity += 2;
                            money -= 10000;
                            editor.putInt("stress", stress);
                            editor.putInt("popularity", popularity);
                            editor.putInt("money", money);

                            s.setText("스트레스 : " + stress);
                            p.setText("인지도 : " + popularity);
                            m.setText("활동지수 : " + money);

                            Random random = new Random();
                            int rand = random.nextInt(6) + 1;
                            switch (rand){
                                case 1 : image.setImageDrawable(one);
                                case 2 : image.setImageDrawable(two);
                                case 3 : image.setImageDrawable(three);
                                case 4 : image.setImageDrawable(four);
                                case 5 : image.setImageDrawable(five);
                                case 6 : image.setImageDrawable(six);
                            }
                            editor.putInt("psa", rand);
                            editor.commit();

                            AlertDialog.Builder check = new AlertDialog.Builder(MainActivity.this);
                            check.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            check.setMessage("스트레스 +10\n" +
                                    "인지도 +1");
                            check.show();
                        }
                    }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    pro.show();
                }
            }
        });


        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (money < 50000) {
                    AlertDialog.Builder nomoney = new AlertDialog.Builder(MainActivity.this);
                    nomoney.setMessage("활동지수가 부족합니다!");
                    nomoney.setCancelable(false).setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    nomoney.show();
                } else {
                    AlertDialog.Builder vod = new AlertDialog.Builder(MainActivity.this);
                    vod.setMessage("영상을 업로드 하시겠습니까?\n스트레스 해소에 도움이 될 수도!!");
                    vod.setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            stress -= 10;
                            popularity += 2;
                            money -= 50000;
                            editor.putInt("stress", stress);
                            editor.putInt("popularity", popularity);
                            editor.putInt("money", money);
                            editor.commit();
                            s.setText("스트레스 : " + stress);
                            p.setText("인지도 : " + popularity);
                            m.setText("활동지수 : " + money);

                            AlertDialog.Builder check = new AlertDialog.Builder(MainActivity.this);
                            check.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            check.setMessage("스트레스 -10\n" +
                                    "인지도 +1");
                            check.show();
                        }
                    }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    vod.show();
                }
            }
        });


        timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (money < 300000) {
                    AlertDialog.Builder nomoney = new AlertDialog.Builder(MainActivity.this);
                    nomoney.setMessage("활동지수가 부족합니다!");
                    nomoney.setCancelable(false).setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    nomoney.show();
                } else {
                    AlertDialog.Builder lov = new AlertDialog.Builder(MainActivity.this);
                    lov.setMessage("팔로워의 타임라인을 방문하시겠습니까?\n" +
                            "스트레스가 해소되는 느낌일 듯 합니다..");
                    lov.setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            stress -= 10;
                            popularity += 10;
                            money -= 300000;
                            editor.putInt("stress", stress);
                            editor.putInt("popularity", popularity);
                            editor.putInt("money", money);
                            editor.commit();
                            s.setText("스트레스 : " + stress);
                            p.setText("인지도 : " + popularity);
                            m.setText("활동지수 : " + money);

                            AlertDialog.Builder check = new AlertDialog.Builder(MainActivity.this);
                            check.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            check.setMessage("스트레스 -10\n" +
                                    "인지도 +10");
                            check.show();
                        }
                    }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    lov.show();
                }
            }
        });


        loving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (money < 1000000) {
                    AlertDialog.Builder nomoney = new AlertDialog.Builder(MainActivity.this);
                    nomoney.setMessage("활동지수가 부족합니다!");
                    nomoney.setCancelable(false).setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    nomoney.show();
                } else {
                    AlertDialog.Builder lov = new AlertDialog.Builder(MainActivity.this);
                    lov.setMessage("연애중을 띄우시겠습니까?");
                    lov.setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            stress += 10;
                            popularity += 50;
                            money -= 1000000;
                            editor.putInt("stress", stress);
                            editor.putInt("popularity", popularity);
                            editor.putInt("money", money);
                            editor.commit();
                            s.setText("스트레스 : " + stress);
                            p.setText("인지도 : " + popularity);
                            m.setText("활동지수 : " + money);

                            AlertDialog.Builder check = new AlertDialog.Builder(MainActivity.this);
                            check.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            check.setMessage("스트레스 +10\n" +
                                    "인지도 +50");
                            check.show();
                        }
                    }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    lov.show();
                }
            }
        });
    }
}
