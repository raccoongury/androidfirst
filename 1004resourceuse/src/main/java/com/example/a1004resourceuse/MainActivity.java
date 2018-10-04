package com.example.a1004resourceuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //레이아웃에서 뷰 찾아오기
        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        final Button button = (Button)findViewById(R.id.animationstart);
        //버튼을 눌렀을 때 수행할 내용 작성
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //애니메이션 가져오기
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                //뷰에 애니메이션 적용
                imageView.startAnimation(animation);
            }
        });


    }
}
