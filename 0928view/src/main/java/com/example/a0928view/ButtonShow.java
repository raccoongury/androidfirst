package com.example.a0928view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ButtonShow extends AppCompatActivity {
    //스레드를 annonymous class를 이용해서 만들것인데
    //anonymous class는 지역변수는 사용할 수 가 없습니다.
    ImageView imageView;
    Bitmap bitmap;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_show);

        ImageView imageView=(ImageView)findViewById(R.id.imagview);
        //리소스에 포함된 이미지 가져오기
        //imageView.setImageResource(R.drawable.gm1);

        //웹의 이미지 출력하기 url은 스레드로
        final String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdRGeJcgFZL9s73Vr9Py1GqTSUS84HRJv-o5MiS4nIcyNryO1Q";

        //이미지를 다운로드 받기 위한 스레드 생성
        Thread th = new Thread(){
            public void run(){
                try{
                    //웹에서 데이터를 가져올 수 있는 스트림을 생성
                    InputStream is = new URL(url).openStream();
                    //스트림의 데이터를 이미지로 변경
                    bitmap = BitmapFactory.decodeStream(is);
                }catch (Exception e){}

            }
        };
        //스레드 시작
        th.start();

        //스레드의 수행이 종료되면 이미지를 설정
        try{
            //스레드 수행이 종료될 때 까지 대기
            th.join();
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){}
    }
}
