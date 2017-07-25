package com.example.admin.myapplication.module.panda_live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ${马志武} on 2017/7/19.
 */

class Pandalive_VPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrlist;
    private ArrayList<String> arr;
    public Pandalive_VPAdapter(FragmentManager fm, ArrayList<Fragment> arrlist, ArrayList<String> arr) {
        super(fm);
        this.arrlist=arrlist;
        this.arr=arr;
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
        return arr.get(position);
    }
}
