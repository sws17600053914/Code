package com.example.admin.myapplication.module.person.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/19 0019.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 个人中心的登录
 */


public class Login extends BaseActivity {


    @BindView(R.id.set_back)
    ImageView setBack;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login_weixin)
    RadioButton loginWeixin;
    @BindView(R.id.login_QQ)
    RadioButton loginQQ;
    @BindView(R.id.radio_home)
    RadioButton radioHome;
    @BindView(R.id.zhangh)
    EditText zhangh;
    @BindView(R.id.tishi_email)
    TextView tishiEmail;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.tishi_pass)
    TextView tishiPass;
    @BindView(R.id.forget_pass)
    TextView forgetPass;
    @BindView(R.id.dengl)
    Button dengl;
    @BindView(R.id.gray)
    ImageView gray;
    private Editable ss;

    @Override
    protected void initView() {
        zhangh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ss = s;
                String s1 = zhangh.getText().toString().trim();
                if(!s1.equals("")){
                    tishiEmail.setVisibility(View.INVISIBLE);
                    gray.setVisibility(View.VISIBLE);
                    gray.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            zhangh.setText("");
                            zhangh.setVisibility(View.GONE);
                        }
                    });
                }else{
                    gray.setVisibility(View.GONE);
                    tishiEmail.setVisibility(View.INVISIBLE);
                }
            }
        });
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {

            }
        });


    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

    @OnClick({R.id.set_back,R.id.zhangh, R.id.gray, R.id.pass, R.id.register, R.id.login_weixin, R.id.login_QQ, R.id.radio_home, R.id.forget_pass, R.id.dengl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.set_back:
                finish();
                break;
            case R.id.register:
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                break;
            case R.id.login_weixin:
                break;
            case R.id.login_QQ:
                break;
            case R.id.radio_home:
                break;
            case R.id.forget_pass:
                Intent intent1 = new Intent(Login.this, Forget.class);
                startActivity(intent1);

                break;
            case R.id.dengl:
                if (zhangh.getText().toString().equals("") && zhangh.getText().toString().isEmpty()) {
                    tishiEmail.setText("邮箱/手机号不能为空");
                } else if (pass.getText().toString().equals("") && pass.getText().toString().isEmpty()) {
                    tishiPass.setText("密码不能为空");
                } else {
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.zhangh:
                zhangh.setFocusable(true);
                zhangh.setFocusableInTouchMode(true);
                zhangh.requestFocus();
                zhangh.requestFocusFromTouch();
                InputMethodManager inputManager =
                        (InputMethodManager)zhangh.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(zhangh, 0);
                tishiEmail.setVisibility(View.INVISIBLE);

                break;
            case R.id.gray:
                zhangh.setText("");
                break;
            case R.id.pass:
                pass.setFocusable(true);
                pass.setFocusableInTouchMode(true);
                pass.requestFocus();
                pass.requestFocusFromTouch();
                InputMethodManager  inputManager1 = (InputMethodManager) pass.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager1.showSoftInput(pass, 0);
                if(!zhangh.getText().toString().trim().equals("")) {
                    if (zhangh.getText().length() != 11 || !(zhangh.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && ss.length() > 0)) {
                        tishiEmail.setVisibility(View.VISIBLE);
                        tishiEmail.setText("邮箱/手机号格式不正确");
                    }else{
                        tishiEmail.setVisibility(View.INVISIBLE);
                    }
                }else{
                    tishiEmail.setVisibility(View.VISIBLE);
                    tishiEmail.setText("邮箱/手机号不能为空");
                }

                break;
        }
    }


}
