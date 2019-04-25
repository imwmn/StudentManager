package com.wmn.studentmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wmn.utils.DBManger;

public class MainActivity extends AppCompatActivity {

    private Button btn_add,btn_findAll,btn_clear,btn_findName,btn_delete,btn_update;
    private DBManger dbManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });
        btn_findAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindAllActivity.class);
                startActivity(intent);
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbManger = new DBManger(MainActivity.this);
                dbManger.clearData();
                Toast.makeText(MainActivity.this,"清除数据成功！",Toast.LENGTH_LONG).show();
            }
        });
        btn_findName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchForNameActivity.class);
                startActivity(intent);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindAllActivity.class);
                startActivity(intent);
            }
        });


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FindAllActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init(){
        btn_add=(Button) findViewById(R.id.add);
        btn_findAll = (Button) findViewById(R.id.all);
        btn_clear= (Button) findViewById(R.id.clear);
        btn_findName = (Button) findViewById(R.id.search);
        btn_delete = (Button) findViewById(R.id.delete );
        btn_update = (Button) findViewById(R.id.update);
    }
}
