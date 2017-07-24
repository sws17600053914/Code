package com.example.admin.myapplication.module.LiveChina;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.LiveChinaBean;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public interface LiveChinaContract {

    //View
    interface LiveChinaView extends BaseView<LiveChinaViewPresenter> {

        void setResultData(LiveChinaBean dataBean);

    }
    //Presenter
    interface LiveChinaViewPresenter extends BasePresenter {

    }
}
