package com.example.admin.myapplication.module.person.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.utils.Code;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/20 0020.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 邮箱注册
 */


public class EmailRegister extends BaseFragment {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.email_gray)
    ImageView emailGray;
    @BindView(R.id.email_email)
    TextView emailEmail;
    @BindView(R.id.email_pass)
    EditText emailPass;
    @BindView(R.id.email_pass_gray)
    ImageView emailPassGray;
    @BindView(R.id.email_tsmm)
    TextView emailTsmm;
    @BindView(R.id.sure_pass)
    EditText surePass;
    @BindView(R.id.sure_pass_gray)
    ImageView surePassGray;
    @BindView(R.id.email_surepass)
    TextView emailSurepass;
    @BindView(R.id.email_yanzhang)
    EditText emailYanzhang;
    @BindView(R.id.email_yanzhang_gray)
    ImageView emailYanzhangGray;
    @BindView(R.id.email_but)
    ImageView emailBut;
    @BindView(R.id.email_tpyz)
    TextView emailTpyz;
    @BindView(R.id.email_treaty)
    CheckBox emailTreaty;
    @BindView(R.id.email_gouxuan)
    TextView emailGouxuan;
    @BindView(R.id.email_register)
    Button emailRegister;
    Unbinder unbinder;
    private Code code;

    @Override
    protected void initData() {
//        code = new Code();
//        emailBut.setImageBitmap(code.getInstance().createBitmap());
//        Log.e("TAG", "验证码："+ code.getInstance().getCode() );
//        Glide.with(this).load("http://reg.cntv.cn/simple/verificationCode.action").into(emailBut);

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.email_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.email_gray, R.id.email_pass_gray, R.id.sure_pass_gray, R.id.email_yanzhang, R.id.email_yanzhang_gray, R.id.email_but, R.id.email_tpyz, R.id.email_treaty, R.id.email_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.email_gray:
                break;
            case R.id.email_pass_gray:
                break;
            case R.id.sure_pass_gray:
                break;
            case R.id.email_yanzhang:
                break;
            case R.id.email_yanzhang_gray:
                break;
            case R.id.email_but:
                Glide.with(this).load("http://reg.cntv.cn/simple/verificationCode.action").into(emailBut);
                break;
            case R.id.email_tpyz:
                break;
            case R.id.email_treaty:
                break;
            case R.id.email_register:
                break;
        }
    }
}
