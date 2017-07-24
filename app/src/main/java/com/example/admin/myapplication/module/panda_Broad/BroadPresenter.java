package com.example.admin.myapplication.module.panda_Broad;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.model.bean.PandaBroadBean;
import com.example.admin.myapplication.model.bean.PandaBroadTwoBean;
import com.example.admin.myapplication.network.MyCallBack;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.MODE_PRIVATE;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public class BroadPresenter implements BroadContract.BroadPresenter {

    private PandaChannelModelImp modelImp;

    private BroadContract.BroadView broadView;
    private String page;
    private int page1;

    public BroadPresenter(BroadContract.BroadView broadView){

        this.broadView = broadView;

        modelImp = new PandaChannelModelImp();

        broadView.setPresenter(this);

    }

    @Override
    public void start() {

        modelImp.getPandaBraodData(new MyCallBack<PandaBroadTwoBean>() {
            @Override
            public void onSuccess(PandaBroadTwoBean pandaBroadTwoBean) {
                //P层是桥梁 将Model层获取的数据交给View层更新UI
                broadView.setResultData(pandaBroadTwoBean);

                initData(pandaBroadTwoBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });


        Timer tim = new Timer();

        tim.schedule(new TimerTask() {

            @Override
            public void run() {

                SharedPreferences sharedPreferences = MyApp.mContext.getSharedPreferences("Deserve.db", MODE_PRIVATE);

                page1 = sharedPreferences.getInt("page",1);
            }
        },200,200);
        Log.e("deserve","start: "+page );
        modelImp.getPandaBroadData("iphoneInterface/general/getArticleAndVideoListInfo.json"
                ,"PAGE1422435191506336"
                ,"panda"
                ,"6"
                ,page1+""
                , new MyCallBack<PandaBroadBean>() {
                    @Override
                    public void onSuccess(PandaBroadBean pandaBroadBean) {
                        broadView.setPandaBroadListViewDta(pandaBroadBean);
                    }

                    @Override
                    public void onFaile(String msg) {

                    }
                });
    }

    private void initData(PandaBroadTwoBean pandaBroadTwoBean) {

        if (pandaBroadTwoBean != null){

            List<PandaBroadTwoBean.DataBean.BigImgBean> bigImg = pandaBroadTwoBean.getData().getBigImg();

            if (bigImg.size() > 0){

                SharedPreferences sharedPreferences = MyApp.mContext.getSharedPreferences("Deserve.db",MODE_PRIVATE);

                SharedPreferences.Editor edit = sharedPreferences.edit();

                edit.putString("broad_title",bigImg.get(0).getTitle());



                edit.apply();

            }



        }


    }
}
