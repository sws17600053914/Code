package com.example.admin.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:35
 * 作 者：T
 * 微信：704003376
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayoutId(), null);
//        ButterKnife.bind(this, view);
        return view;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    /**
     * Fragment初始化数据
     */
    protected abstract void initData();

    /**
     * Fragment初始化View控件
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 加载的Fragment的布局
     *
     * @return
     */
    public abstract int getFragmentLayoutId();


}
