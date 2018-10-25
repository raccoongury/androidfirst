package com.example.a1025service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyStartService extends Service {
    public MyStartService() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("StartService", "시작");
    }

    //Create 다음에 호출되는 메소드입니다.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        for(int i=0; i<30; i=i+1){
            try{
                Thread.sleep(1000);
                Log.e("StartService", i+"");
            }catch(Exception e){}
        }
        //스타트 서비스 종료
        stopSelf();
        //종료된 후 바로 다시 시작할 수 있도록 생성
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("StartService", "종료");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("StartService", "bind 호출");

        return null;
    }
}