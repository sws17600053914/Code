package com.example.admin.myapplication.module.person;


import com.example.admin.myapplication.base.BasePresenter;
import com.example.admin.myapplication.base.BaseView;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/22 0022.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 */


public interface PersonContract {

    interface PersonView extends BaseView<PetsonPresenter> {
        void setResultData(PersonBean.ContentEntity personBean);
    }
    interface PetsonPresenter extends BasePresenter {
        void mynews(String client, String method, String userid);
    }
}
