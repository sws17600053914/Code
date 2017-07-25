package com.example.admin.myapplication.module.panda_live.moment;



import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.WonderfulBean;
import com.example.admin.myapplication.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${马志武} on 2017/7/19.
 */

public class MomentPresenter implements MomentContract.MomentPresenter {
    private MomentContract.MomentView momentView;
    private PandaChannelModelImp mPandaChannelModelImp;
    private String id;

    public MomentPresenter(MomentContract.MomentView momentView, String id) {
        this.momentView = momentView;
        this.id=id;
        mPandaChannelModelImp = new PandaChannelModelImp();
    }

    @Override
    public void start() {
        Map<String, String> pamrams = new HashMap<String, String>();
        pamrams.put("vsid", id);
        pamrams.put("n", "7");
        pamrams.put("serviceId", "panda");
        pamrams.put("o", "desc");
        pamrams.put("of", "time");
        pamrams.put("p", "2");
        mPandaChannelModelImp.getWonderfulData(pamrams,new MyCallBack<WonderfulBean>() {
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
