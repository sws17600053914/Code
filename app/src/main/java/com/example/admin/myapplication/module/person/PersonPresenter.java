package com.example.admin.myapplication.module.person;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/23 0023.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 */


public class PersonPresenter implements PersonContract.PetsonPresenter{
    private PersonContract.PersonView personView;
    private PandaChannelModelImp modelImp;

    public PersonPresenter(PersonContract.PersonView personView) {
        this.personView = personView;
        modelImp=new PandaChannelModelImp();
        personView.setPresenter(this);
    }


    @Override
    public void start() {

    }
    @Override
    public void mynews(String client, String method, String userid) {
        modelImp.getPersonData(client,  method, userid, new MyCallBack<PersonBean.ContentEntity>() {
            @Override
            public void onSuccess(PersonBean.ContentEntity personBean) {
                personView.setResultData(personBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
