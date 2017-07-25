package com.example.admin.myapplication.global;

import android.app.Application;

import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.module.user.DaoMaster;
import com.example.admin.myapplication.module.user.DaoSession;
import com.example.admin.myapplication.module.user.UserDao;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
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

//        initTuiSend();
    }

    private void initTuiSend() {

        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
            }
            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
    public static UserDao getUserDao(){

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mContext, "BestView.db", null);

        DaoMaster daoMaster = new DaoMaster(helper.getReadableDb());

        DaoSession daoSession = daoMaster.newSession();

        UserDao userDao = daoSession.getUserDao();

        return userDao;
    }
}
