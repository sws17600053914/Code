package com.example.admin.myapplication.module.panda_live.biankanbianliao;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.MultiBean;
import com.example.admin.myapplication.module.panda_live.duojiaodu.DuoJiaoDuContract;

/**
 * Created by ${马志武} on 2017/7/20.
 */

public interface WatchAndTalkContract {
    //PandaLiveView
    interface WatchAndTalkView extends BaseView<DuoJiaoDuContract.DuoJiaoDuPresnetr> {
        //TODO请求各种数据更新UI
        void setResultData(MultiBean multiBean);
    }

    //PandaLivePresenter
    interface WatchAndTalkPresnetr extends BasePresenter {

    }
}
