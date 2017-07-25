package com.example.admin.myapplication.module.panda_live;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.LiveTitleBean;

/**
 * Created by ${马志武} on 2017/7/21.
 */

public interface LiveTitleContract {
    interface LiveTitleView extends BaseView<LiveTitlePresenter> {
        void setResultData(LiveTitleBean liveTitleBean);
    }
    interface LiveTitlePresenter extends BasePresenter {

    }
}
