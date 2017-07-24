package com.example.admin.myapplication.module.panda_live.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ${马志武} on 2017/7/20.
 */

public class TwoPageAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> arrlist;
    private ArrayList<String> titles;
    public TwoPageAdapter(FragmentManager fm, ArrayList<Fragment> arrlist, ArrayList<String> titles) {
        super(fm);
        this.arrlist=arrlist;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return arrlist.get(position);
    }

    @Override
    public int getCount() {
        return arrlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
