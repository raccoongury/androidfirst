package com.example.a1017handler;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.os.Message;

public class HandlerUse extends AppCompatActivity {
    //진행율을 표시하기 위한 대화상자
    ProgressDialog progressDialog;
    //값을 나타낼 변수
    int value;

    Handler handler = new Handler(){
        public void handleMessage(Message message){
            value = value + 1;
            try{
                Thread.sleep(500);
                if(value < 100){
                    progressDialog.setProgress(value);
                    handler.sendEmptyMessage(0);
                }
                else{
                    progressDialog.dismiss();
                }
            }catch(Exception e){}
        }
    };

    public void download(){
        try{
            Thread.sleep(10000);
            Toast.makeText(this,
                    "다운로드 완료",
                    Toast.LENGTH_LONG).show();
        }catch(Exception e){}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_use);



        Button btn = (Button)findViewById(R.id.download);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(
                        HandlerUse.this)
                        .setTitle("다운로드")
                        .setMessage("다운로드하시겠습니까?")
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        value = 0;
                                        progressDialog = new ProgressDialog(
                                                HandlerUse.this);
                                        progressDialog.setMax(100);
                                        progressDialog.setProgressStyle(
                                                ProgressDialog.STYLE_HORIZONTAL);
                                        progressDialog.setTitle("다운로드");
                                        progressDialog.setMessage("기다리세요.....");
                                        //뒤로 버튼을 대화상자를 닫을 수 없게 설정
                                        progressDialog.setCancelable(false);
                                        progressDialog.show();
                                        handler.sendEmptyMessage(0);
                                    }
                                })
                        .setNegativeButton("아니오", null)
                        .show();
            }
        });


    }
}
