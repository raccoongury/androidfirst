package com.example.a0928view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edit;
    private TextView text;

    //키보드 관리 객체를 저장할 변수 선언
    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml 에 디자인 한 뷰 찾아오기
        edit = (EditText)findViewById(R.id.edit);
        text = (TextView)findViewById(R.id.text);

        //조작
        text.setText("xml에 디자인 뷰 조작하기");
        text.setTextSize(20);

        //콘솔에 출력 - 하단의 Logcat에서 확인 가능
        Log.e("태그", "내용");

        imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //edit 에 포커스 설정
        imm.showSoftInput(edit, 0);

        Button show = (Button)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.showSoftInput(edit, 0);

            }
        });


        Button hide = (Button)findViewById(R.id.hide);
        hide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                imm.hideSoftInputFromWindow(
                        edit.getWindowToken(), 0);

            }
        });

    }
}
