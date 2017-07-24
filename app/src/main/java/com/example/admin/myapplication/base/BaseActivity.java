package com.example.admin.myapplication.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.myapplication.global.MyApp;

import butterknife.ButterKnife;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:30
 * 作 者：T
 * 微信：704003376
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        MyApp.mContext=this;
        MyApp.mBaseActivity = this;
        ButterKnife.bind(this);
        initView();


    }

    /**
     * Activity初始化View控件
     */
    protected abstract void initView();

    /**
     *   加载Activity的布局
     * @return Activity的布局ID
     */
    public abstract int getActivityLayoutId();


}
