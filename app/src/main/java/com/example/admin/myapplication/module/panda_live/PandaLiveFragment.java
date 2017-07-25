package com.example.admin.myapplication.module.panda_live;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.model.bean.LiveTitleBean;
import com.example.admin.myapplication.module.panda_live.live.Live;
import com.example.admin.myapplication.module.panda_live.moment.Moment;
import com.example.admin.myapplication.utils.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:23
 * 作 者：T
 * 微信：704003376
 * <p>
 * 熊猫直播模块的View层  需要通过P层处理逻辑并且获取数据
 */

public class PandaLiveFragment extends BaseFragment implements LiveTitleContract.LiveTitleView{
    private LiveTitleContract.LiveTitlePresenter mPresenter;
    TabLayout tabPandalive;
    NoScrollViewPager vpPandalive;
    private ArrayList<Fragment> arrlist=new ArrayList<>();
    private ArrayList<String> arr;
    @Override
    protected void initData() {
        mPresenter=new LiveTitlePresenter(this);
        mPresenter.start();
    }

    @Override
    protected void initView(View view) {
        vpPandalive= (NoScrollViewPager) view.findViewById(R.id.vp_pandalive);
        tabPandalive= (TabLayout) view.findViewById(R.id.tab_pandalive);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pandalive;
    }

    @Override
    public void setPresenter(LiveTitleContract.LiveTitlePresenter liveTitlePresenter) {
        this.mPresenter=liveTitlePresenter;
    }

    @Override
    public void setResultData(LiveTitleBean liveTitleBean) {
        List<LiveTitleBean.TablistBean> tablist = liveTitleBean.getTablist();
        arr=new ArrayList<>();
        Live live = new Live();
        arrlist.add(live);
        for (int i = 0; i < tablist.size(); i++) {
            String title = tablist.get(i).getTitle();
            arr.add(title);
            if (i>0) {
                Moment moment = new Moment();
                Bundle bundle = new Bundle();
                bundle.putString("id", tablist.get(i).getId());
                moment.setArguments(bundle);
                arrlist.add(moment);
            }
        }
        FragmentManager fm = getFragmentManager();
        Pandalive_VPAdapter vpAdapter = new Pandalive_VPAdapter(fm, arrlist,arr);
        vpPandalive.setAdapter(vpAdapter);
        tabPandalive.setupWithViewPager(vpPandalive);
        tabPandalive.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabPandalive.setTabTextColors(Color.BLACK,Color.BLUE);
        tabPandalive.setSelectedTabIndicatorHeight(5);
        tabPandalive.setSelectedTabIndicatorColor(Color.BLUE);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
