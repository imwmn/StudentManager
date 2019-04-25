package com.wmn.studentmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.wmn.utils.DBManger;

/**
 * Created by 89243 on 2019/4/23.
 */
public class AddStudentActivity  extends Activity{
    private EditText et_name,et_tel,et_stuID,stu_age;
    private RadioButton radioButton_F,radioButton_M;
    private RadioGroup radioGroup;
    private String name,sex,stuID,tel,stuAge;
    private Button btn_add,btn_cancel;

    private DBManger dbManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudentlayout);
        init();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(getInfo()){
                     Toast.makeText(AddStudentActivity.this,"成功添加学生",Toast.LENGTH_LONG).show();
                     new Thread(){
                         @Override
                         public void run() {
                             try {
                                 sleep(2000);
                                 Intent intent = new Intent(AddStudentActivity.this, MainActivity.class);
                                 startActivity(intent);
                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                         }
                     }.start();
                 }else{
                     Toast.makeText(AddStudentActivity.this,"添加学生失败，请重新添加",Toast.LENGTH_LONG).show();

                 }




            }
        });

    }

    public void init(){
        et_name = findViewById(R.id.stu_name);
        stu_age=findViewById(R.id.stu_age);
        et_tel = findViewById(R.id.stu_phone);
        et_stuID = findViewById(R.id.stu_id);
        radioButton_F =findViewById(R.id.stu_rb2);
        radioButton_M =findViewById(R.id.stu_rb1);
        radioGroup =findViewById(R.id.stu_rg);
        btn_add =findViewById(R.id.add_submit);
        btn_cancel= findViewById(R.id.add_cancel);
    }

    public  boolean  getInfo(){
         boolean flag = true;
         name = et_name.getText().toString();
        tel = et_tel.getText().toString();
        stuID = et_stuID.getText().toString();
        stuAge = stu_age.getText().toString();
        if(radioButton_F.isChecked()){
            sex = radioButton_F.getText().toString();
        }else {
            sex = radioButton_M.getText().toString();
        }

//       if(name == null){
//           Toast.makeText(this,"姓名不能为空，请输入！",Toast.LENGTH_LONG).show();
//           flag =false;
//
//       }else if(tel == null){
//           Toast.makeText(this,"电话不能为空，请输入！",Toast.LENGTH_LONG).show();
//           flag =false;
//       }else if(stuID == null){
//           Toast.makeText(this,"学号不能为空，请输入！",Toast.LENGTH_LONG).show();
//           flag =false;
//       }else if(stuAge == null){
//           Toast.makeText(this,"年龄不能为空，请输入！",Toast.LENGTH_LONG).show();
//           flag =false;
//       }else if(sex == null){
//           Toast.makeText(this,"性别不能为空，请输入！",Toast.LENGTH_LONG).show();
//           flag =false;
//       }

       if(flag == true){
           dbManger= new DBManger(this);
           dbManger.add(name,Integer.parseInt(stuAge),tel,stuID,sex);
           return  true;

       }else{

           return false ;
       }




    }
}
