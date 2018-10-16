package com.example.a1016activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final TextView textView = (TextView)findViewById(R.id.txtcount);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = value + 1;
                textView.setText(value + "");
            }
        });
    }
    //엑티비티가 종료되기 직전에 호출되는 메소드
    @Override
    public void onSaveInstanceState (Bundle bundle){
        super.onSaveInstanceState(bundle);
        //데이터 저장
        bundle.putInt("value", value);
    }
    //엑티비티가 시작할 때 호출되는 메소드
    //데이터를 복원을 합니다.

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int value = bundle.getInt("value");
        this.value = value;
        TextView textView = (TextView)findViewById(R.id.txtcount);
        textView.setText(value + "");
    }
}
