package com.example.admin.myapplication.module.LiveChina;


import android.util.Log;

import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.LiveChinaBean;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public class LiveChinaPresenter implements LiveChinaContract.LiveChinaViewPresenter {

    private LiveChinaContract.LiveChinaView liveChinaView;

    private PandaChannelModelImp pandaChannelModelImp;


    public LiveChinaPresenter(LiveChinaContract.LiveChinaView liveChinaView){

        this.liveChinaView = liveChinaView;

        pandaChannelModelImp = new PandaChannelModelImp();
        //实例化
        liveChinaView.setPresenter(this);

    }



    @Override
    public void start() {

        pandaChannelModelImp.getLiveChinaData(new MyCallBack<LiveChinaBean>() {


            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
                //P层是桥梁 将Model层获取的数据交给View层更新UI
                liveChinaView.setResultData(liveChinaBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });

    }
}
