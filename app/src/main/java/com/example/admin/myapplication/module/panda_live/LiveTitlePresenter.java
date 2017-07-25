package com.example.admin.myapplication.module.panda_live;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.LiveTitleBean;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * Created by ${马志武} on 2017/7/21.
 */

public class LiveTitlePresenter implements LiveTitleContract.LiveTitlePresenter{
   private LiveTitleContract.LiveTitleView liveTitleView;
    private PandaChannelModelImp pandaChannelModelImp;

    public LiveTitlePresenter(LiveTitleContract.LiveTitleView liveTitleView) {
        this.liveTitleView = liveTitleView;
        pandaChannelModelImp=new PandaChannelModelImp();
    }

    @Override
    public void start() {
        pandaChannelModelImp.getLiveTitleData(new MyCallBack<LiveTitleBean>() {
            @Override
            public void onSuccess(LiveTitleBean liveTitleBean) {
                liveTitleView.setResultData(liveTitleBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
