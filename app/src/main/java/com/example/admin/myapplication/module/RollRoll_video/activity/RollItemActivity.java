package com.example.admin.myapplication.module.RollRoll_video.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.model.bean.RollDataBean;
import com.example.admin.myapplication.module.RollRoll_video.RecyclerDivider;
import com.example.admin.myapplication.module.RollRoll_video.adapter.Roll2Adapter;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.android.percent.support.PercentRelativeLayout;

import java.util.ArrayList;

import io.vov.vitamio.widget.VideoView;


/**
 * 生命不息，奋斗不止，万事起于细微，量变引起质变
 * Created by 因天鹏 on 2017/7/19.
 */

public class RollItemActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private ImageView share;
    private CheckBox checkBox, shoucheng;
    private XRecyclerView xRecyclerView;
    private TextView textView;
    private PercentRelativeLayout layout;
    private VideoView videoView;
    private ArrayList<RollDataBean.VideoBean> mList = new ArrayList<>();
    private Roll2Adapter adapter;
    private int a = 1;
    private String id;
    private String  url;


    @Override
    protected void initView() {
        videoView = (VideoView) findViewById(R.id.rollitem_jcvideo);
        shoucheng = (CheckBox) findViewById(R.id.rollitem_shoucheng);
        textView = (TextView) findViewById(R.id.rollitem_content);
        share = (ImageView) findViewById(R.id.rollitem_share);
        xRecyclerView = (XRecyclerView) findViewById(R.id.rollitem_xrecycler);
        checkBox = (CheckBox) findViewById(R.id.rollitem_checkbox);
        layout = (PercentRelativeLayout) findViewById(R.id.rollitem_layout);
        checkBox.setOnCheckedChangeListener(this);
        share.setOnClickListener(this);
        shoucheng.setOnClickListener(this);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        url = "http://api.cntv.cn/video/videolistById?n=10&vsid=" + id + "&p=" + a + "&serviceId=panda&em=1";;
        s();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);

        xRecyclerView.setRefreshProgressStyle(ProgressStyle.SysProgress);
        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        xRecyclerView.addItemDecoration(new RecyclerDivider(this, RecyclerDivider.VERTICAL_LIST));
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        a = 1;
                        adapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                        xRecyclerView.setLoadingMoreEnabled(true);
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        a = a + 1;
                        s();
                        adapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                        xRecyclerView.setLoadingMoreEnabled(true);
                    }
                },3000);
            }
        });
        adapter = new Roll2Adapter(this, mList);
        xRecyclerView.setAdapter(adapter);
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_rollitem;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rollitem_share:
                break;
        }
    }

    private void s() {
        HttpUtils.getInstance().get(url, null, new MyCallBack<RollDataBean>() {
            @Override
            public void onSuccess(RollDataBean rollDataBean) {
                textView.setText(rollDataBean.getVideoset().get_$0().getDesc());
                mList.addAll(rollDataBean.getVideo());
                Log.e("TAG", String.valueOf(rollDataBean.getVideo()));
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
