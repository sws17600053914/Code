package com.example.admin.myapplication.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.LiveChina.LiveChinaFragment;
import com.example.admin.myapplication.module.RollRoll_video.RollFragment;
import com.example.admin.myapplication.module.home.HomeFragment;
import com.example.admin.myapplication.module.panda_Broad.BroadFragment;
import com.example.admin.myapplication.module.panda_live.PandaLiveFragment;

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
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //锄禾日当午，汗滴禾下土.
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
                state();
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.frame_layout, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case R.id.radio_pandalive:
                state();
                if (pandaLiveFragment == null) {
                    pandaLiveFragment = new PandaLiveFragment();
                    transaction.add(R.id.frame_layout, pandaLiveFragment);
                } else {
                    transaction.show(pandaLiveFragment);
                }
                btn_pandalive.setBackgroundResource(R.color.huise);
                break;
            case R.id.radio_rollrollvideo:
                state();
                if (rollFragment == null) {
                    rollFragment = new RollFragment();
                    transaction.add(R.id.frame_layout, rollFragment);
                } else {
                    transaction.show(rollFragment);
                }
                break;
            case R.id.radio_pandabroad:
                state();
                if (broadFragment == null) {

                    broadFragment = new BroadFragment();

                    transaction.add(R.id.frame_layout, broadFragment);
                } else {
                    transaction.show(broadFragment);
                }
                break;
            case R.id.radio_livechina:
                state();
                if (liveChinaFragment == null) {

                    liveChinaFragment = new LiveChinaFragment();

                    transaction.add(R.id.frame_layout, liveChinaFragment);
                } else {
                    transaction.show(liveChinaFragment);
                }
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
}
