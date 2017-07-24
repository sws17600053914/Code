package com.example.admin.myapplication.module.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.person.activity.Collect;
import com.example.admin.myapplication.module.person.activity.HistoricalRecord;
import com.example.admin.myapplication.module.person.activity.Login;
import com.example.admin.myapplication.module.person.activity.Setting;
import com.zhy.android.percent.support.PercentRelativeLayout;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于：2017/7/19 9:30
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 个人中心
 */
public class PersonActivity extends BaseActivity implements View.OnClickListener {
    private ImageView personal_login_head;

    private ImageView back;

    private PercentRelativeLayout login;

    private PercentRelativeLayout watch;

    private PercentRelativeLayout collect;

    private PercentRelativeLayout set;

    @Override
    protected void initView() {
        login = (PercentRelativeLayout) findViewById(R.id.login);
        watch = (PercentRelativeLayout) findViewById(R.id.watch);
        collect = (PercentRelativeLayout) findViewById(R.id.collect);
        set = (PercentRelativeLayout) findViewById(R.id.set);
        back = (ImageView) findViewById(R.id.person_back);

        login.setOnClickListener(this);
        watch.setOnClickListener(this);
        collect.setOnClickListener(this);
        set.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_person;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Intent intent = new Intent(PersonActivity.this, Login.class);
                startActivity(intent);
                break;
            case R.id.watch:
                Intent intent1 = new Intent(PersonActivity.this, HistoricalRecord.class);
                startActivity(intent1);
                break;
            case R.id.collect:
                Intent intent2 = new Intent(PersonActivity.this, Collect.class);
                startActivity(intent2);
                break;
            case R.id.set:
                Intent intent3 = new Intent(PersonActivity.this, Setting.class);
                startActivity(intent3);
                break;
            case R.id.person_back:
                finish();
                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
