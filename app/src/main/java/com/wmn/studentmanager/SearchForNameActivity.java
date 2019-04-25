package com.wmn.studentmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.wmn.adapter.SeachByNameAdapter;
import com.wmn.adapter.SearchAllAdapter;
import com.wmn.pojo.Student;
import com.wmn.utils.DBManger;

import java.util.ArrayList;

public class SearchForNameActivity extends AppCompatActivity {
    private EditText et_name;
    private Button btn_search;
    private DBManger dbManger;
    private ListView lv;
    private SeachByNameAdapter seachByNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_name);
        init();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                if(!"".equals(name)){
                    dbManger = new DBManger(SearchForNameActivity.this);
                    ArrayList<Student> searchbyname = dbManger.searchbyname(name);
                    if(searchbyname.size()==0){
                        Toast.makeText(SearchForNameActivity.this,"查询不到，数据库中未找到！",Toast.LENGTH_LONG).show();
                    }else {
                        seachByNameAdapter = new SeachByNameAdapter(searchbyname, SearchForNameActivity.this);
                        lv.setAdapter(seachByNameAdapter);
                    }
                }else {

                    Toast.makeText(SearchForNameActivity.this,"请输入姓名！",Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    private void init() {
        et_name = (EditText) findViewById(R.id.search_name);
        btn_search = (Button) findViewById(R.id.find);
        lv = (ListView) findViewById(R.id.lv_search_name);
    }
}
