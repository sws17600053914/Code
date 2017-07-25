package com.example.admin.myapplication.utils;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.WonderfulBean;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoPlayActivity extends BaseActivity implements View.OnClickListener {
    private VideoView mVideoView;
    private PercentLinearLayout ll_up, ll_down;
    private ImageView iv_finish, iv_collect, iv_share, iv_menu, iv_pause, iv_volume;
    private TextView tv_video_title, tv_timer, tv_switch;
    private SeekBar bar_video, bar_volume;
    private boolean is = true;
    private int a = 0;
    private int b = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            int current = data.getInt("current");
            int duration = data.getInt("duration");
            bar_video.setMax(duration);
            bar_video.setProgress(current);
        }
    };
    private TranslateAnimation uplayout_out;
    private TranslateAnimation downlayout_out;
    private TranslateAnimation downlayout_in;
    private TranslateAnimation uplayout_in;
    private long start;
    private long firstClick;
    private ArrayList<String> arrlist;
    private ListView listview;
    private PopupWindow pop;
    private boolean isCollect;
    private ArrayList<WonderfulBean.VideoBean> bean;
    private ArrayList<String> urls;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int position = bundle.getInt("position");
        arrlist = bundle.getStringArrayList("arrlist");
        urls = bundle.getStringArrayList("urls");
        bean = (ArrayList<WonderfulBean.VideoBean>) bundle.getSerializable("bean");

        mVideoView = (VideoView) findViewById(R.id.surface_view);
        ll_up = (PercentLinearLayout) findViewById(R.id.ll_up);
        ll_down = (PercentLinearLayout) findViewById(R.id.ll_down);
        iv_finish = (ImageView) findViewById(R.id.iv_finish);
        iv_finish.setOnClickListener(this);
        iv_collect = (ImageView) findViewById(R.id.iv_collect);
        iv_collect.setOnClickListener(this);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        iv_share.setOnClickListener(this);
        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(this);
        iv_pause = (ImageView) findViewById(R.id.iv_pause);
        iv_pause.setOnClickListener(this);
        iv_volume = (ImageView) findViewById(R.id.iv_volume);
        iv_volume.setOnClickListener(this);
        tv_video_title = (TextView) findViewById(R.id.tv_video_title);
        tv_video_title.setText(arrlist.get(position));
        tv_timer = (TextView) findViewById(R.id.tv_timer);
        tv_switch = (TextView) findViewById(R.id.tv_switch);
        tv_switch.setOnClickListener(this);
        bar_video = (SeekBar) findViewById(R.id.bar_video);
        bar_volume = (SeekBar) findViewById(R.id.bar_volume);
        // 判断是否收藏
        isCollect = (boolean) SPutils.get(MyApp.mContext, "isCollect", false);
        if (isCollect) {
            iv_collect.setImageResource(R.drawable.play_fullsrcee_collect);
        } else {
            iv_collect.setImageResource(R.drawable.play_fullsrcee_collect_true);

        }
        initVideo(urls.get(position));
        initAnim();

        start = System.currentTimeMillis();

        initSeekListen();
    }

    private void initSeekListen() {
        Timer timer=new Timer();
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                int current = (int) mVideoView.getCurrentPosition();
                int duration = (int) mVideoView.getDuration();
                Message message = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putInt("current",current);
                bundle.putInt("duration",duration);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        };
        timer.schedule(tt,500,1000);

        bar_video.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                mVideoView.seekTo(progress);
            }
        });

        bar_volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float volume = (float) bar_volume.getProgress();
                mVideoView.setVolume(volume, volume);
            }
        });

        bar_video.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                long pro_length = (long) seekBar.getProgress();
                mVideoView.seekTo(pro_length);
            }
        });
    }

    private void initAnim() {
        // 上方布局往下平移出屏幕
        uplayout_out = new TranslateAnimation(0.0f, 0.0f, 0.0f, -80f);
        uplayout_out.setDuration(500);
        uplayout_out.setFillAfter(true);
        // 上方布局往下平进入屏幕
        uplayout_in = new TranslateAnimation(0.0f, 0.0f, -80f, 0.0f);
        uplayout_in.setDuration(500);
        uplayout_in.setFillAfter(true);
        // 下方布局往下平移出屏幕
        downlayout_out = new TranslateAnimation(0.0f, 0.0f, 0.0f, 80f);
        downlayout_out.setDuration(500);
        downlayout_out.setFillAfter(true);
        // 下方布局往上平移进入屏幕
        downlayout_in = new TranslateAnimation(0.0f, 0.0f, 80f, 0.0f);
        downlayout_in.setDuration(500);
        downlayout_in.setFillAfter(true);
    }

    private void initVideo(String urls) {
        mVideoView.setVideoURI(Uri.parse(urls));
        MediaController controller = new MediaController(this);
        mVideoView.setMediaController(controller);
        controller.setMediaPlayer(mVideoView);
        mVideoView.requestFocus();
        controller.setVisibility(View.INVISIBLE);
        mVideoView.setMediaController(controller);
        mVideoView.start();   //开始播放
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_video_play;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_finish:
                finish();
                break;

            case R.id.iv_share:

                break;

            case R.id.iv_collect:
                if (isCollect) {
                    iv_collect.setImageResource(R.drawable.play_fullsrcee_collect_true);
                    SPutils.put(MyApp.mContext, "isCollect", false);
                    Toast toast = Toast.makeText(VideoPlayActivity.this, "已添加，请到[我的收藏]中观看", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    isCollect = false;
                } else {
                    iv_collect.setImageResource(R.drawable.play_fullsrcee_collect);
                    SPutils.put(MyApp.mContext, "isCollect", true);
                    Toast toast = Toast.makeText(VideoPlayActivity.this, "已取消收藏", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    isCollect = true;
                }

                break;
            case R.id.iv_menu:
                ll_down.startAnimation(downlayout_out);
                if (b % 2 == 0) {
                    View popView = LayoutInflater.from(VideoPlayActivity.this).inflate(R.layout.poplayout, null);
                    listview = (ListView) popView.findViewById(R.id.listview);
                    pop = new PopupWindow(popView, 400, 600);
                    pop.setAnimationStyle(R.style.myanim);
                    pop.setOutsideTouchable(true);
                    pop.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
                    pop.showAsDropDown(iv_menu);
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(VideoPlayActivity.this, android.R.layout.simple_expandable_list_item_1, arrlist);
                    listview.setAdapter(arrayAdapter);
                } else {
                    pop.dismiss();
                    ll_up.startAnimation(uplayout_out);
                }
                b++;
                initListClick();
                break;
            case R.id.iv_pause:
                if (mVideoView.isPlaying()){
                    mVideoView.pause();
                }else {
                    mVideoView.start();
                }
                break;
            case R.id.iv_volume:

                break;
            case R.id.tv_switch:

                break;
        }
    }

    private void initListClick() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_video_title.setText(bean.get(position).getT());
                initVideo(urls.get(position));
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstClick = System.currentTimeMillis();
                if (is) {
                    ll_up.startAnimation(uplayout_in);
                    ll_down.startAnimation(downlayout_in);
                    is = false;
                } else {
                    ll_up.startAnimation(uplayout_out);
                    ll_down.startAnimation(downlayout_out);
                    is = true;
                }
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
