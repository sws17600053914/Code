package com.example.admin.myapplication.module.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.model.bean.HomeDataBean;
import com.example.admin.myapplication.module.home.items.HomeAdapter;
import com.example.admin.myapplication.module.interact.Share_it_Activity;
import com.example.admin.myapplication.module.person.PersonActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 14:21
 * 作 者：T
 * 微信：704003376
 */

public class HomeFragment extends BaseFragment implements HomeContract.HomeView {

    Unbinder unbinder;
    ArrayList<HomeDataBean.DataBean.PandaliveBean.ListBean> list = new ArrayList<>();
    //TODO mHomePresenter未初始化
    private HomeContract.HomePresenter mHomePresenter;
    private XRecyclerView xRecyclerView;


    @Override
    public void setPresenter(HomeContract.HomePresenter presenter) {

        mHomePresenter = presenter;
    }

    @Override
    public void setResultData(HomeDataBean bean) {
        final HomeAdapter adapter = new HomeAdapter(getContext(),bean);
        xRecyclerView.setAdapter(adapter);
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        sgm.setOrientation(StaggeredGridLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(sgm);
        xRecyclerView.setLoadingMoreEnabled(false);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        getActivity().runOnUiThread(
                                new Runnable() {
                            @Override
                            public void run() {
                                xRecyclerView.refreshComplete();
                            }
                        });
                    }
                },1000);

            }

            @Override
            public void onLoadMore() {
            }
        });
    }

    @Override
    protected void initData() {
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.start();
        Log.e("TAG", "initData: ");
        //通过P层处理相关业务逻辑
//        homeGridview1.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initView(View view) {
        Log.e("TAG", "initView: ");
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.home_xrecyclerview);
        view.findViewById(R.id.home_gerenzhongxin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonActivity.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.home_sign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), Share_it_Activity.class);
                startActivity(intent1);
            }
        });

    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

    @OnClick({R.id.home_biaoti11, R.id.home_biaoti22})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_biaoti11:
                break;
            case R.id.home_biaoti22:
                break;
        }
    }
}
