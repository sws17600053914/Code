package com.example.admin.myapplication.module.panda_live.moment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.model.bean.WonderfulBean;


import java.util.List;

/**
 * Created by ${马志武} on 2017/7/19.
 */

public class MomentAdapter extends RecyclerView.Adapter<MomentAdapter.MyViewHolder> implements View.OnClickListener{
    private Context context;
    private List<WonderfulBean.VideoBean> list;
    private MyViewHolder mvh;
    private SetMyClick  setMyClick;
    public MomentAdapter(Context context, List<WonderfulBean.VideoBean> mList) {
        this.context=context;
        this.list=mList;
    }

    public void setSetMyClick(SetMyClick setMyClick) {
        this.setMyClick = setMyClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.holder_moment, null);
        view.setOnClickListener(this);
        mvh = new MyViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemView.setTag(position);

        Glide.with(context)
                .load(list.get(position).getImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.iv);
        holder.title.setText(list.get(position).getT());
        holder.time.setText(list.get(position).getPtime());
        holder.tv_videolength.setText(list.get(position).getLen());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        int pos= (int) v.getTag();
        setMyClick.myClick(pos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView title;
        private TextView time;
        private TextView tv_videolength;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv);
            title= (TextView) itemView.findViewById(R.id.tv_title);
            time= (TextView) itemView.findViewById(R.id.tv_time);
            tv_videolength= (TextView) itemView.findViewById(R.id.tv_videolength);
        }
    }
    public interface SetMyClick{
        void myClick(int pos);
    }
}
