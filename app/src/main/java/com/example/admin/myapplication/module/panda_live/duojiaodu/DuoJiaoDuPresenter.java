package com.example.admin.myapplication.module.panda_live.duojiaodu;

import android.util.Log;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.LiveURLBean;
import com.example.admin.myapplication.model.bean.MultiBean;
import com.example.admin.myapplication.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${马志武} on 2017/7/20.
 */

public class DuoJiaoDuPresenter implements DuoJiaoDuContract.DuoJiaoDuPresnetr{
    private DuoJiaoDuContract.DuoJiaoDuView duoJiaoDuView;
    private PandaChannelModelImp pandaChannelModelImp;
    private String id;

    public DuoJiaoDuPresenter(DuoJiaoDuContract.DuoJiaoDuView duoJiaoDuView, String mId) {
        this.duoJiaoDuView=duoJiaoDuView;
        pandaChannelModelImp=new PandaChannelModelImp();
        this.id=mId;
    }

    @Override
    public void start() {
        pandaChannelModelImp.getMultiData(new MyCallBack<MultiBean>() {
            @Override
            public void onSuccess(MultiBean multiBean) {
                duoJiaoDuView.setResultData(multiBean);
            }

            @Override
            public void onFaile(String msg) {
            }
        });
        Map<String,String> map=new HashMap<>();
        map.put("channel","pa://cctv_p2p_hd"+id);
        map.put("client","androidapp");
        pandaChannelModelImp.getLiveUrlData(map, new MyCallBack<LiveURLBean>() {
            @Override
            public void onSuccess(LiveURLBean liveURLBean) {
                duoJiaoDuView.setLiveUrlData(liveURLBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
