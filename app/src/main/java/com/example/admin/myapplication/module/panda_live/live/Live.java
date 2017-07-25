package com.example.admin.myapplication.module.panda_live.live;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.model.bean.PandaLiveBean;
import com.example.admin.myapplication.module.panda_live.biankanbianliao.WatchAndTalk;
import com.example.admin.myapplication.module.panda_live.duojiaodu.DuoJiaoDu;
import com.example.admin.myapplication.utils.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


/**
 * Created by Administrator on 2017/7/19.
 */

public class Live extends BaseFragment implements PandaLiveContract.PandaLiveView,View.OnClickListener{
    private PandaLiveContract.PandaLivePresenter mPandaLivePresenter;
    private ImageView iv_show_more;
    private VideoView videoView;
    private TextView title,introduce;
    private LinearLayout linearLayout;
    private TabLayout tab;
    private NoScrollViewPager vp;
    private boolean isShow=true;
    private ArrayList<String> titles=new ArrayList<>();
    private String left="";
    private String right="";
    private String brief="";
    private ArrayList<Fragment> arrlist=new ArrayList<>();
    private BroadcastReceiver br=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("title");
            String liveUrl = intent.getStringExtra("liveUrl");
            title.setText(stringExtra);
           // initVideo(liveUrl);
        }
    };
    IntentFilter ifs=new IntentFilter();
    private TwoPageAdapter twoPageAdapter;
    private WatchAndTalk watchAndTalk;
    private DuoJiaoDu duoJiaoDu;

    @Override
    protected void initData() {
        mPandaLivePresenter = new PandaFragmentPresenter(this);
        mPandaLivePresenter.start();
    }

    @Override
    protected void initView(View view) {
        videoView= (VideoView) view.findViewById(R.id.iv_live_up);
        iv_show_more= (ImageView) view.findViewById(R.id.iv_show_more);
        title= (TextView) view.findViewById(R.id.title_live);
        introduce= (TextView) view.findViewById(R.id.tv_introduce);
        linearLayout= (LinearLayout) view.findViewById(R.id.linear);
        tab= (TabLayout) view.findViewById(R.id.tab_two);
        vp= (NoScrollViewPager) view.findViewById(R.id.vp_two);
        iv_show_more.setOnClickListener(this);
        ifs.addAction("com.com.com");
        getActivity().registerReceiver(br,ifs);
        if (watchAndTalk==null && duoJiaoDu==null){
            watchAndTalk = new WatchAndTalk();
            duoJiaoDu = new DuoJiaoDu();
            arrlist.add(duoJiaoDu);
            arrlist.add(watchAndTalk);
        }
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.live;
    }


    @Override
    public void setPresenter(PandaLiveContract.PandaLivePresenter pandaLivePresenter) {
        mPandaLivePresenter = pandaLivePresenter;
    }
    @Override
    public void setResultData(PandaLiveBean padaLiveBean) {
        // 获取简介
        brief=getIntroduce(padaLiveBean);
        introduce.setText(brief);

        String sss = padaLiveBean.getLive().get(0).getTitle();
        title.setText(sss);

        left=getTitleLeft(padaLiveBean);
        titles.add(left);

        right=getTitleRight(padaLiveBean);
        titles.add(right);

        FragmentManager fm = getFragmentManager();
        // FragmentManager fm = getActivity().getSupportFragmentManager();
        twoPageAdapter = new TwoPageAdapter(fm, arrlist, titles);
        vp.setAdapter(twoPageAdapter);
        tab.setupWithViewPager(vp);
        tab.setTabTextColors(Color.BLACK,Color.BLUE);
        tab.setSelectedTabIndicatorHeight(5);
        tab.setSelectedTabIndicatorColor(Color.BLUE);
        twoPageAdapter.notifyDataSetChanged();
    }

    private String getIntroduce(PandaLiveBean padaLiveBean) {
        String brief = padaLiveBean.getLive().get(0).getBrief();
        return brief;
    }

    private String getTitleRight(PandaLiveBean padaLiveBean) {
        String rightTitle = padaLiveBean.getBookmark()
                .getWatchTalk()
                .get(0)
                .getTitle();
        return rightTitle;
    }

    private String getTitleLeft(PandaLiveBean padaLiveBean) {
        String titleLeft = padaLiveBean.getBookmark()
                .getMultiple()
                .get(0)
                .getTitle();
        return titleLeft;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.iv_show_more:
                if (isShow){
                    introduce.setVisibility(View.VISIBLE);
                    isShow=false;
                }else {
                    introduce.setVisibility(View.GONE);
                    isShow=true;
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(br);
    }

    private void initVideo(String url) {
        videoView.setVideoURI(Uri.parse(url));
        MediaController controller = new MediaController(getActivity());
        videoView.setMediaController(controller);
        controller.setMediaPlayer(videoView);
        videoView.requestFocus();
        controller.setVisibility(View.INVISIBLE);
        videoView.setMediaController(controller);
        videoView.start();   //开始播放
    }
}
