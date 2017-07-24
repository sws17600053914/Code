package com.example.admin.myapplication.module.person.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/19 0019.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 *   用户反馈viewpager的Adapter
 */


public class MyPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    String[] tit;
    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, String[] tit) {
        super(fm);
        this.fragments = fragments;
        this.tit = tit;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tit[position];
    }
}
