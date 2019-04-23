package com.wmn.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
   //数据库的辅助类
public class DBHelp extends SQLiteOpenHelper {
    public static final String DB_NAME="student.db"; //数据库名
       private static final int DB_VERSION=1;
       public static final String DB_TABLE="student_info";  //表名
       //构造方法，创建了数据库
    public DBHelp(Context context)
    {super(context,DB_NAME,null,DB_VERSION);}


    @Override //第一次运行时会被运行
    public void onCreate(SQLiteDatabase db) {
        //创建表
        db.execSQL("create table if not exists student_info "+
       "(id INTEGER AUTOINCREMENT,name VARCHAR," +
                "age INTEGER,tel VARCHAR,sex VARCHAR,stuID VARCHAR  PRIMARY KEY)");

        //创建用户表表名usertable
//        db.execSQL("CREATE TABLE IF NOT EXISTS usertable " +
//                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR, password VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

   }


    public void insertuser(String username,String password) //插入用户方法
       {
           SQLiteDatabase db = this.getWritableDatabase();
           String insertsql = "insert into usertable values(null, '" + username +
                   "', '" + password+ "')"; //插入数据库
           db.execSQL(insertsql);
       }
}
