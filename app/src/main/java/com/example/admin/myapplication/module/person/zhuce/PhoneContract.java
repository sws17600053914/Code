package com.example.admin.myapplication.module.person.zhuce;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;
import com.example.admin.myapplication.model.bean.PhoneBean;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/22 0022.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 */


public interface PhoneContract {
    //View
    interface PhoneView extends BaseView<PhonePresenter> {
        void setResultData(PhoneBean PhoneBean);
    }

    //Presenter
    interface PhonePresenter extends BasePresenter {

    }
}
