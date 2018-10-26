package com.example.a1026service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBoundService extends Service {
    //데이터를 전송할 수 있는 Binder 클래스 생성
    class MyLocalBinder extends Binder {
        MyBoundService getService(){
            return MyBoundService.this;
        }
    }
    //Binder 객체를 생성
    IBinder myBinder = new MyLocalBinder();

    public MyBoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    //서비스를 등록한 곳에서 호출할 메소드
    public String remoteMethod(){
        return "안녕하세요 반갑습니다.";
    }
}
