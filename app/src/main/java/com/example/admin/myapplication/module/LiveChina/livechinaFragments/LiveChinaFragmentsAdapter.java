package com.example.admin.myapplication.module.LiveChina.livechinaFragments;

  import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.BaDaLingBean;
import com.example.admin.myapplication.model.bean.China_bean;
import com.example.admin.myapplication.module.panda_Broad.Activity.BroadDetail_TopActivity;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.List;


/**
 * Created by lenovo on 2017/7/19.
 */

public class LiveChinaFragmentsAdapter extends RecyclerView.Adapter<LiveChinaFragmentsAdapter.ViewHolder> {
    public List<BaDaLingBean.LiveBean> datas;
    boolean mBoolean = false;
    Context context;

    public LiveChinaFragmentsAdapter(Context context, List<BaDaLingBean.LiveBean> datas) {
        this.datas = datas;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.livechina_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {

        viewHolder.livechinaTitle.setText("[正在直播]" + datas.get(position).getTitle());
        viewHolder.livechinaContent.setText(datas.get(position).getBrief());
        Glide.with(MyApp.mBaseLastFragment.getActivity()).load(datas.get(position).getImage()).into(viewHolder.livechinaImage);

        viewHolder.livechinaPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转   直播页面
                HttpUtils.getInstance().get("http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd" + datas.get(position).getId() + "&client=androidapp", null, new MyCallBack<China_bean>() {
                    @Override
                    public void onSuccess(China_bean china_bean) {
                        Intent intent = new Intent(context, BroadDetail_TopActivity.class);
                        intent.putExtra("url_top", china_bean.getFlv_url().getFlv2());
                        MyApp.mBaseLastFragment.startActivity(intent);
                    }

                    @Override
                    public void onFaile(String msg) {

                    }
                });
            }
        });
        viewHolder.livechinaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBoolean) {
                    viewHolder.livechinaButton.setBackgroundResource(R.drawable.live_china_detail_down);
                    viewHolder.livechinaJianjie.setVisibility(View.GONE);
                    mBoolean = false;
                } else {
                    viewHolder.livechinaButton.setBackgroundResource(R.drawable.live_china_detail_up);
                    viewHolder.livechinaJianjie.setVisibility(View.VISIBLE);
                    mBoolean = true;
                }
            }
        });
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView livechinaImage,livechinaPlay;
        TextView livechinaTitle;
        TextView livechinaContent;
        PercentLinearLayout livechinaJianjie;
        Button livechinaButton;

        public ViewHolder(View view) {
            super(view);
            livechinaImage = (ImageView) view.findViewById(R.id.livechina_image);
            livechinaPlay= (ImageView) view.findViewById(R.id.livechina_play);
            livechinaTitle = (TextView) view.findViewById(R.id.livechina_title);
            livechinaContent = (TextView) view.findViewById(R.id.livechina_content);
            livechinaJianjie = (PercentLinearLayout) view.findViewById(R.id.livechina_jianjie);
            livechinaButton = (Button) view.findViewById(R.id.livechina_button);
        }
    }
}