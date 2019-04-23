package com.wmn.pojo;

/**
 * Created by 89243 on 2019/4/23.
 */
public class Student {
    private  String name; //姓名
    private  int age; //年龄
    private  String tel; //电话
    private String stuID; //学号
    private String sex;

    public Student() {
    }

    public Student(String name, int age, String tel, String stuID, String sex) {
        this.name = name;
        this.age = age;
        this.tel = tel;
        this.stuID = stuID;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stiID) {
        this.stuID = stiID;
    }

}
