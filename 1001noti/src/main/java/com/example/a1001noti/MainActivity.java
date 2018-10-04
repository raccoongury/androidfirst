package com.example.a1001noti;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnvibrate, btnsystemsound, btnusersound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        //[비동기적 수행] - 잘못만들어진 경우
        Button btnprogress = (Button)findViewById(R.id.btnprogress);
        btnprogress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("액티비티 종료")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.lion)
                        .show();

                //토스트 출력
                Toast.makeText(MainActivity.this, "토스트 출력", Toast.LENGTH_LONG).show();

                //액티비티 종료
                finish();
            }
        });
*/

        //[비동기적 수행]
        Button btnprogress = (Button)findViewById(R.id.btnprogress);
        btnprogress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("액티비티 종료")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.lion)
                        .setPositiveButton("프로그램 종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();

                //토스트 출력
                Toast.makeText(MainActivity.this, "토스트 출력", Toast.LENGTH_LONG).show();
            }
        });

        //[기본 대화상자 출력] -
        Button btnbasicalert = (Button)findViewById(R.id.btnbasicalert);
        btnbasicalert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //메소드 체이닝을 이용한 생성과 출력
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("기본 대화상자")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.lion)
                        .setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        "긍정을 눌렀습니다.", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("부정", null)
                        .setNeutralButton("중립", null)
                        .setCancelable(false)//빽버튼으로 대화상자 닫히는거 막기
                        .show();
            }
        });

        //[토스트 출력] -
        Button btntoast = (Button)findViewById(R.id.btntoast);
        btntoast.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "안녕하세요 토스트입니다.",
                        Toast.LENGTH_LONG).show();
            }
        });

        //버튼 찾아오기
        btnvibrate = (Button)findViewById(R.id.btnvibrate);
        btnsystemsound = (Button)findViewById(R.id.btnsystemsound);
        btnusersound = (Button)findViewById(R.id.btnusersound);

        //[진동 만들기]
        btnvibrate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Vibrator vib =
                        (Vibrator)getSystemService(VIBRATOR_SERVICE);
                long [] ar = {100,100,100,100,200,100,100,100,150,100};
                vib.vibrate(ar, -1);

            }
        });

        //[시스템 사운드]
        btnsystemsound.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri systemsound =
                        RingtoneManager.getDefaultUri(
                                RingtoneManager.TYPE_RINGTONE);
                Ringtone ringtone =
                        RingtoneManager.getRingtone(
                                getApplicationContext(), systemsound);
                ringtone.play();


            }
        });

        //[사용자 효과음]
        btnusersound.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                MediaPlayer player =
                        MediaPlayer.create(
                                MainActivity.this, R.raw.pug);
                player.start();
            }
        });

    }
}
