package com.example.admin.myapplication.module.panda_live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ${马志武} on 2017/7/19.
 */

class Pandalive_VPAdapter extends FragmentPagerAdapter {
    String[] sss={"直播","精彩一刻","当熊不让","超萌滚滚秀","熊猫档案","熊猫TOP榜"
            ,"熊猫那些事儿","特别节目","原创新闻"};
    private ArrayList<Fragment> arrlist;
    public Pandalive_VPAdapter(FragmentManager fm, ArrayList<Fragment> arrlist) {
        super(fm);
        this.arrlist=arrlist;
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
        return sss[position];
    }
}
