package com.example.admin.myapplication.module.interact;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.cn.sharesdk.onekeyshare1.OnekeyShare;

import java.lang.reflect.Method;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Share_it_item_Activity extends BaseActivity implements View.OnClickListener{


    private RadioButton fac;
    private RadioButton twitter;
    private RadioButton sinawebo;
    private RadioButton wechat;
    private RadioButton moments;
    private String url;
    private String title;

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
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
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
        try {
            //禁用硬件加速
            Method method = WebView.class.getMethod("setLayerType", int.class, Paint.class);
            method.setAccessible(true);
            method.invoke(webView, 1, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
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
//                popWindow();
                showShare();
                break;
        }
    }

    private void popWindow() {
        PopupWindow pop = new PopupWindow();
        View inflate = this.getLayoutInflater().inflate(R.layout.original_pop, null);
        pop.setContentView(inflate);
        fac = (RadioButton)inflate.findViewById(R.id.fac);
        fac.setOnClickListener(this);
        twitter = (RadioButton) inflate.findViewById(R.id.twitter);
        twitter.setOnClickListener(this);
        sinawebo = (RadioButton) inflate.findViewById(R.id.sinawebo);
        sinawebo.setOnClickListener(this);
        wechat = (RadioButton) inflate.findViewById(R.id.wechat);
        wechat.setOnClickListener(this);
        moments = (RadioButton) inflate.findViewById(R.id.moments);
        moments.setOnClickListener(this);
        //设置PopupWindow弹出窗体的宽
        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(null);
        pop.showAtLocation(Share_it_item_Activity.this.findViewById(R.id.qq), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        //设置popupWindow弹出后父布局的背景
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.6f;
        getWindow().setAttributes(params);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 1.0f;
                getWindow().setAttributes(params);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fac:
                break;
            case R.id.twitter:
                break;
            case R.id.sinawebo:
                break;
            case R.id.wechat:
                break;
            case R.id.moments:

                break;
        }
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不     调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.app_name)+title);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("asdfghj");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(url);
        // 启动分享GUI
        oks.show(this);


    }
}
