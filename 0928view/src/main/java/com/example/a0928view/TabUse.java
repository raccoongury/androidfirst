package com.example.a0928view;

import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class TabUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_use1);

        //전체 탭을 관리하기 위한 객체를 찾아오기
        TabHost host = (TabHost) findViewById(R.id.host);
        //탭 설정을 위한 메소드를 호출
        host.setup();

        //탭을 생성
        TabHost.TabSpec spec = host.newTabSpec("tab1");
        //탭의 아이콘 설정
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(
                        getResources(), R.drawable.monitor,
                        null));
        //탭의 내용을 설정
        spec.setContent(R.id.tab_content1);
        //탭을 추가
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(),
                        R.drawable.heart, null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec = host.newTabSpec("tab3");
        spec.setIndicator(null,
                ResourcesCompat.getDrawable(getResources(), R.drawable.man, null));

        spec.setContent(R.id.tab_content2);
        host.addTab(spec);
    }
}
