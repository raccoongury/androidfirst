package com.example.a1015activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class SubActivity extends AppCompatActivity {

    TextView subLabel;
    Button moveMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        subLabel = (TextView)findViewById(R.id.subLabel);
        moveMain = (Button)findViewById(R.id.moveMain);

        //메인에서 전달해 준 데이터 읽기
        Intent intent = getIntent();
        //String data = intent.getStringExtra("data");
        HashMap<String, Object> map = (HashMap<String, Object>)
        intent.getSerializableExtra("data");
        //subLabel.setText(data);
        subLabel.setText(map.toString());

        moveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("subdata", "하위 Activity에서 넘겨주는 데이터:");
                //응답 코드 생성 한 후 데이터 전달
                setResult(100, intent);

                finish();
            }
        });
        Log.e("SubActivity", "Sub의 onCreate 호출");
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e("SubActivity", "Sub의 onResume 호출");
    }
}
