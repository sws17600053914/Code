package com.example.admin.myapplication.module.panda_Broad;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.bean.PandaBroadBean;
import com.example.admin.myapplication.module.panda_Broad.Activity.BroadDetailsActivity;

import java.util.List;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public class AdapterXRecyclerView extends RecyclerView.Adapter<AdapterXRecyclerView.ViewHolder> implements View.OnClickListener{


    private SetOnClickListener setOnClickListener;

    private  Context context;

    private  List<PandaBroadBean.ListBean> list;

    public void setSetOnClickListener(SetOnClickListener setOnClickListener) {

        this.setOnClickListener = setOnClickListener;
    }

    public AdapterXRecyclerView(Context context, List<PandaBroadBean.ListBean> list) {

        this.context = context;

        this.list = list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_broad, null);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

        view.setLayoutParams(layoutParams);

        view.setOnClickListener(this);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_title.setText(list.get(position).getTitle());

        holder.itemView.setTag(position);

        StringBuffer stringBuffer = new StringBuffer(list.get(position).getUrl());

        StringBuffer delete = stringBuffer.delete(0, 23);

        StringBuffer stringBuffer2 = new StringBuffer(delete);

        StringBuffer delete1 = stringBuffer2.delete(10, delete.length());

        StringBuffer stringBuffer3 = new StringBuffer(delete1);

        StringBuffer replace = stringBuffer3.replace(4, 5, "-");

        StringBuffer stringBuffer4 = new StringBuffer(replace);

        StringBuffer replace1 = stringBuffer4.replace(7, 8, "-");

        holder.tv_time.setText(replace1);

        Glide.with(context).load(list.get(position).getPicurl()).into(holder.image_picture);

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_picture;

        TextView tv_title;

        TextView tv_time;

        public ViewHolder(View itemView) {
            super(itemView);

            image_picture = (ImageView) itemView.findViewById(R.id.image_adapter_picture);

            tv_title = (TextView) itemView.findViewById(R.id.tv_adapter_title);

            tv_time = (TextView) itemView.findViewById(R.id.tv_adapter_time);

        }
    }
    interface SetOnClickListener{

        void setOnClick(int position);

    }
    @Override
    public void onClick(View v) {

        Integer position = (Integer) v.getTag();

        Intent intent = new Intent(context, BroadDetailsActivity.class);

        intent.putExtra("url", list.get(position).getUrl());
        intent.putExtra("title", list.get(position).getTitle());

        StringBuffer stringBuffer = new StringBuffer(list.get(position).getUrl());
        StringBuffer delete = stringBuffer.delete(0, 23);
        StringBuffer stringBuffer2 = new StringBuffer(delete);
        StringBuffer delete1 = stringBuffer2.delete(10, delete.length());
        StringBuffer stringBuffer3 = new StringBuffer(delete1);
        StringBuffer replace = stringBuffer3.replace(4, 5, "-");
        StringBuffer stringBuffer4 = new StringBuffer(replace);
        StringBuffer replace1 = stringBuffer4.replace(7, 8, "-");
        intent.putExtra("time",replace1.toString());
        intent.putExtra("position",position+"");
        intent.putExtra("image_url",list.get(position).getPicurl());

        context.startActivity(intent);

    }
}
