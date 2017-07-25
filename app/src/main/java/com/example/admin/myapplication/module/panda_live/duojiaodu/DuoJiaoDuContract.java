package com.example.admin.myapplication.module.panda_live.duojiaodu;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.LiveURLBean;
import com.example.admin.myapplication.model.bean.MultiBean;

/**
 * Created by ${马志武} on 2017/7/20.
 */

public interface DuoJiaoDuContract {
    //PandaLiveView
    interface DuoJiaoDuView extends BaseView<DuoJiaoDuPresnetr> {
        //TODO请求各种数据更新UI
        void setResultData(MultiBean multiBean);
        void setLiveUrlData(LiveURLBean liveURLBean);
    }

    //PandaLivePresenter
    interface DuoJiaoDuPresnetr extends BasePresenter {

    }
}
