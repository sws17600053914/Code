package com.example.admin.myapplication.module.home.jiecao;

import android.content.Intent;
import android.net.Uri;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.home.mybean.China_bean;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


/**
 * Created by 李旭斌 on 2017/7/21.
 */

public class China_Viod extends BaseActivity {
    String position;
    @Override
    protected void initView() {
        Intent intent = getIntent();
        position = intent.getStringExtra("position4");
        HttpUtils.getInstance().get(position, null, new MyCallBack<China_bean>() {
            @Override
            public void onSuccess(China_bean china_bean) {

                String s = china_bean.getFlv_url().getFlv2();
                VideoView videoview_top = (VideoView) findViewById(R.id.videocontroller1);
                videoview_top.setVideoURI(Uri.parse(s));
                MediaController controller = new MediaController(China_Viod.this);
                videoview_top.setMediaController(controller);
                videoview_top.requestFocus();
                videoview_top.start();   //开始播放
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.jiecaovido;
    }
}
