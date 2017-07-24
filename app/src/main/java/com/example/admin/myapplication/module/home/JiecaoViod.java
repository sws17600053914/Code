package com.example.admin.myapplication.module.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * Created by C on 2017/7/20.
 */

public class JiecaoViod extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiecaovido);
        JCVideoPlayer.releaseAllVideos();
        JCVideoPlayer jcVideoPlayerStandard = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4","熊猫直播");
        Glide.with(this).load(R.drawable._no_img).into(jcVideoPlayerStandard.ivThumb);
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }



}
