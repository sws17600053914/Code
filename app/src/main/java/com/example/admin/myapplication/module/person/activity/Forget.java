package com.example.admin.myapplication.module.person.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.utils.Code;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/20 0020.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 忘记密码
 */


public class Forget extends BaseActivity {
    @BindView(R.id.forget_back)
    ImageView forgetBack;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.phone_gray)
    ImageView phoneGray;
    @BindView(R.id.forget_phone)
    TextView forgetPhone;
    @BindView(R.id.forget_tupian_yanzhang)
    EditText forgetTupianYanzhang;
    @BindView(R.id.forget_yanzhang_gray)
    ImageView forgetYanzhangGray;
    @BindView(R.id.forget_ypyz)
    ImageView forgetYpyz;
    @BindView(R.id.text_tistpyz)
    TextView textTistpyz;
    @BindView(R.id.forget_duanxin_yanzhang)
    EditText forgetDuanxinYanzhang;
    @BindView(R.id.forget_duanxin_gray)
    ImageView forgetDuanxinGray;
    @BindView(R.id.forget_yanzbut)
    Button forgetYanzbut;
    @BindView(R.id.forget_dxyz)
    TextView forgetDxyz;
    @BindView(R.id.register_newpass)
    EditText registerNewpass;
    @BindView(R.id.register_gary)
    ImageView registerGary;
    @BindView(R.id.forget_czmm)
    TextView forgetCzmm;
    @BindView(R.id.forget_but)
    Button forgetBut;
    private Code code;

    @Override
    protected void initView() {
//        code = new Code();
//        forgetYpyz.setImageBitmap(code.getInstance().createBitmap());
//        Log.e("TAG", "验证码："+ code.getInstance().getCode() );
        Glide.with(this).load("http://reg.cntv.cn/simple/verificationCode.action").into(forgetYpyz);
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.forget;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.forget_back, R.id.phone_gray, R.id.forget_tupian_yanzhang, R.id.forget_yanzhang_gray, R.id.forget_ypyz, R.id.forget_duanxin_gray, R.id.forget_yanzbut, R.id.register_gary, R.id.forget_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_back:
                break;
            case R.id.phone_gray:
                break;
            case R.id.forget_tupian_yanzhang:
                break;
            case R.id.forget_yanzhang_gray:
                break;
            case R.id.forget_ypyz://图片验证码
//                forgetYpyz.setImageBitmap(code.getInstance().createBitmap());
//                Log.e("TAG", "验证码："+ code.getInstance().getCode() );
                Glide.with(this).load("http://reg.cntv.cn/simple/verificationCode.action").into(forgetYpyz);
                break;
            case R.id.forget_duanxin_gray:
                break;
            case R.id.forget_yanzbut:
                break;
            case R.id.register_gary:
                break;
            case R.id.forget_but:
                break;
        }
    }
}
