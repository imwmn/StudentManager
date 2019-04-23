package com.wmn.studentmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wmn.pojo.Student;

/**
 * Created by 89243 on 2019/4/23.
 */
public class AddStudentActivity  extends Activity{
    private EditText et_name,et_tel,et_stuID,stu_age;
    private RadioButton radioButton_F,radioButton_M;
    private RadioGroup radioGroup;
    private String name,sex,stuID,tel,stuAge;
    private Button btn_add,btn_cancel;
    private Student student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudentlayout);
        init();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInfo();
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

    public  void getInfo(){
         name = String.valueOf(et_name.getText());
        tel = String.valueOf(et_tel.getText());
        stuID = String.valueOf(et_stuID.getText());
        stuAge = String.valueOf(stu_age.getText());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id= radioGroup.getCheckedRadioButtonId();
                switch (id){
                    case R.id.stu_rb1:
                        sex = String.valueOf(radioButton_M.getText());
                        break;
                    case R.id.stu_rb2:
                        sex = String.valueOf(radioButton_F.getText());
                        break;

                }
            }
        });

        student =new Student(name,Integer.parseInt(stuAge),tel,stuID,sex);




    }
}
