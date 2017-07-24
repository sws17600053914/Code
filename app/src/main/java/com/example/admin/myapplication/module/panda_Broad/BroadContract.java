package com.example.admin.myapplication.module.panda_Broad;

import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.PandaBroadBean;
import com.example.admin.myapplication.model.bean.PandaBroadTwoBean;
import com.example.admin.myapplication.model.bean.RollRollVideoBean;
import com.example.admin.myapplication.module.RollRoll_video.RollContract;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public interface BroadContract {

    //View
    interface BroadView extends BaseView<BroadContract.BroadPresenter> {

        void setResultData(PandaBroadTwoBean pandaBroadBean);

        void setPandaBroadListViewDta(PandaBroadBean pandaBroadListViewDta);
    }

    //Presenter
    interface BroadPresenter extends BasePresenter {

    }


}
