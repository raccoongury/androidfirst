package com.example.a1017thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int i = 0;
//                while(i < 10) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Log.e("예외 발생:", e.getMessage());
//                    }
//                    Log.e("value:", i + "");
//                    i = i + 1;
//                    textView.setText(String.format("value:%d", i));
//                }
//            }
//        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View v) {
//                int i = 0;
//                btn1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        new Thread(){
//                            public void run(){
//                                int i = 0;
//                                while(i < 10){
//                                    try{
//                                        Thread.sleep(1000);
//                                    }catch(Exception e){
//                                        e.printStackTrace();
//                                    }
//                                    i = i+1;
//                                    Log.e("value", i+"");
//                                }
//                            }
//                        }.start();
//                        new Thread(){
//                            public void run(){
//                                int i = 0;
//                                while(i < 10){
//                                    try{
//                                        Thread.sleep(1000);
//                                    }catch(Exception e){
//                                        e.printStackTrace();
//                                    }
//                                    i = i+1;
//                                    Log.e("태그", "안녕하세요");
//                                }
//                            }
//                        }.start();
//                    }
//
//                });
//            }
            public void onClick(View v) {
                int i = 0;
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        class T implements Runnable{
                            String name;
                            int i;
                            public T(String name){
                                this.name = name;
                            }
                            public void run(){
                                for(int j=0; j<5; j=j+1){
                                    try{
//                                        Log.e(name + "변경하기 전", i+"");
//                                        i = i + 1;
//                                        Thread.sleep(1000);
//                                        Log.e(name + "변경한 후", i+"");

                                        //괄호 안의 영역은 중간에 쉬는 시간이 발생하더라도 무조건 한번에 수행합니다.
                                        synchronized (this) {
                                            Log.e(name + "변경하기 전", i + "");
                                            i = i + 1;
                                            Thread.sleep(1000);
                                            Log.e(name + "변경한 후", i + "");
                                        }
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }

                        T obj = new T("상호배제");
                        Thread th1 = new Thread(obj);
                        th1.start();
                    }

                });
            }
        });
    }
}