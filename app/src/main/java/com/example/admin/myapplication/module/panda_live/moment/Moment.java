package com.example.admin.myapplication.module.panda_live.moment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.WonderfulBean;
import com.example.admin.myapplication.utils.RecycleViewDivider;
import com.example.admin.myapplication.utils.VideoPlayActivity;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;


/**
 * Created by Administrator on 2017/7/19.
 */

public class Moment extends BaseFragment implements MomentContract.MomentView{
    private XRecyclerView recycle;
    private MomentContract.MomentPresenter mPresenter;
    @Override
    protected void initData() {
        mPresenter=new MomentPresenter(this);
        mPresenter.start();
    }

    @Override
    protected void initView(View view) {
        recycle= (XRecyclerView) view.findViewById(R.id.recycle);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.moment;
    }

    @Override
    public void setResultData(WonderfulBean wonderfulBean) {
        // 获取数据
        final List<WonderfulBean.ListBean> list = wonderfulBean.getList();
        // 设置manager
        LinearLayoutManager manager = new LinearLayoutManager(MyApp.mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
        // 设置适配器
        final MomentAdapter momentAdapter = new MomentAdapter(MyApp.mContext, list);
        recycle.setAdapter(momentAdapter);
        // 添加分割线
        recycle.addItemDecoration(new RecycleViewDivider(MyApp.mContext, LinearLayoutManager.VERTICAL, R.drawable.divider_mileage));
//        // 设置可刷新
//        recycle.setPullRefreshEnabled(true);
        // 设置可加载
        recycle.setLoadingMoreEnabled(true);
        recycle.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        // 设置刷新箭头图标
        recycle.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        // 设置加载监听
        recycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                momentAdapter.notifyDataSetChanged();
                recycle.refreshComplete();
            }

            @Override
            public void onLoadMore() {

                momentAdapter.notifyDataSetChanged();
                recycle.loadMoreComplete();
            }
        });
        momentAdapter.setSetMyClick(new MomentAdapter.SetMyClick() {
            @Override
            public void myClick(int pos) {
                Intent intent = new Intent(MyApp.mContext, VideoPlayActivity.class);
                intent.putExtra("url",list.get(pos).getUrl());
                intent.putExtra("title",list.get(pos).getTitle());
                MyApp.mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void setPresenter(MomentContract.MomentPresenter momentPresenter) {
        mPresenter=momentPresenter;
    }
}
