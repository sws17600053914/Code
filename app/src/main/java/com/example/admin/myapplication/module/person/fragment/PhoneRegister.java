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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.utils.Code;

import java.net.MalformedURLException;
import java.net.URL;

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
 * <p>
 * 手机号注册的Fragment
 */


public class PhoneRegister extends BaseFragment {
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.gray)
    ImageView gray;
    @BindView(R.id.phone_phone)
    TextView phonePhone;
    @BindView(R.id.tupian_yanzhang)
    EditText tupianYanzhang;
    @BindView(R.id.tupian_gray)
    ImageView tupianGray;
    @BindView(R.id.ypyz)
    ImageView ypyz;
    @BindView(R.id.phone_tpyz)
    TextView phoneTpyz;
    @BindView(R.id.duanxin_yanzhang)
    EditText duanxinYanzhang;
    @BindView(R.id.duanxin_gray)
    ImageView duanxinGray;
    @BindView(R.id.phone_but)
    Button phoneBut;
    @BindView(R.id.phone_dxyz)
    TextView phoneDxyz;
    @BindView(R.id.register_pass)
    EditText registerPass;
    @BindView(R.id.register_pass_gray)
    ImageView registerPassGray;
    @BindView(R.id.phone_tsmm)
    TextView phoneTsmm;
    @BindView(R.id.phone_treaty)
    CheckBox phoneTreaty;
    @BindView(R.id.phone_gouxuan)
    TextView phoneGouxuan;
    @BindView(R.id.phone_register)
    Button phoneRegister;
    Unbinder unbinder;
    private Code code;
    private URL url;

    @Override
    protected void initData() {
        String user_Phone = phone.getText().toString().trim();
        String user_Picture = tupianYanzhang.getText().toString().trim();
        String user_Shortmessage = duanxinYanzhang.getText().toString().trim();
        String user_Pass = registerPass.getText().toString().trim();




        }
//
    @Override
    protected void initView(View view) {

        try {
            url = new URL("http://reg.cntv.cn/simple/verificationCode.action");
            Glide.with(getActivity()).load(url).into(ypyz);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


}

    @Override
    public int getFragmentLayoutId() {
        return R.layout.phone_fragment;
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

    @OnClick({R.id.gray, R.id.tupian_gray, R.id.duanxin_gray, R.id.phone_but, R.id.register_pass_gray, R.id.phone_treaty, R.id.phone_register,R.id.ypyz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gray:
                break;
            case R.id.tupian_gray:
                break;
            case R.id.duanxin_gray:
                break;
            case R.id.phone_but:
                break;
            case R.id.register_pass_gray:
                break;
            case R.id.phone_treaty:
                break;
            case R.id.phone_register:
                break;
            case R.id.ypyz:
                Toast.makeText(getActivity(), "图片", Toast.LENGTH_SHORT).show();

//                      ypyz.setImageResource(R.mipmap.ic_launcher);
                      Glide.with(getActivity()).load("http://reg.cntv.cn/simple/verificationCode.action").into(ypyz);
                break;
        }
    }
}
