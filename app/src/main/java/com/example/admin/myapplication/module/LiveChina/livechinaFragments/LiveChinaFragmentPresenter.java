package com.example.admin.myapplication.module.LiveChina.livechinaFragments;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.BaDaLingBean;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public class LiveChinaFragmentPresenter implements LiveChinaFragmentContract.LiveChinaFragmentViewPresenter {

    private LiveChinaFragmentContract.LiveChinaFragmentView liveChinaView;

    private PandaChannelModelImp pandaChannelModelImp;
    String url;

    public LiveChinaFragmentPresenter(LiveChinaFragmentContract.LiveChinaFragmentView liveChinaView){

        this.liveChinaView = liveChinaView;

        pandaChannelModelImp = new PandaChannelModelImp();
        //实例化
        liveChinaView.setPresenter(this);

    }



    @Override
    public void start() {

        pandaChannelModelImp.getBaDaLingData(url,new MyCallBack<BaDaLingBean>() {


            @Override
            public void onSuccess(BaDaLingBean baDaLingBean) {
                //P层是桥梁 将Model层获取的数据交给View层更新UI
                liveChinaView.setResultData(baDaLingBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });

    }

    @Override
    public String getUrl(String url) {
        this.url=url;
        return "";
    }
}
