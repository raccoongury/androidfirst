package com.example.a1010listdisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ComboBox extends AppCompatActivity {
    //spinner는 맨 처음 화면에 출력될 때 아이템을 선택하는 메소드를 호출
    //처음 이 메소드가 호출될 때는 아무 일도 하지 않도록 하기 위해서 필요한 변수
    boolean init = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_box);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //Spinner에 출력할 데이터 어댑터 생성
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.team, android.R.layout.simple_spinner_item);
        //Spinner 모양 선택
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //Spinner에 데이터 출력
        spinner.setAdapter(adapter);

        //스피너에서 선택이 변경된 경우 처리
        spinner.setOnItemSelectedListener(
                new Spinner.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //처음 호출될 때는 아무런 처리도 하지 않고 리턴
                        if(init == false){
                            init = true;
                            return;
                        }
                        String []  team =
                                getResources().getStringArray(R.array.team);
                        Toast.makeText(ComboBox.this,
                                team[position] + "을 선택",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );

    }
}
