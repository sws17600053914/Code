package com.example.admin.myapplication.userAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.module.user.User;

import java.util.List;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public class UserAdapter extends BaseAdapter {

    private  List<User> list;
    private  Context context;

    public UserAdapter(Context context, List<User> list) {
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

        ViewHolder holder;

        if (convertView == null){

            holder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.user_adapter,null);

            holder.imageView = (ImageView) convertView.findViewById(R.id.user_adapter_image);

            holder.tv_title = (TextView) convertView.findViewById(R.id.user_adapter_tv_title);

            holder.tv_time = (TextView) convertView.findViewById(R.id.user_adapter_tv_time);

            convertView.setTag(holder);
        }else {

            holder = (ViewHolder) convertView.getTag();

        }

        Glide.with(context).load(list.get(position).getImage_url()).into(holder.imageView);

        holder.tv_title.setText(list.get(position).getTv_title());

        holder.tv_time.setText(list.get(position).getTv_time());

        return convertView;
    }

    class ViewHolder{

        ImageView imageView;

        TextView tv_title;

        TextView tv_time;
    }
}
