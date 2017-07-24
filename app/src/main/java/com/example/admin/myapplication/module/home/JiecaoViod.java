package com.example.admin.myapplication.module.home;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.module.home.mybean.Bobao_bean;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


/**
 * Created by C on 2017/7/20.
 */

public class JiecaoViod extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiecaovido);



        HttpUtils.getInstance().get(Home_Url.BOBAOOUT, null, new MyCallBack<Bobao_bean>() {
            @Override
            public void onSuccess(Bobao_bean bobao_bean) {

                String s =bobao_bean.getVideo().getChapters().get(0).getUrl();
                VideoView videoview_top = (VideoView) findViewById(R.id.videocontroller1);
                videoview_top.setVideoURI(Uri.parse(s));
                MediaController controller = new MediaController(JiecaoViod.this);
                videoview_top.setMediaController(controller);
                videoview_top.setMediaController(controller);
                videoview_top.requestFocus();
                videoview_top.start();   //开始播放
            }

            @Override
            public void onFaile(String msg) {
                Toast.makeText(JiecaoViod.this, "加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
