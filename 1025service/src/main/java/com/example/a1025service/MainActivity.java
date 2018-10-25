package com.example.a1025service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*
        //스레드
        Thread th = new Thread(){
            @Override
            public void run(){
                for(int i=0; i<30; i=i+1){
                    try{
                        Thread.sleep(1000);
                        Log.e("Thread", i+"");
                    }catch(Exception e){}
            }
        };
            th.star();
            */
/*
        Intent intent = new Intent(this, MyIntentService.class);
        //인텐트서비스 실행
        startService(intent);
*/


        Intent intent1 = new Intent(this, MyStartService.class);
        //스타트서비스 실행
        startService(intent1);
    }
}
