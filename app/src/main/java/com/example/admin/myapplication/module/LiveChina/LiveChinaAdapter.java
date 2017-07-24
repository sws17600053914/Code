package com.example.admin.myapplication.module.LiveChina;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/19.
 */

public class LiveChinaAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    ArrayList<String> list;
    public LiveChinaAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(fm);
        this.fragments=fragments;
        this.list=strings;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
