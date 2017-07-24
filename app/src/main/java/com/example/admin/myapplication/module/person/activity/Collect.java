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
import com.example.admin.myapplication.module.person.fragment.BestViews;
import com.example.admin.myapplication.module.person.fragment.LiveTelecast;
import com.example.admin.myapplication.module.person.fragment.PhoneRegister;
import com.zhy.android.percent.support.PercentFrameLayout;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/19 0019.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 个人中心  我的收藏
 */
public class Collect extends BaseActivity {


    @BindView(R.id.collect_back)
    ImageView collectBack;
    @BindView(R.id.livea)
    Button live;
    @BindView(R.id.best_views)
    Button bastViews;
    @BindView(R.id.register_tab)
    PercentLinearLayout registerTab;
    @BindView(R.id.collet_one)
    TextView colletOne;
    @BindView(R.id.collet_two)
    TextView colletTwo;
    @BindView(R.id.collect_frament)
    PercentFrameLayout collectFrament;

    BestViews bestViews;
    LiveTelecast liveTelecast;

    @Override
    protected void initView() {
        colletOne.setBackgroundColor(Color.parseColor("#3565a6"));
        colletTwo.setBackgroundColor(Color.parseColor("#ffffff"));

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_collect;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.collect_frament,new PhoneRegister());
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (liveTelecast != null) {

            transaction.hide(liveTelecast);
        }
        if (bestViews != null) {

            transaction.hide(bestViews);
        }


    }

    @OnClick({R.id.collect_back, R.id.livea, R.id.best_views})
    public void onViewClicked(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        hideFragment(transaction);
        switch (view.getId()) {
            case R.id.collect_back:
                finish();
                break;
            case R.id.livea:
                colletOne.setBackgroundColor(Color.parseColor("#3565a6"));
                colletTwo.setBackgroundColor(Color.parseColor("#ffffff"));
                if (liveTelecast == null) {

                    liveTelecast = new LiveTelecast();

                    transaction.add(R.id.collect_frament, liveTelecast);

                } else {
                    transaction.show(liveTelecast);
                }


                break;
            case R.id.best_views:
                colletTwo.setBackgroundColor(Color.parseColor("#3565a6"));
                colletOne.setBackgroundColor(Color.parseColor("#ffffff"));
                if (bestViews == null) {

                    bestViews = new BestViews();

                    transaction.add(R.id.collect_frament, bestViews);

                } else {
                    transaction.show(bestViews);
                }
                break;
        }
        transaction.commit();
    }
}
