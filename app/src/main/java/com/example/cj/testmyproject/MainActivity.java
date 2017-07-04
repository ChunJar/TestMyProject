package com.example.cj.testmyproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.cj.testmyproject.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            list.add("数据" + (i + 1));
        }
        adapter = new MyAdapter(list,this);
        lv.setAdapter(adapter);
    }

    //实现自己的适配器
//    class MyAdapter extends BaseAdapter {
//        //计算需要适配的item的总数
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        //获取每个item对象
//        @Override
//        public String getItem(int position) {
//            return list.get(position);
//        }
//
//        //获取每个item的ID
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        //获取每个item对应的view视图
//        //converView:系统复用的视图
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            Holder holder;
//            if (convertView == null) {
//                //系统第一次运行
//                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.my_adapter_item, null);
//                holder = new Holder();
//                holder.tv = (TextView) convertView.findViewById(R.id.myAdapter_tv);
//                //打标签
//                convertView.setTag(holder);
//                Log.i("TAG", "创建" + convertView);
//            } else {
//                //进行复用
//                holder = (Holder) convertView.getTag();
//                Log.i("TAG", "复用" + convertView);
//            }
//            //赋值
//            holder.tv.setText(list.get(position));

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
//            return convertView;
//        }
//    }

//    class Holder {
//        TextView tv;
//    }
}
