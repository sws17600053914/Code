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
import com.example.admin.myapplication.model.bean.RollRollVideoBean;

import java.util.ArrayList;


/**
 * 生命不息，奋斗不止，万事起于细微，量变引起质变
 * Created by 因天鹏 on 2017/7/19.
 */

public class RollAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    private Context context;
    private ArrayList<RollRollVideoBean.ListBean> mList;
    public setOnClick onClick;

    public RollAdapter(Context context, ArrayList<RollRollVideoBean.ListBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.roll_item, null);
        FirstHolder firstHolder = new FirstHolder(view);
        view.setOnClickListener(this);
        return firstHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FirstHolder firstHolder = (FirstHolder) holder;
        firstHolder.itemView.setTag(position);
        Glide.with(context).load(mList.get(position).getImage()).into(firstHolder.imageView);
        firstHolder.content.setText(mList.get(position).getBrief());
        firstHolder.title.setText(mList.get(position).getTitle());
        firstHolder.shijian.setText(mList.get(position).getVideoLength());
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
        private TextView title, content, shijian;

        public FirstHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.roll_item_title);
            content = (TextView) itemView.findViewById(R.id.roll_item_content);
            shijian = (TextView) itemView.findViewById(R.id.roll_item_shijian);
            imageView = (ImageView) itemView.findViewById(R.id.roll_item_image);
        }
    }

    public interface setOnClick {
        public void setClick(int position);
    }

    public void setOnClick(setOnClick onClick) {
        this.onClick = onClick;
    }
}
