package com.example.admin.myapplication.module.panda_live;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.module.panda_live.fragments_live.News;
import com.example.admin.myapplication.module.panda_live.fragments_live.NotBack;
import com.example.admin.myapplication.module.panda_live.fragments_live.PandaFile;
import com.example.admin.myapplication.module.panda_live.fragments_live.PandaTop;
import com.example.admin.myapplication.module.panda_live.fragments_live.RollShow;
import com.example.admin.myapplication.module.panda_live.fragments_live.Special;
import com.example.admin.myapplication.module.panda_live.fragments_live.ThatThings;
import com.example.admin.myapplication.module.panda_live.live.Live;
import com.example.admin.myapplication.module.panda_live.moment.Moment;
import com.example.admin.myapplication.module.person.PersonActivity;
import com.example.admin.myapplication.utils.NoScrollViewPager;

import java.util.ArrayList;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:23
 * 作 者：T
 * 微信：704003376
 * <p>
 * 熊猫直播模块的View层  需要通过P层处理逻辑并且获取数据
 */

public class PandaLiveFragment extends BaseFragment {
    TabLayout tabPandalive;
    NoScrollViewPager vpPandalive;
    private ArrayList<Fragment> arrlist = new ArrayList<>();
    private ImageView image_persion;

    @Override
    protected void initData() {
        Live live = new Live();
        Moment moment = new Moment();
        NotBack notBack = new NotBack();
        RollShow rollShow = new RollShow();
        PandaFile pandaFile = new PandaFile();
        PandaTop pandaTop = new PandaTop();
        ThatThings thatThings = new ThatThings();
        Special special = new Special();
        News news = new News();
        arrlist.add(live);
        arrlist.add(moment);
        arrlist.add(notBack);
        arrlist.add(rollShow);
        arrlist.add(pandaFile);
        arrlist.add(pandaTop);
        arrlist.add(thatThings);
        arrlist.add(special);
        arrlist.add(news);
        FragmentManager fm = MyApp.mContext.getSupportFragmentManager();
        Pandalive_VPAdapter vpAdapter = new Pandalive_VPAdapter(fm, arrlist);
        vpPandalive.setAdapter(vpAdapter);
        tabPandalive.setupWithViewPager(vpPandalive);
        tabPandalive.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabPandalive.setTabTextColors(Color.BLACK, Color.BLUE);
        tabPandalive.setSelectedTabIndicatorHeight(5);
        tabPandalive.setSelectedTabIndicatorColor(Color.BLUE);
    }

    @Override
    protected void initView(View view) {
        vpPandalive = (NoScrollViewPager) view.findViewById(R.id.vp_pandalive);
        tabPandalive = (TabLayout) view.findViewById(R.id.tab_pandalive);
        image_persion = (ImageView) view.findViewById(R.id.pandaLive_gerenzhongxin);

        image_persion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PersonActivity.class);

                startActivity(intent);

            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_pandalive;
    }


}
