package com.wmn.studentmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.wmn.adapter.SearchAllAdapter;
import com.wmn.pojo.Student;
import com.wmn.utils.DBManger;

import java.util.ArrayList;

public class FindAllActivity extends AppCompatActivity {

    private SearchAllAdapter searchAllAdapter;
    private ListView listView;
    private ArrayList<Student> arrayList;
    private DBManger dbManger;
    Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_all);
        listView = (ListView) findViewById(R.id.list_view);

         dbManger = new DBManger(this);
         arrayList  = dbManger.searchAll();


        searchAllAdapter = new SearchAllAdapter(arrayList,this);

        listView.setAdapter(searchAllAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Student stu = arrayList.get(i);


                 student = (Student) arrayList.get(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(FindAllActivity.this);
                builder.setTitle("操作");
                //设置正面按钮

                builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbManger = new DBManger(FindAllActivity.this);
                        dbManger.delete(student.getStuID());
                        //清空 重新装载
                        arrayList.clear();
                        arrayList = dbManger.searchAll();
                        searchAllAdapter = new SearchAllAdapter(arrayList,FindAllActivity.this);
                        listView.setAdapter(searchAllAdapter);
                        dialog.dismiss();
                    }
                });
                //设置反面按钮
                builder.setNegativeButton("更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(FindAllActivity.this,UpdateActivity.class);
                        Bundle b =new Bundle();
                        b.putSerializable("student_info",student);
                        intent.putExtras(b);
                        startActivity(intent);

                        dialog.dismiss();
                    }
                });
                builder.show();

            }
        });

    }
}
