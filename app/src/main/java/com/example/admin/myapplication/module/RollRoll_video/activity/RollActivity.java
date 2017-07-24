package com.example.admin.myapplication.module.RollRoll_video.activity;

import android.content.Intent;
import android.net.Uri;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


/**
 * 生命不息，奋斗不止，万事起于细微，量变引起质变
 * Created by 因天鹏 on 2017/7/19.
 */

public class RollActivity extends BaseActivity {
    private VideoView videoView;


    @Override
    protected void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        videoView = (VideoView) findViewById(R.id.roll_video);
        videoView.setVideoURI(Uri.parse("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/07/17/3d92fae34dc14b2492de15d5dd122ac8_h264200000nero_aac16.mp4"));
        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        controller.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();

    }

    @Override
    public int getActivityLayoutId() {
        Vitamio.isInitialized(this);
        return R.layout.activity_roll;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
