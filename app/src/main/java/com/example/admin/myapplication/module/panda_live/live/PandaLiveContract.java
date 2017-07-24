package com.example.admin.myapplication.module.panda_live.live;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.PandaLiveBean;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 15:18
 * 作 者：T
 * 微信：704003376
 */

public interface PandaLiveContract {
    //PandaLiveView
    interface PandaLiveView extends BaseView<PandaLivePresenter> {
        //TODO请求各种数据更新UI
        void setResultData(PandaLiveBean padaLiveBean);
    }

    //PandaLivePresenter
    interface PandaLivePresenter extends BasePresenter {

    }
}
