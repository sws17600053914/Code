package com.example.admin.myapplication.module.panda_Broad.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private String title;
    private String time;
    private String url;
    private String position,image_url;
    UMShareListener shareListener;
    private LinearLayout linearlayout_qq;
    private UMShareListener umShareListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_details);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        time = intent.getStringExtra("time");
        position = intent.getStringExtra("position");
        image_url = intent.getStringExtra("image_url");

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

                    SharedPreferences sharedPreferences = getSharedPreferences("Deserve.db",MODE_PRIVATE);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("image_url"+position,image_url);
                    edit.putString("title"+position,title);
                    edit.putString("time"+position,time);
                    edit.apply();

                    Toast.makeText(BroadDetailsActivity.this, "image_url"+image_url+title+time, Toast.LENGTH_SHORT).show();
                    state = false;

                }else {
                    image_broaddetails_shouchang.setImageResource(R.drawable.collect_no);

                    SharedPreferences sharedPreferences = getSharedPreferences("Deserve.db",MODE_PRIVATE);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("image_url"+position,null);
                    edit.putString("title"+position,null);
                    edit.putString("time"+position,null);
                    edit.apply();
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
            dialog = new ProgressDialog(this);
            dialog.setMessage("正在加载.....");

            dialog.show();
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
                            dialog.dismiss();
                        }
                    });
                }
            },1000);
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialog != null){

            dialog.cancel();
        }
    }


}
