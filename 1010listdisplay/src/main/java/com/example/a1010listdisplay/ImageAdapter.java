package com.example.a1010listdisplay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;

    public ImageAdapter(Context context){
        this.context = context;
    }
    //출력할 이미지 배열
    int [] picture = {R.drawable.star, R.drawable.trash, R.drawable.trend, R.drawable.world};

    @Override
    //출력할 항목의 개수를 설정하는 메소드
    public int getCount() {
        return 102;
    }

    @Override
    //항목의 이름을 설정하는 메소드
    public Object getItem(int position) {
        return picture[position % picture.length];
    }

    @Override
    //항목 뷰의 id를 설정하는 메소드
    public long getItemId(int position) {
        return position;
    }

    @Override
    //실제 출력할 뷰를 만들어서 리턴하는 메소드
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        //재사용할 뷰가 없다면 뷰 만들기
        if(convertView == null){
            imageView = new ImageView(context);
            //크기를 100 * 100로 생성
            imageView.setLayoutParams(
                    new GridView.LayoutParams(100,100));
            //이미지 출력 옵션 설정
            //종횡비를 맞추지 않음
            imageView.setAdjustViewBounds(false);
            //그림이 크면 가운데를 기준으로 해서 자름
            imageView.setScaleType(
                    ImageView.ScaleType.CENTER_CROP);
        }else{
            imageView = (ImageView)convertView;
        }

        imageView.setImageResource(picture[position%picture.length]);
        return imageView;
    }
}
