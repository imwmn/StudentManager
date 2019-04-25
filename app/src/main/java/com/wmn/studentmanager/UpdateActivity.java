package com.wmn.studentmanager;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wmn.pojo.Student;
import com.wmn.utils.DBManger;

public class UpdateActivity extends Activity {
    private EditText et_name,et_tel,et_stuID,stu_age;
    private RadioButton radioButton_F,radioButton_M;
    private RadioGroup radioGroup;
    private String name,sex,stuID,tel,stuAge;
    private Button btn_add,btn_cancel;

    private DBManger dbManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent=getIntent();
        // 实例化一个Bundle
        Bundle bundle=intent.getExtras();
        //获取里面的student_info里面的数据
        Student student= (Student) bundle.getSerializable("student_info");
        init();
        et_name .setText(student.getName());
        stu_age.setText(student.getAge()+"");
        et_tel.setText(student.getTel());
        et_stuID.setText(student.getStuID());
        //设置不可编辑，只有电话可以编辑
        et_name.setFocusable(false);
        stu_age.setFocusable(false);
        et_stuID.setFocusable(false);
        radioButton_F.setClickable(false);
        radioButton_M.setClickable(false);
        if(student.getSex().equals("男")){
            radioButton_M.setChecked(true);
            radioButton_F.setChecked(false);
        }else{
            radioButton_F.setChecked(true);
            radioButton_M.setChecked(false);

        }

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getInfo()){
                    Toast.makeText(UpdateActivity.this,"修改电话成功",Toast.LENGTH_LONG).show();
                    new Thread(){
                        @Override
                        public void run() {
                            try {
                                sleep(2000);
                                Intent intent = new Intent(UpdateActivity.this, FindAllActivity.class);
                                startActivity(intent);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }else{
                    Toast.makeText(UpdateActivity.this,"修改学生失败，请重新修改",Toast.LENGTH_LONG).show();

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
            dbManger.updateData("tel",et_tel.getText().toString(),et_stuID.getText().toString());
           // dbManger.add(name,Integer.parseInt(stuAge),tel,stuID,sex);
            return  true;

        }else{

            return false ;
        }




    }
}
