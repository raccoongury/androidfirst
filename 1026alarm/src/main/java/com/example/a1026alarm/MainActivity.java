package com.example.a1026alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //알람 매니저 생성
        AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        //알람이 수행할 일을 작성
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(this,0,intent,0);
        //알람을 수행할 시간
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 20);
        //알람 등록
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);
    }
}
