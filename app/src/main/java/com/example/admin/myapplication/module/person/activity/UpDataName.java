package com.example.admin.myapplication.module.person.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpDataName extends BaseActivity {


    @BindView(R.id.updata_back)
    ImageView updataBack;
    @BindView(R.id.updata_baocun)
    TextView updataBaocun;
    @BindView(R.id.updata_et)
    EditText updataEt;
    @BindView(R.id.upda_gray)
    ImageView updaGray;
    @BindView(R.id.activity_up_data_name)
    PercentLinearLayout activityUpDataName;
    private String uname;

    @Override
        protected void initView() {
        Intent intent = getIntent();
        uname = intent.getStringExtra("uname");
        updataEt.setText(uname);


    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_up_data_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.updata_baocun, R.id.upda_gray})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.updata_baocun:

                break;
            case R.id.upda_gray:
                updataEt.setText("");
                break;
        }
    }
}
