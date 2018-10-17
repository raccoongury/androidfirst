package com.example.a1017thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        class T extends Thread{
                            public void run(){
                                int i=0;
                                while(i<10){
                                    try{
                                        Thread.sleep(1000);
                                        textView.setText(i + "");
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                    i = i + 1;
                                }
                            }
                        }
                        new T().start();
                    }
                });
            }
        });
    }
}
