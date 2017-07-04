package com.example.cj.testmyproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cj.testmyproject.R;

import java.util.List;

/**
 * Created by CJ on 2017/7/3.
 */

public class MyAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;

    public MyAdapter(List<String> list, Context context) {
        super();
        this.list = list;
        this.context = context;
    }


    //计算需要适配的item的总数
    @Override
    public int getCount() {
        return list.size();
    }

    //获取每个item对象
    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    //获取每个item的ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    //获取每个item对应的view视图
    //converView:系统复用的视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            //系统第一次运行
            convertView = LayoutInflater.from(context).inflate(R.layout.my_adapter_item, null);
            holder = new Holder();
            holder.tv = (TextView) convertView.findViewById(R.id.myAdapter_tv);
            //打标签
            convertView.setTag(holder);
            Log.i("TAG", "创建" + convertView);
        } else {
            //进行复用
            holder = (Holder) convertView.getTag();
            Log.i("TAG", "复用" + convertView);
        }
        //赋值
        holder.tv.setText(list.get(position));

//            Log.i("TAG", "getView方法被调用" + position);
//            //获取布局映射器对象
//            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
//            //将定义好的xml文件转化为view对象
//            View view = inflater.inflate(R.layout.my_adapter_item, null);
//            //给view对象中的控件进行赋值
//            TextView tv = (TextView) view.findViewById(R.id.myAdapter_tv);
//            //赋值
//            tv.setText(getItem(position));
//            return view;
        return convertView;
    }

    class Holder {
        TextView tv;
    }
}
