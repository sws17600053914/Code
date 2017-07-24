package com.example.admin.myapplication.module.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.bean.HomeDataBean;

import java.util.ArrayList;

/**
 * Created by C on 2017/7/19.
 */

public class China_Adapter extends BaseAdapter{

    Context context;
    ArrayList<HomeDataBean.DataBean.ChinaliveBean.ListBeanXX> list;
    public China_Adapter(Context context, ArrayList<HomeDataBean.DataBean.ChinaliveBean.ListBeanXX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.home_gridview_item,null);
            holder.img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.text = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImage()).into(holder.img);
        holder.text.setText(list.get(position).getTitle());
        Log.e("TAG","asdssasdsgdggsgds"+list.get(position).getTitle().toString());
        return convertView;
    }
    class Holder{
        ImageView img;
        TextView text;
    }
}
