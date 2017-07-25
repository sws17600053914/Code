package com.example.admin.myapplication.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.LiveChina.LiveChinaFragment;
import com.example.admin.myapplication.module.RollRoll_video.RollFragment;
import com.example.admin.myapplication.module.home.HomeFragment;
import com.example.admin.myapplication.module.panda_Broad.BroadFragment;
import com.example.admin.myapplication.module.panda_live.PandaLiveFragment;
import com.roger.catloadinglibrary.CatLoadingView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private HomeFragment homeFragment;

    private PandaLiveFragment pandaLiveFragment;

    private RollFragment rollFragment;

    private BroadFragment broadFragment;

    private LiveChinaFragment liveChinaFragment;

    private RadioButton btn_home;
    private RadioButton btn_pandalive;
    private RadioButton btn_roll;
    private RadioButton btn_broad;
    private RadioButton btn_livechina;
    private CatLoadingView catLoadingView;
    private boolean state = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PushAgent.getInstance(this).onAppStart();
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
            transaction.add(R.id.frame_layout, homeFragment);
        } else {
            transaction.add(R.id.frame_layout, homeFragment);
        }
        transaction.commit();

        if (btn_home.isChecked()) {

            btn_home.setBackgroundResource(R.color.huise);
        } else {
            btn_home.setBackgroundResource(R.color.white_fafaf8);
        }
    }


    @Override
    protected void initView() {
        btn_home = (RadioButton) findViewById(R.id.radio_home);
        btn_pandalive = (RadioButton) findViewById(R.id.radio_pandalive);
        btn_roll = (RadioButton) findViewById(R.id.radio_rollrollvideo);
        btn_broad = (RadioButton) findViewById(R.id.radio_pandabroad);
        btn_livechina = (RadioButton) findViewById(R.id.radio_livechina);

        btn_home.setOnClickListener(this);
        btn_pandalive.setOnClickListener(this);
        btn_roll.setOnClickListener(this);
        btn_broad.setOnClickListener(this);
        btn_livechina.setOnClickListener(this);

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    private void hideFragment(FragmentTransaction transaction) {

        if (homeFragment != null) {

            transaction.hide(homeFragment);
        }
        if (pandaLiveFragment != null) {

            transaction.hide(pandaLiveFragment);
        }
        if (rollFragment != null) {

            transaction.hide(rollFragment);
        }
        if (broadFragment != null) {

            transaction.hide(broadFragment);
        }
        if (liveChinaFragment != null) {

            transaction.hide(liveChinaFragment);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        hideFragment(transaction);


        switch (v.getId()) {
            case R.id.radio_home:
                state(); //底部按钮的背景色
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.frame_layout, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                    dialog();//dialog的显示
                break;
            case R.id.radio_pandalive:
                state();//底部按钮的背景色
                if (pandaLiveFragment == null) {
                    pandaLiveFragment = new PandaLiveFragment();
                    transaction.add(R.id.frame_layout, pandaLiveFragment);
                } else {
                    transaction.show(pandaLiveFragment);
                }
                btn_pandalive.setBackgroundResource(R.color.huise);
                dialog();//dialog的显示
                break;
            case R.id.radio_rollrollvideo:
                state();//底部按钮的背景色
                if (rollFragment == null) {
                    rollFragment = new RollFragment();
                    transaction.add(R.id.frame_layout, rollFragment);
                } else {
                    transaction.show(rollFragment);
                }
                dialog();//dialog的显示
                break;
            case R.id.radio_pandabroad:
                state();//底部按钮的背景色
                if (broadFragment == null) {
                    broadFragment = new BroadFragment();
                    transaction.add(R.id.frame_layout, broadFragment);
                } else {
                    transaction.show(broadFragment);
                }
                dialog();//dialog的显示
                break;
            case R.id.radio_livechina:
                state();//底部按钮的背景色
                if (liveChinaFragment == null) {
                    liveChinaFragment = new LiveChinaFragment();
                    transaction.add(R.id.frame_layout, liveChinaFragment);
                } else {
                    transaction.show(liveChinaFragment);
                }
                dialog();   //dialog的显示
                break;
        }

        transaction.commit();
    }

    public void state() {

        if (btn_home.isChecked()) {

            btn_home.setBackgroundResource(R.color.huise);
        } else {
            btn_home.setBackgroundResource(R.color.white_fafaf8);
        }

        if (btn_pandalive.isChecked()) {

            btn_pandalive.setBackgroundResource(R.color.huise);
        } else {
            btn_pandalive.setBackgroundResource(R.color.white_fafaf8);
        }

        if (btn_roll.isChecked()) {

            btn_roll.setBackgroundResource(R.color.huise);
        } else {
            btn_roll.setBackgroundResource(R.color.white_fafaf8);
        }

        if (btn_broad.isChecked()) {

            btn_broad.setBackgroundResource(R.color.huise);
        } else {
            btn_broad.setBackgroundResource(R.color.white_fafaf8);
        }

        if (btn_livechina.isChecked()) {

            btn_livechina.setBackgroundResource(R.color.huise);
        } else {
            btn_livechina.setBackgroundResource(R.color.white_fafaf8);
        }
    }

    public void dialog() {

        if (catLoadingView != null) {
            catLoadingView.show(getSupportFragmentManager(), "deserve");
            catLoadingView.setCancelable(false);
        } else {
            catLoadingView = new CatLoadingView();
            catLoadingView.show(getSupportFragmentManager(), "deserve");
            catLoadingView.setCancelable(false);
        }

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                catLoadingView.dismiss();
            }
        }, 2000);
    }

}
