package com.example.admin.myapplication.module.home.jiecao;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.module.home.mybean.Lunbo_bean;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 李旭斌 on 2017/7/21.
 */

public class Lunbo_Viod extends Activity{
    String position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiecaovido);
        Intent intent = getIntent();
         position = intent.getStringExtra("position");

        HttpUtils.getInstance().get(position, null, new MyCallBack<Lunbo_bean>() {
            @Override
            public void onSuccess(Lunbo_bean lunbo_bean) {

                String s =lunbo_bean.getVideo().getChapters().get(0).getUrl();
                VideoView videoview_top = (VideoView) findViewById(R.id.videocontroller1);
                videoview_top.setVideoURI(Uri.parse(s));
                MediaController controller = new MediaController(Lunbo_Viod.this);
                videoview_top.setMediaController(controller);
                videoview_top.setMediaController(controller);
                videoview_top.requestFocus();
                videoview_top.start();   //开始播放
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
