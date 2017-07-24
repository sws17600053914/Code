package com.example.admin.myapplication.module.LiveChina.livechinaFragments;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.BaDaLingBean;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public interface LiveChinaFragmentContract {

    //View
    interface LiveChinaFragmentView extends BaseView<LiveChinaFragmentViewPresenter> {

        void setResultData(BaDaLingBean dataBean);

    }
    //Presenter
    interface LiveChinaFragmentViewPresenter extends BasePresenter {
            String getUrl(String url);
    }
}
