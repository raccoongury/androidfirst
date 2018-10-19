package com.example.a1019urlcommunication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URL;

public class ImageDisplay extends AppCompatActivity {
    ImageView imageView;

    Handler displayHandler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            Bitmap bitmap = (Bitmap)message.obj;
            imageView.setImageBitmap(bitmap);

            Button display = (Button)findViewById(R.id.display);
            display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DiplayThread th = new DiplayThread();
                    th.start();
                }
            });
        }
    };



    class  DiplayThread extends Thread{
        @Override
        public void run() {
            try{
                String addr ="https://i.ytimg.com/vi/Cm_qva8i8Q4/maxresdefault.jpg";
                URL url = new URL(addr);
                //url에 연결해서 비트맵 만들기
                Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
                Message message = new Message();
                message.obj = bitmap;
                displayHandler.sendMessage(message);
            }catch (Exception e){
                Log.e("이미지 가져오기", e.getMessage());

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        Button display = (Button)findViewById(R.id.display);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiplayThread th = new DiplayThread();
                th.start();
            }
        });
        imageView = (ImageView)findViewById(R.id.imageview);
    }
}