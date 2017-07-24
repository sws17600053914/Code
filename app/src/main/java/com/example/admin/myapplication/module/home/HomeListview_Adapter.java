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
import com.example.admin.myapplication.module.home.mybean.GunGun_bean;

import java.util.ArrayList;


/**
 * Created by C on 2017/7/19.
 */

public class HomeListview_Adapter extends BaseAdapter{

    Context context;
    ArrayList<GunGun_bean.ListBean> list;
    public HomeListview_Adapter(Context context, ArrayList<GunGun_bean.ListBean> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.gungun_item,null);
            holder.img = (ImageView) convertView.findViewById(R.id.gungun_item_img);
            holder.text = (TextView) convertView.findViewById(R.id.gungun_item_text1);
            holder.shijian = (TextView) convertView.findViewById(R.id.gun_item_shijian);
            holder.shijian2 = (TextView) convertView.findViewById(R.id.gun_shijian);

            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

            Glide.with(context).load(list.get(position).getImage()).into(holder.img);
            holder.text.setText(list.get(position).getTitle());
            holder.shijian2.setText(list.get(position).getVideoLength());
            holder.shijian.setText(list.get(position).getDaytime());

        if(list.get(position).getTitle().equals("")){
            holder.text.setText("推荐下载");
        }
        Log.e("TAG","asdssasdsgdggsgds"+list.get(position).getTitle().toString());
        return convertView;
    }
    class Holder{
        ImageView img;
        TextView text;
        TextView shijian;
        TextView shijian2;
    }
}
