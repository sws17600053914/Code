package com.example.admin.myapplication.module.panda_live.duojiaodu;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.MultiBean;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * Created by ${马志武} on 2017/7/20.
 */

public class DuoJiaoDuPresenter implements DuoJiaoDuContract.DuoJiaoDuPresnetr{
    private DuoJiaoDuContract.DuoJiaoDuView duoJiaoDuView;
    private PandaChannelModelImp pandaChannelModelImp;

    public DuoJiaoDuPresenter(DuoJiaoDuContract.DuoJiaoDuView duoJiaoDuView) {
        this.duoJiaoDuView=duoJiaoDuView;
        pandaChannelModelImp=new PandaChannelModelImp();
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
    }
}
