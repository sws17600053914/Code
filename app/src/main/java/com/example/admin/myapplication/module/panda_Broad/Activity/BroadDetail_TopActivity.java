package com.example.admin.myapplication.module.panda_Broad.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.module.user.User;
import com.example.admin.myapplication.module.user.UserDao;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.zhy.android.percent.support.PercentLinearLayout;
import com.zhy.android.percent.support.PercentRelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class BroadDetail_TopActivity extends AppCompatActivity {

    private ImageView image_fanhui;
    private boolean state_shouchang = true;
    private TextView tv_title;
    private ImageView image_shouchang;
    private ImageView image_fenxiang;
    private ImageView image_startAndstop;
    private TextView tv_timer;
    private SeekBar progressBar_jindu;
    private TextView tv_timers;
    private Button btn_fenbianlv;
    private ImageView image_yinLiang;
    private SeekBar progressBar_yinliang;
    private PercentRelativeLayout top;
    private PercentLinearLayout down;
    private Animation top_animation_start,top_animation_end,down_animation_start,down_animation_end;
    private boolean state = true;
    private VideoView videoview_top;
    private Timer timer;
    private AudioManager am;
    private VolumeReceiver receiver;
    private String path;
    private LinearLayout linearLayout_qq;
    private UMShareListener umShareListener;
    private String title = "没有数据";
    private String time = "没有数据";
    private String image = "没有数据";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //初始化Vitamio
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_broad_details_top);

        //注册广播
        receiver = new VolumeReceiver();
        IntentFilter filter = new IntentFilter() ;
        filter.addAction("android.media.VOLUME_CHANGED_ACTION") ;
        registerReceiver(receiver, filter);

        Intent intent = getIntent();
        path = intent.getStringExtra("url_top");
        Log.e("deserve", "path:"+path);
        title = intent.getStringExtra("title");
        Log.e("deserve", "title:"+title);
        time = intent.getStringExtra("time");
        Log.e("deserve", "time:"+time);
        image = intent.getStringExtra("image");
        Log.e("deserve", "image:"+image);



        initView();
        initWebView_top();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (state){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            top.startAnimation(top_animation_start);
                            down.startAnimation(down_animation_start);
                            state = false;
                        }
                    });
                }
            }
        },4000,4000);
    }
    private void initView() {
        View inflate = LayoutInflater.from(BroadDetail_TopActivity.this).inflate(R.layout.popupwindow_broaddetails, null);
        linearLayout_qq = (LinearLayout) inflate.findViewById(R.id.linearlayout_QQ);

        linearLayout_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UMImage image = new UMImage(BroadDetail_TopActivity.this, R.mipmap.ic_launcher);//资源文件
                UMImage thumb =  new UMImage(BroadDetail_TopActivity.this,R.mipmap.ic_launcher);
                image.setThumb(thumb);
                new ShareAction(BroadDetail_TopActivity.this).setPlatform(SHARE_MEDIA.QQ)
                        .withMedia(image)
                        .setCallback(umShareListener)
                        .share();
            }
        });
        //分享开始的回调
        //分享开始的回调
        umShareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
                //分享开始的回调
            }
            @Override
            public void onResult(SHARE_MEDIA platform) {


                Toast.makeText(BroadDetail_TopActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                Toast.makeText(BroadDetail_TopActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                if(t!=null){

                }
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(BroadDetail_TopActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
            }
        };
        top = (PercentRelativeLayout) findViewById(R.id.top);
        down = (PercentLinearLayout) findViewById(R.id.down);
        image_fanhui = (ImageView) findViewById(R.id.image_fanhui);
        tv_title = (TextView) findViewById(R.id.tv_broadtop_title);
        image_shouchang = (ImageView) findViewById(R.id.image_broadtop_shouchang);
        image_fenxiang = (ImageView) findViewById(R.id.image_broadtop_fenxiang);
        image_startAndstop = (ImageView) findViewById(R.id.image_broadtop_startAndstop);
        tv_timer = (TextView) findViewById(R.id.tv_timerplayer_timer);
        progressBar_jindu = (SeekBar) findViewById(R.id.progredd_player_jindu);
        tv_timers = (TextView) findViewById(R.id.tv_player_timers);
        btn_fenbianlv = (Button) findViewById(R.id.btn_player_fenbianlv);
        image_yinLiang = (ImageView) findViewById(R.id.image_player_yinliang);
        progressBar_yinliang = (SeekBar) findViewById(R.id.progress_player_yinliang);

        top_animation_start = AnimationUtils.loadAnimation(this, R.anim.top_translate_start);
        top_animation_start.setDuration(500);
        top_animation_start.setFillAfter(true);
        top_animation_start.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                top.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        top_animation_end = AnimationUtils.loadAnimation(this, R.anim.top_translate_end);
        top_animation_end.setDuration(500);
        top_animation_end.setFillAfter(true);

        down_animation_start = AnimationUtils.loadAnimation(this, R.anim.down_translate_start);
        down_animation_start.setDuration(500);
        down_animation_start.setFillAfter(true);
        down_animation_start.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                down.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        down_animation_end = AnimationUtils.loadAnimation(this, R.anim.down_translate_end);
        down_animation_end.setDuration(500);
        down_animation_end.setFillAfter(true);
        initListener();
        progressBar_yinliang();
    }
    //通过SeekBar设置系统音量
    private void progressBar_yinliang() {

        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        //获取系统最大音量
        int maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        progressBar_yinliang.setMax(maxVolume);
        //获取当前音量
        int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        progressBar_yinliang.setProgress(currentVolume);
        //Seekbar的拖动监听
        progressBar_yinliang.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    //设置系统音量
                    am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                    int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                    seekBar.setProgress(currentVolume);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
    //继承BroadcastReceiver，创建广播用于更新UI
    private class VolumeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")){
                int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                progressBar_yinliang.setProgress(currentVolume);

                if (progressBar_yinliang.getProgress() == 0){
                    image_yinLiang.setImageResource(R.drawable.ic_volume_off_white_36dp);
                }else {
                    image_yinLiang.setImageResource(R.drawable.ic_volume_up_white_36dp);
                }
            }
        }
    }
    private void initListener() {
        //返回图标监听
        image_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //收藏图标的监听
        image_shouchang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state_shouchang){
                    UserDao userDao = MyApp.getUserDao();
                    User user = new User(null,image,title,time);
                    userDao.insert(user);
                    image_shouchang.setImageResource(R.drawable.collect_yes);
                    state_shouchang =false;
///                   Toast.makeText(BroadDetail_TopActivity.this, "已收藏，请到我的收藏查看", Toast.LENGTH_SHORT).show();
                    Toast toast =Toast.makeText(BroadDetail_TopActivity.this, "已收藏，请到我的收藏查看", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }else{
                    image_shouchang.setImageResource(R.drawable.collect_no);
                    state_shouchang =true;
                    Toast toast =Toast.makeText(BroadDetail_TopActivity.this, "已取消收藏", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
            }
        });
        //点击播放And暂停
        image_startAndstop.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoview_top.isPlaying()){
                    videoview_top.pause();
                    image_startAndstop.setImageResource(R.drawable.pla_continue);
                }else {
                    image_startAndstop.setImageResource(R.drawable.pla_pause);
                    videoview_top.start();
                }
            }
        });
        //分享监听
        image_fenxiang.setOnClickListener(new View.OnClickListener() {
            private PopupWindow popupWindow;
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(BroadDetail_TopActivity.this).inflate(R.layout.popupwindow_broaddetails, null);
                linearLayout_qq = (LinearLayout) inflate.findViewById(R.id.linearlayout_QQ);
                View inflate2 = LayoutInflater.from(BroadDetail_TopActivity.this).inflate(R.layout.activity_broad_details_top, null);
                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.showAtLocation(inflate2, Gravity.HORIZONTAL_GRAVITY_MASK,0,0);
                inflate.findViewById(R.id.image_disimiss).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (popupWindow != null){
                            popupWindow.dismiss();
                        }
                    }
                });
            }
        });
        //音量图标的监听
        image_yinLiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar_yinliang.getProgress() > 0){
                    progressBar_yinliang.setProgress(0);
                    image_yinLiang.setImageResource(R.drawable.ic_volume_off_white_36dp);
                    am.setStreamVolume(AudioManager.STREAM_MUSIC,0,0);
                }
            }
        });
    }
    protected void initWebView_top() {
        videoview_top = (VideoView) findViewById(R.id.videoview_top);
        videoview_top.setVideoURI(Uri.parse(path));
        MediaController controller = new MediaController(this);
        int currentPosition = (int) videoview_top.getCurrentPosition();
        progressBar_jindu.setMax(currentPosition);
        videoview_top.setMediaController(controller);
        Toast.makeText(this, ""+controller, Toast.LENGTH_SHORT).show();
        controller.setMediaPlayer(videoview_top);
        controller.setVisibility(View.INVISIBLE);
        videoview_top.setMediaController(controller);
        videoview_top.requestFocus();
        videoview_top.start();   //开始播放
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (state){
                    top.startAnimation(top_animation_start);
                    down.startAnimation(down_animation_start);
                    state = false;
                }else {
                    top.setVisibility(View.VISIBLE);
                    down.setVisibility(View.VISIBLE);
                    top.startAnimation(top_animation_end);
                    down.startAnimation(down_animation_end);
                    state = true;
                }
                break;
        }
        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        unregisterReceiver(receiver);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}
