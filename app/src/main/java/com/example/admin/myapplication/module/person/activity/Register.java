package com.example.admin.myapplication.module.person.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.person.fragment.EmailRegister;
import com.example.admin.myapplication.module.person.fragment.PhoneRegister;
import com.zhy.android.percent.support.PercentFrameLayout;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/20 0020.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 注册账号
 */


public class Register extends BaseActivity {
    @BindView(R.id.user_back)
    ImageView userBack;
    @BindView(R.id.phone_zhuce)
    Button phoneZhuce;
    @BindView(R.id.email_zhuce)
    Button emailZhuce;
    @BindView(R.id.register_tab)
    PercentLinearLayout registerTab;
    @BindView(R.id.register_pager)
    PercentFrameLayout registerPager;
    PhoneRegister phoneRegister;
    EmailRegister emailRegister;
    @BindView(R.id.one)
    TextView one;
    @BindView(R.id.two)
    TextView two;

    @Override
    protected void initView() {
        one.setBackgroundColor(Color.parseColor("#3565a6"));
        two.setBackgroundColor(Color.parseColor("#ffffff"));

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.register_pager,new PhoneRegister());
        transaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction) {

        if (phoneRegister != null) {

            transaction.hide(phoneRegister);
        }
        if (emailRegister != null) {

            transaction.hide(emailRegister);
        }

    }

    @OnClick({R.id.user_back, R.id.phone_zhuce, R.id.email_zhuce})
    public void onViewClicked(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        hideFragment(transaction);

        switch (view.getId()) {
            case R.id.user_back:
                finish();
                break;
            case R.id.phone_zhuce:
                one.setBackgroundColor(Color.parseColor("#3565a6"));
                two.setBackgroundColor(Color.parseColor("#ffffff"));
                if (phoneRegister == null) {
                    phoneRegister = new PhoneRegister();
                    transaction.add(R.id.register_pager, phoneRegister);
                } else {
                    transaction.show(phoneRegister);
                }
                break;
            case R.id.email_zhuce:
                two.setBackgroundColor(Color.parseColor("#3565a6"));
                one.setBackgroundColor(Color.parseColor("#ffffff"));
                if (emailRegister == null) {
                    emailRegister = new EmailRegister();
                    transaction.add(R.id.register_pager, emailRegister);
                } else {
                    transaction.show(emailRegister);
                }
                break;
        }
        transaction.commit();
    }

}
