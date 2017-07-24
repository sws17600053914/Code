package com.example.admin.myapplication.module.home.jiecao;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.home.mybean.Bobao_bean;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by 李旭斌 on 2017/7/21.
 */

public class GunGun_Viod extends BaseActivity {
    String position;
    @Override
    protected void initView() {
        Intent intent = getIntent();
        position = intent.getStringExtra("position3");
        HttpUtils.getInstance().get(position, null, new MyCallBack<Bobao_bean>() {
            @Override
            public void onSuccess(Bobao_bean bobao_bean) {

                String s =bobao_bean.getVideo().getChapters().get(0).getUrl();
                VideoView videoview_top = (VideoView) findViewById(R.id.videocontroller1);
                videoview_top.setVideoURI(Uri.parse(s));
                MediaController controller = new MediaController(GunGun_Viod.this);
                videoview_top.setMediaController(controller);
                videoview_top.setMediaController(controller);
                videoview_top.requestFocus();
                videoview_top.start();   //开始播放
            }

            @Override
            public void onFaile(String msg) {
                Toast.makeText(GunGun_Viod.this, "加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.jiecaovido;
    }
}
