package com.example.admin.myapplication.module.RollRoll_video.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.bean.RollDataBean;

import java.util.ArrayList;


/**
 * 生命不息，奋斗不止，万事起于细微，量变引起质变
 * Created by 因天鹏 on 2017/7/19.
 */

public class Roll2Adapter extends RecyclerView.Adapter implements View.OnClickListener {
    private Context context;
    private ArrayList<RollDataBean.VideoBean> mList;
    public setOnClick onClick;

    public Roll2Adapter(Context context, ArrayList<RollDataBean.VideoBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.roll_item2, null);
        FirstHolder firstHolder = new FirstHolder(view);
        view.setOnClickListener(this);
        return firstHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FirstHolder firstHolder = (FirstHolder) holder;
        firstHolder.itemView.setTag(position);
        Glide.with(context).load(mList.get(position).getImg()).into(firstHolder.imageView);
        firstHolder.title.setText(mList.get(position).getT());
        firstHolder.shijian.setText(mList.get(position).getLen());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public void onClick(View v) {
        int posotion = (int) v.getTag();
        onClick.setClick(posotion);
    }

    class FirstHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title, shijian;

        public FirstHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.roll_item2_title);
            shijian = (TextView) itemView.findViewById(R.id.roll_item2_shijian);
            imageView = (ImageView) itemView.findViewById(R.id.roll_item2_image);
        }
    }

    public interface setOnClick {
        public void setClick(int position);
    }

    public void setOnClick(setOnClick onClick) {
        this.onClick = onClick;
    }
}
