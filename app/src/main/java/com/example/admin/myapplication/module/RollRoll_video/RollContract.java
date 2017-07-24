package com.example.admin.myapplication.module.RollRoll_video;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.RollRollVideoBean;

public interface RollContract {
    //View
    interface RollView extends BaseView<RollPresenter> {
        void setResultData(RollRollVideoBean resultData);
    }

    //Presenter
    interface RollPresenter extends BasePresenter {

    }
}
