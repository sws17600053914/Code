package com.example.admin.myapplication.module.panda_live.moment;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.WonderfulBean;

/**
 * Created by ${马志武} on 2017/7/19.
 */

public interface MomentContract {
    //PandaLiveView
    interface MomentView extends BaseView<MomentPresenter> {
        //TODO请求各种数据更新UI
        void setResultData(WonderfulBean wonderfulBean);
    }

    //PandaLivePresenter
    interface MomentPresenter extends BasePresenter {

    }
}
