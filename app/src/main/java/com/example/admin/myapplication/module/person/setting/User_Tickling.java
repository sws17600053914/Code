package com.example.admin.myapplication.module.person.setting;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.person.adapter.MyPagerAdapter;
import com.example.admin.myapplication.module.person.fragment.MissProblem;
import com.example.admin.myapplication.module.person.fragment.UsualProblem;

import java.util.ArrayList;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于：2017/7/19 9:30
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 意见反馈
 */
public class User_Tickling extends BaseActivity implements View.OnClickListener {
    private ImageView user_back;
    private TabLayout user_tab;
    private ViewPager user_pager;
    MissProblem missProblem;
    UsualProblem usualProblem;
    ArrayList<Fragment> fragments;
    MyPagerAdapter adapter;
String[] tit = new String[]{"遇到的问题","常见问题"};
    @Override
    protected void initView() {
        user_back = (ImageView) findViewById(R.id.user_back);
        user_tab = (TabLayout) findViewById(R.id.user_tab);
        user_pager = (ViewPager) findViewById(R.id.user_pager);
        missProblem = new MissProblem();
        usualProblem = new UsualProblem();
        fragments = new ArrayList<>();
        fragments.add(missProblem);
        fragments.add(usualProblem);
        adapter = new MyPagerAdapter(getSupportFragmentManager(),fragments,tit);
        user_pager.setAdapter(adapter);
        user_tab.setTabMode(TabLayout.MODE_FIXED);
        user_tab.setupWithViewPager(user_pager);


    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_user__tickling;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_back:
                finish();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
