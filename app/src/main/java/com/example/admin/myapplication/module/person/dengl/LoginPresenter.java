package com.example.admin.myapplication.module.person.dengl;


import com.example.admin.myapplication.model.PandaChannelModelImp;
import com.example.admin.myapplication.network.MyCallBack;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/22 0022.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 */


public class LoginPresenter implements LoginContract.LoginPresenter {
    private LoginContract.LoginView loginView;
    private PandaChannelModelImp modelImp;

    public LoginPresenter(LoginContract.LoginView loginView) {
        this.loginView = loginView;
        modelImp=new PandaChannelModelImp();
        loginView.setPresenter(this);
    }

    @Override
    public void start() {


    }


    @Override
    public void log(String username, String password, String service, String from) {
        modelImp.getLoginData(username,  password, service, from,new MyCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                loginView.setResultData(loginBean);
            }

            @Override
            public void onFaile(String msg) {

            }
        });
    }
}
