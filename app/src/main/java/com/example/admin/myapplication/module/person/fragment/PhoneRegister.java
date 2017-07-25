package com.example.admin.myapplication.module.person.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
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
import com.example.admin.myapplication.module.person.activity.Login;
import com.example.admin.myapplication.utils.Code;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
    private static String JSESSIONID = "";
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
    private String user_phone;
    private String user_picture;
    private byte[] bytes;
    private String exception;
    private String phoneyanzhengma;
    private String passwrod;
    private String user_shortmessage;
    private String user_pass;

    @Override
    protected void initData() {

        user_phone = phone.getText().toString().trim();
        user_picture = tupianYanzhang.getText().toString().trim();
        user_shortmessage = duanxinYanzhang.getText().toString().trim();
        user_pass = registerPass.getText().toString().trim();




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
            case R.id.phone_but:  //获取验证码的but
                if (user_phone.equals("")&&user_phone==null&&user_picture.equals("")&&user_picture==null&&user_shortmessage.equals("")&&user_shortmessage==null) {
//                    nullPhone.setText("手机号不能为空");
//                    nullImagecheck.setText("验证码不能为空");
//                    nullPhonecheck.setText("验证码不能为空");
                }
                getPersonalRegPhoneCheck();
                break;
            case R.id.register_pass_gray:
                break;
            case R.id.phone_treaty:
                break;
            case R.id.phone_register:
                break;
            case R.id.ypyz:
                getPersonalRegImgCheck();
                Toast.makeText(getActivity(), "图片", Toast.LENGTH_SHORT).show();

//                      ypyz.setImageResource(R.mipmap.ic_launcher);
//                      Glide.with(getActivity()).load("http://reg.cntv.cn/simple/verificationCode.action").into(ypyz);
                break;
        }
    }
    public void getPersonalRegImgCheck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request build = new Request.Builder().url("http://reg.cntv.cn/simple/verificationCode.action").build();
                okHttpClient.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        Headers headers = response.headers();

                        JSESSIONID = headers.get("Set-Cookie");
                        Log.e("TAG", "图形验证码的额" + JSESSIONID);

                        bytes = response.body().bytes();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Drawable captchaImage = byteToDrawable(bytes);
                                ypyz.setImageDrawable(captchaImage);
                            }
                        });
                    }
                });
            }
        }).start();
    }
    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }




    public void getPersonalRegPhoneCheck() {
//17600304681


        OkHttpClient click = new OkHttpClient();
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";
//                    手机号

//                    图形验证码

//                请求  获取验证码的 网络请求
//                post 请求体
        Log.e("TAG", "图形验证码" + JSESSIONID);
        RequestBody body = new FormBody.Builder()
                .add("method", "getRequestVerifiCodeM")
                .add("mobile", user_phone)
                .add("verfiCodeType", "1")
                .add("verificationCode", user_picture)
                .build();
        try {
//                    post  请求头
            Request request = new Request.Builder().url(url)
                    .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", JSESSIONID)
                    .post(body).build();

            click.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    exception = e.getMessage().toString();
                    Log.e("TAG", e.getMessage().toString());


                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    String string = response.body().string();
                    Log.e("TAG", "手机验证码结果" + string);

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }


    public void getRegister() throws UnsupportedEncodingException {

        OkHttpClient client = new OkHttpClient();
//                    手机号
//        String tPhoneNumber = phone.getText().toString().trim();
//        Log.e("TAG", "手机号：" + tPhoneNumber);
////                    图形验证码
//        String imgyanzhengma = user_picture.getText().toString().trim();
//        //手机验证码
//        phoneyanzhengma = user_shortmessage.getText().toString().trim();
//        Log.e("TAG", "手机验证码：" + phoneyanzhengma);
////mima
//        passwrod = editInputpasswrod.getText().toString().trim();
//
//        Log.e("TAG", "密码：" + passwrod);

//                请求  获取验证码的 网络请求
//                post 请求体
        Log.e("TAG", "图形验证码" + JSESSIONID);
        RequestBody body = new FormBody.Builder()
                .add("method", "saveMobileRegisterM")
                .add("mobile", user_phone)
                .add("verfiCode", user_shortmessage)
                .add("passWd", URLEncoder.encode(user_pass, "UTF-8"))
                .add("verfiCod eType", "1")
                .add("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                .build();

        Request build = new Request.Builder().url("https://reg.cntv.cn/regist/mobileRegist.do")
                .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                .post(body)
                .build();

        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

//                if (BuildConfig.DEBUG) {
//                    Log.e("TAG", e.getMessage());
//                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String tString = response.body().string();
//                if (BuildConfig.DEBUG) {
                    Log.e("TAG", "注册：" + tString);

                    if(tString.equals("Success")) {
                        Toast.makeText(getActivity(), "注册成功，返回注册", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getActivity(), Login.class));
                    }

//                }
            }
        });

    }
}
