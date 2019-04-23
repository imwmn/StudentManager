package com.wmn.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wmn.pojo.Student;

import java.util.ArrayList;

public class DBManger { //数据库操作类
    private DBHelp dbHelp; //数据库辅助类
    private SQLiteDatabase db; //数据库对象
    //构造方法
    public DBManger(Context context)
    {
        dbHelp=new DBHelp(context); //创建数据库
        db=dbHelp.getWritableDatabase();
        //以可写方式打开数据库
    }


    public void add(String name,int age,String tel,String stuID,String sex)
    {
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("age",age);
        cv.put("tel",tel);
        cv.put("stuID",stuID);
        cv.put("sex",sex);
        db.insert(DBHelp.DB_TABLE,null,cv);

    }

    public void delData(String name)
    {
        String[] args={name};
        db.delete(DBHelp.DB_TABLE,"name=?",args);
    }

    public void clearData()
    {
        db.execSQL("delete from student_info");
    }
    //查询所有
    public ArrayList<Student> searchAll()
    {
        String sql="select * from student_info";
        return ExecSQLForMem(sql);

    }

    public ArrayList<Student> searchbyname(String name)
    {
        String sql="select * from student_info where name='"+name+"'";
        return ExecSQLForMem(sql);

    }

    private ArrayList<Student> ExecSQLForMem(String sql)
    {
        ArrayList<Student> list=new ArrayList<Student>();
        Cursor c=db.rawQuery(sql,null);
        //查询返回游标
        while (c.moveToNext())
        { Student member=new Student();
        member.setName(c.getString(c.getColumnIndex("name")));
        member.setAge(c.getInt(c.getColumnIndex("age")));
        member.setTel(c.getString(c.getColumnIndex("tel")));
        member.setStuID(c.getString(c.getColumnIndex("stuID")));
        member.setSex(c.getString(c.getColumnIndex("sex")));
        list.add(member);
        }
        return list;
    }

    public void updateData(String raw,String rawvalue,String wherename)
    {
        String sql="update student_info set "+raw+"='"+rawvalue+"' where name='"+wherename+"'";
         db.execSQL(sql);
    }
}
