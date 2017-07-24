package com.example.admin.myapplication.module.interact;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.OriginalBean;

/**
 * Created by Pang on 2017/7/19.
 */

public interface OriginalContract {
    interface OriginalView extends BaseView<OriginalPresenter> {
        void setResultData(OriginalBean originalBean);
    }
    interface OriginalPresenter extends BasePresenter {
    }
}
