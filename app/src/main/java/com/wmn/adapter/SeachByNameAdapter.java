package com.wmn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wmn.pojo.Student;
import com.wmn.studentmanager.R;

import java.util.ArrayList;

/**
 * Created by 89243 on 2019/4/24.
 */
public class SeachByNameAdapter extends BaseAdapter{

    private ArrayList<Student> mList;
    private Context mContext;
    public SeachByNameAdapter(ArrayList<Student> mList, Context mContext){
        this.mList=mList;
        this.mContext=mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        //加载一个适配器界面
        view= LayoutInflater.from(mContext).inflate(R.layout.lv_item,viewGroup,false);
        //实例化元件

        TextView name=(TextView) view.findViewById(R.id.username);
        TextView age=(TextView) view.findViewById(R.id.age);
        TextView tel=(TextView) view.findViewById(R.id.tel);
        TextView stuID=(TextView) view.findViewById(R.id.stuID);
        TextView sex=(TextView) view.findViewById(R.id.stu_sex);
        //元件获取数据

        name.setText(mList.get(position).getName());
        age.setText(mList.get(position).getAge()+"");
        tel.setText(mList.get(position).getTel());
        stuID.setText(mList.get(position).getStuID());
        sex.setText(mList.get(position).getSex());
        return view;

    }
}
