package com.example.a1015activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView mainLabel;
    Button moveSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLabel = (TextView)findViewById(R.id.mainLabel);
        moveSub = (Button)findViewById(R.id.moveSub);

        moveSub.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //출력할 Activity의 Intent 만들기
                        //하위 Activity 인스턴스를 직접 생성하지 않습니다.
                        //Acticity를 이용해서는 데이터를 전달할 수 없습니다.
                        Intent intent = new Intent(
                                        MainActivity.this,
                                        SubActivity.class);
                        //Map<String, Object>map = new HashMap<>();
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("이름", "한글이름");
                        map.put("나이", 18);
                        //intent.putExtra("data", "메인에서 넘겨준 데이터");
                        intent.putExtra("data", map);
                        //Activity 출력
                        //startActivity(intent);
                        //하위 Activity에서 데이터를 리턴받을 수 있는
                        //메소드를 호출해서 하위 Activity 출력
                        startActivityForResult(intent, 100);

                    }
                });
        Log.e("MainActivity", "onCreate 호출");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.e("MainActivity", "onResume 호출");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 100) {
            String subdata = data.getStringExtra("subdata");
            mainLabel.setText(subdata);
        }
    }
}
