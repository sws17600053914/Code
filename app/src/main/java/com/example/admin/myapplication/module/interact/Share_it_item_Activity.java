package com.example.admin.myapplication.module.interact;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;

import java.lang.reflect.Method;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Share_it_item_Activity extends BaseActivity {


    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_share_it_item;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        final WebView webView = (WebView) findViewById(R.id.webview);
        TextView titleItem = (TextView) findViewById(R.id.title_item);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        titleItem.setText(title);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setBlockNetworkImage(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.getSettings().setLoadsImagesAutomatically(true);
        try
        {
            //禁用硬件加速
            Method method = WebView.class.getMethod("setLayerType", int.class, Paint.class);
            method.setAccessible(true);
            method.invoke(webView, 1, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                webView.getSettings().setBlockNetworkImage(false);
            }
        }, 1000);

        webView.loadUrl(url);

    }

    @OnClick({R.id.back, R.id.share_it})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.share_it:
                break;
        }
    }

}
