package com.example.a1008databaseuse;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //layout에서 필요한 데이터 찾아오기
        Button insert = (Button)findViewById(R.id.insert);
        Button select = (Button)findViewById(R.id.select);
        Button update = (Button)findViewById(R.id.update);
        Button delete = (Button)findViewById(R.id.delete);

        final EditText name = (EditText)findViewById(R.id.name);
        final EditText price = (EditText)findViewById(R.id.price);
        final TextView id = (TextView)findViewById(R.id._id);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputname = name.getText().toString();
                String inputprice = price.getText().toString();
                //데이터베이스 연결
                DBOpenHelper dbHelper = new DBOpenHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //db.rawQuery("insert into product(name, price) " +
                //        "values(\'" + inputname + "\'," +
               //         inputprice +");", null);
                ContentValues value = new ContentValues();
                value.put("name", inputname);
                value.put("price", inputprice);
                db.insert("product", null, value);


                dbHelper.close();
                id.setText("삽입성공");
                name.setText("");
                price.setText("");


            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputname = name.getText().toString();
                if(inputname.trim().length() == 0){
                    Toast.makeText(MainActivity.this,
                            "이름을 입력하세요",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                DBOpenHelper dbOpenHelper = new DBOpenHelper(MainActivity.this);
                SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery(
                        "select * from product where name='"
                                + inputname +"';",
                        null);

                if(cursor.moveToNext()){
                    id.setText(cursor.getInt(0) + "");
                    name.setText(cursor.getString(1));
                    price.setText(cursor.getInt(2) + "");
                }else{
                    id.setText("조회된 데이터가 없습니다.");
                }

                dbOpenHelper.close();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBOpenHelper dbOpenHelper = new DBOpenHelper(MainActivity.this);
                SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
                String inputname = name.getText().toString();
                String inputprice = price.getText().toString();
                ContentValues values = new ContentValues();
                values.put("price",Integer.parseInt(inputprice));

                db.update("product", values,
                        "name='"+inputname+ "'",
                        null);
                dbOpenHelper.close();
                Toast.makeText(MainActivity.this, "수정 성공",
                        Toast.LENGTH_LONG).show();
                dbOpenHelper.close();


            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBOpenHelper dbOpenHelper = new DBOpenHelper(MainActivity.this);
                SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
                String inputname = name.getText().toString();

                db.delete("product", "name='" +
                        inputname + "'", null);
                Toast.makeText(MainActivity.this, "삭제 성공",
                        Toast.LENGTH_LONG).show();
                dbOpenHelper.close();
            }
        });
    }
}

