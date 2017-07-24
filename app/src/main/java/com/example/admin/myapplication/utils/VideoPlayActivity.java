package com.example.admin.myapplication.utils;

import android.webkit.WebView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;

import io.vov.vitamio.widget.VideoView;

public class VideoPlayActivity extends BaseActivity {
    private WebView wv;
    private VideoView mVideoView;
    @Override
    protected void initView() {
//        if (!LibsChecker.checkVitamioLibs(this))
//            return;
//        mVideoView = (VideoView) findViewById(R.id.surface_view);
//        Intent intent = getIntent();
//        String url = intent.getStringExtra("url");
//        String title = intent.getStringExtra("title");
//        mVideoView.setVideoPath("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/07/17/3d92fae34dc14b2492de15d5dd122ac8_h264200000nero_aac16.mp4");

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_video_play;
    }
}
