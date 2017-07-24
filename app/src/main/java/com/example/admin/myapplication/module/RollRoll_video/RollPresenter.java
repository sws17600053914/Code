package com.example.admin.myapplication.module.RollRoll_video;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.RollRollVideoBean;
import com.example.admin.myapplication.network.MyCallBack;

public class RollPresenter implements RollContract.RollPresenter {

    private RollContract.RollView rollView;
    private PandaChannelModelImp modelImp;

    public RollPresenter(RollContract.RollView rollView){

        this.rollView = rollView;

        modelImp = new PandaChannelModelImp();

        rollView.setPresenter(this);
    }


    @Override
    public void start() {
        //处理相关业务逻辑
        modelImp.getRollVideoData(new MyCallBack<RollRollVideoBean>() {
            @Override
            public void onSuccess(RollRollVideoBean rollRollVideoBean) {
                //P层是桥梁 将Model层获取的数据交给View层更新UI
                rollView.setResultData(rollRollVideoBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });


    }
}
