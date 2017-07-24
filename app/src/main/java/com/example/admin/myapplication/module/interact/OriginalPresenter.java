package com.example.admin.myapplication.module.interact;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.OriginalBean;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * Created by Pang on 2017/7/19.
 */

public class OriginalPresenter implements OriginalContract.OriginalPresenter{
    private OriginalContract.OriginalView originalView;
    private PandaChannelModelImp modelImp;

    public OriginalPresenter(OriginalContract.OriginalView originalView) {
        this.originalView = originalView;
        modelImp=new PandaChannelModelImp();
        originalView.setPresenter(this);
    }

    @Override
    public void start() {
        modelImp.getOriginalData(new MyCallBack<OriginalBean>() {
            @Override
            public void onSuccess(OriginalBean originalBean) {
                originalView.setResultData(originalBean);
            }

            @Override
            public void onFaile(String msg) {
            }
        });
    }
}
