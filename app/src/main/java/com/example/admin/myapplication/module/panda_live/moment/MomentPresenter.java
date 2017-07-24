package com.example.admin.myapplication.module.panda_live.moment;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.WonderfulBean;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * Created by ${马志武} on 2017/7/19.
 */

public class MomentPresenter implements MomentContract.MomentPresenter {
    private MomentContract.MomentView momentView;
    private PandaChannelModelImp mPandaChannelModelImp;

    public MomentPresenter(MomentContract.MomentView momentView) {
        this.momentView = momentView;
        mPandaChannelModelImp = new PandaChannelModelImp();
    }

    @Override
    public void start() {
        mPandaChannelModelImp.getWonderfulData(new MyCallBack<WonderfulBean>() {
            @Override
            public void onSuccess(WonderfulBean wonderfulBean) {
                momentView.setResultData(wonderfulBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
