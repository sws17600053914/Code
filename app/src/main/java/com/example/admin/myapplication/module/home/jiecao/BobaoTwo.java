package com.example.admin.myapplication.module.home.jiecao;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.module.home.Home_Url;
import com.example.admin.myapplication.module.home.mybean.BoBaoTwo_bean;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;


/**
 * Created by C on 2017/7/21.
 */

public class BobaoTwo extends Activity {
    ImageView back;
    WebView webview;
    private ProgressDialog mprogressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bobaotwo);
        back = (ImageView) findViewById(R.id.back);
        webview = (WebView) findViewById(R.id.webview);
        mprogressDialog = new ProgressDialog(this);
        mprogressDialog.setMessage("正在加载...");
        mprogressDialog.show();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //适应屏幕
        LinearLayout.LayoutParams mWebViewLP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
        webview.setLayoutParams(mWebViewLP);
        webview.setInitialScale(25);
        WebSettings settings = webview.getSettings();
        //适应屏幕
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        //webview支持双手缩放功能
        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setBuiltInZoomControls(true);
        HttpUtils.getInstance().get(Home_Url.BOBAOWEBVIEW, null, new MyCallBack<BoBaoTwo_bean>() {
            @Override
            public void onSuccess(BoBaoTwo_bean boBaoTwo_bean) {
                webview.loadUrl(boBaoTwo_bean.getUrl());
                mprogressDialog.dismiss();
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
