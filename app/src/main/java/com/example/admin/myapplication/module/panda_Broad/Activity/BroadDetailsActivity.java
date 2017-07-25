package com.example.admin.myapplication.module.panda_Broad.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.module.user.User;
import com.example.admin.myapplication.module.user.UserDao;
import com.roger.catloadinglibrary.CatLoadingView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.Timer;
import java.util.TimerTask;


public class BroadDetailsActivity extends AppCompatActivity {

    private ProgressDialog dialog;

    private WebView webView;
    private boolean state = true;
    private ImageView image_broaddetails_shouchang,image_broaddetails_fenxiang;
    private PopupWindow popupWindow;
    private View inflate;
    private View inflate2;
    private TextView textview_broad_details;
    private String title = "没有数据";
    private String time = "没有数据";
    private String url = "没有数据";
    private String position,image = "没有数据";
    UMShareListener shareListener;
    private LinearLayout linearlayout_qq;
    private UMShareListener umShareListener;
    private CatLoadingView catLoadingView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_details);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        time = intent.getStringExtra("time");
        position = intent.getStringExtra("position");
        image = intent.getStringExtra("image");

        initView();
        initWebView_down();
    }

    private void initView() {

        webView = (WebView) findViewById(R.id.webview_broad_details);
        textview_broad_details = (TextView) findViewById(R.id.textview_broad_details);
        image_broaddetails_shouchang = (ImageView) findViewById(R.id.image_broaddetails_shouchang);
         image_broaddetails_fenxiang = (ImageView) findViewById(R.id.image_broaddetails_fenxiang);
        inflate = LayoutInflater.from(BroadDetailsActivity.this).inflate(R.layout.popupwindow_broaddetails, null);
        linearlayout_qq = (LinearLayout) inflate.findViewById(R.id.linearlayout_QQ);
        inflate2 = LayoutInflater.from(BroadDetailsActivity.this).inflate(R.layout.activity_broad_details, null);
        TextView tv_quxiao = (TextView) inflate.findViewById(R.id.tv_popupwindow_quxiao);
        LinearLayout popup_weibo = (LinearLayout) inflate.findViewById(R.id.popup_weibo);
        tv_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
        popup_weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShareAction(BroadDetailsActivity.this)
                        .setPlatform(SHARE_MEDIA.SINA)//传入平台
                        .withText("hello")//分享内容
                        .setCallback(shareListener)//回调监听器
                        .share();new ShareAction(BroadDetailsActivity.this)
                        .setPlatform(SHARE_MEDIA.SINA)//传入平台
                        .withText("hello")//分享内容
                        .setCallback(shareListener)//回调监听器
                        .share();
            }
        });
        //QQ的监听
        linearlayout_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UMImage image = new UMImage(BroadDetailsActivity.this, R.mipmap.ic_launcher);//资源文件
                UMImage thumb =  new UMImage(BroadDetailsActivity.this,R.mipmap.ic_launcher);
                image.setThumb(thumb);
                new ShareAction(BroadDetailsActivity.this).setPlatform(SHARE_MEDIA.QQ)
                        .withMedia(image)
                        .setCallback(umShareListener)
                        .share();
            }
        });
        //分享开始的回调
        umShareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA platform) {
                //分享开始的回调
            }
            @Override
            public void onResult(SHARE_MEDIA platform) {


                Toast.makeText(BroadDetailsActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                Toast.makeText(BroadDetailsActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                if(t!=null){

                }
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(BroadDetailsActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
            }
        };
        initListener();
    }

    private void initListener() {

        //收藏的监听
        image_broaddetails_shouchang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (state){

                    image_broaddetails_shouchang.setImageResource(R.drawable.collect_yes);

                    UserDao userDao = MyApp.getUserDao();

                    User user = new User(null,image,title,time);

                    userDao.insert(user);

                    state = false;

                }else {
                    image_broaddetails_shouchang.setImageResource(R.drawable.collect_no);

                    state = true;
                }
            }
        });
        //分享的监听
        image_broaddetails_fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                popupWindow.showAtLocation(inflate2, Gravity.BOTTOM,0,0);

            }
        });

        //分享开始的回调，可以用来处理等待框，或相关的文字提示
        shareListener = new UMShareListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
            }
            @Override
            public void onResult(SHARE_MEDIA share_media) {
            }
            @Override
            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                Toast.makeText(BroadDetailsActivity.this, "您的手机上没有该应用", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancel(SHARE_MEDIA share_media) {

            }
        };
    }

    protected void initWebView_down() {

        if (url.equals("null")){
            webView.setVisibility(View.GONE);
            textview_broad_details.setText("URL为空 ，么有地址");
            textview_broad_details.setVisibility(View.VISIBLE);
        }else {
            webView.setVisibility(View.VISIBLE);
            textview_broad_details.setVisibility(View.GONE);

            catLoadingView = new CatLoadingView();

            catLoadingView.show(getSupportFragmentManager(), "deserve");

            WebSettings webSettings= webView.getSettings();
            webSettings.setSupportZoom(true);
            webSettings.setDisplayZoomControls(true);
            webSettings.setUseWideViewPort(true);
            webSettings.setLoadWithOverviewMode(true);
            //表示编码格式
            webSettings.setDefaultTextEncodingName("utf-8");
            //true表示JavaScript可以被调用，flase表示不可以被调用
            // webSettings.setJavaScriptEnabled(true);
            //支持javascript
            webView.getSettings().setJavaScriptEnabled(true);
            // 设置可以支持缩放
            webView.getSettings().setSupportZoom(true);
            // 设置出现缩放工具
            webView.getSettings().setBuiltInZoomControls(true);
            //扩大比例的缩放
            webView.getSettings().setUseWideViewPort(true);
            //自适应屏幕
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.loadUrl(url);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            catLoadingView.dismiss();
                        }
                    });
                }
            },2500);
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialog != null){

            catLoadingView.onDestroy();
        }
    }


}
