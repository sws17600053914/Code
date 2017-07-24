package com.example.admin.myapplication.module.interact;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.bean.OriginalBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by Pang on 2017/7/19.
 */

public class MyXrecyclerviewAdapter extends XRecyclerView.Adapter<MyXrecyclerviewAdapter.MHolder> implements View.OnClickListener{
       private  OnItemClickListener onItemClickListener;
       public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
           this.onItemClickListener = onItemClickListener;
       }
    Context content;
    List<OriginalBean.InteractiveBean> list;
       public MyXrecyclerviewAdapter(Context content, List<OriginalBean.InteractiveBean> list) {
           this.content=content;
           this.list=list;
       }
       @Override
       public MHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View inflate = LayoutInflater.from(content).inflate(R.layout.share_listview_item,null);
           inflate.setOnClickListener(this);
           MHolder holder=new MHolder(inflate);
                   return holder;
               }
               @Override
               public void onBindViewHolder(MHolder holder, int position) {
                     holder.title.setText(list.get(position).getTitle());

                   Glide.with(content).load(list.get(position).getImage()).into(holder.item_image);
                 holder.itemView.setTag(position);
       }
       @Override
       public int getItemCount() {
           Log.e("dd",""+list.size());
           return list.size();
       }

    class MHolder extends RecyclerView.ViewHolder{
           TextView title;
           ImageView item_image;
           public MHolder(View itemView) {
               super(itemView);
               title = (TextView) itemView.findViewById(R.id.title);
               item_image= (ImageView) itemView.findViewById(R.id.item_image);
           }
       }
       public  interface OnItemClickListener{
           void OnItemclick(int pos);
       }
       @Override
       public void onClick(View v) {
           if(onItemClickListener!=null){
               Integer pos= (Integer) v.getTag();
               onItemClickListener.OnItemclick(pos);
           }
       }
   }


