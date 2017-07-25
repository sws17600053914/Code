package com.example.admin.myapplication.global;

import android.app.Application;

import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.base.BaseFragment;
import com.umeng.socialize.PlatformConfig;

import java.util.ArrayList;

import io.vov.vitamio.Vitamio;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:28
 * 作 者：T
 * 微信：704003376
 */

public class MyApp extends Application {

    public static BaseActivity mContext = null;

    public static BaseActivity mBaseActivity;

    public static BaseFragment mBaseLastFragment;

    public static ArrayList<String> mLists = new ArrayList<>();
    public static ArrayList<String> mListx = new ArrayList<>();

    @Override
    public void onCreate() {
        Vitamio.isInitialized(this);
        super.onCreate();

        // QQ和Qzone appid + appkey
        PlatformConfig.setQQZone("1105366393", "dAFotYfKXT27RGiY");
//微博
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
}
