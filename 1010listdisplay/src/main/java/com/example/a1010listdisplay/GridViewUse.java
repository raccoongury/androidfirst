package com.example.a1010listdisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_use);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter adapter = new ImageAdapter(this);
        gridView.setAdapter(adapter);
    }
}
