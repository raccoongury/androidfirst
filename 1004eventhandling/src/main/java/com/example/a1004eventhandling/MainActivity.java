package com.example.a1004eventhandling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        String message = String.format("x:%.1f y:%f 터치", x, y);
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2개의 버튼을 찾아오는 코드
        final Button btn1 = (Button)findViewById(R.id.btn1);
        final Button btn2 = (Button)findViewById(R.id.btn2);

        //Button의 click - View.OnClickListener
 /*       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"첫번째 버튼을 클릭하셨습니다.", Toast.LENGTH_LONG).show();


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"두번째 버튼을 클릭하셨습니다.", Toast.LENGTH_LONG).show();



            }
        });
*/
        View.OnClickListener eventHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
/*                String msg = "";
                if(btn == btn1){
                    msg = "첫번째 버튼 클릭";
                }
                else if(btn == btn2){
                    msg = "두번째 버튼 클릭";

                }
*/

                String msg = btn.getText().toString();

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        };

        //이벤트 처리 객체 연결
        btn1.setOnClickListener(eventHandler);
        btn2.setOnClickListener(eventHandler);

    }
}
