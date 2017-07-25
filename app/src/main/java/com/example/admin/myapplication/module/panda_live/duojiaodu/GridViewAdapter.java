package com.example.admin.myapplication.module.panda_live.duojiaodu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.bean.MultiBean;


import java.util.List;

/**
 * Created by ${马志武} on 2017/7/20.
 */

public class GridViewAdapter extends BaseAdapter{
    private Context context;
    private List<MultiBean.ListBean> list;
    public GridViewAdapter(Context context, List<MultiBean.ListBean> list) {
        this.context=context;
        this.list=list;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.gridholder,null);
            vh.iv= (ImageView) convertView.findViewById(R.id.iv_grid);
            vh.tv= (TextView) convertView.findViewById(R.id.tv_grid);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImage())
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(vh.iv);
        vh.tv.setText(list.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
