package com.example.admin.myapplication.module.panda_live.moment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;


import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.WonderfulBean;
import com.example.admin.myapplication.utils.RecycleViewDivider;
import com.example.admin.myapplication.utils.VideoPlayActivity;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/7/19.
 */

public class Moment extends BaseFragment implements MomentContract.MomentView {
    private XRecyclerView recycle;
    private MomentContract.MomentPresenter mPresenter;
    private ArrayList<String> arrlist = new ArrayList<>();
    private MomentAdapter momentAdapter;
    private ArrayList<WonderfulBean.VideoBean> mList;
    private String id;
    private ArrayList<String> urls=new ArrayList<>();
    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        id = bundle.getString("id", null);
        mPresenter = new MomentPresenter(this, id);
        mPresenter.start();
    }

    @Override
    protected void initView(View view) {
        mList = new ArrayList<>();
        recycle = (XRecyclerView) view.findViewById(R.id.recycle);
        initAdapter();
    }

    private void initAdapter() {
        // 设置manager
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(manager);
        // 设置一些recyclerview的属性
        recycle.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, R.drawable.divider_mileage));
        recycle.setLoadingMoreEnabled(true);
        recycle.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recycle.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        // 设置监听
        recycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mList.clear();
                mPresenter.start();
                recycle.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                momentAdapter.notifyDataSetChanged();
                recycle.loadMoreComplete();
            }
        });
        momentAdapter = new MomentAdapter(getActivity(), mList);
        recycle.setAdapter(momentAdapter);

        momentAdapter.setSetMyClick(new MomentAdapter.SetMyClick() {
            @Override
            public void myClick(int pos) {

                Intent intent = new Intent(MyApp.mContext, VideoPlayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("arrlist", arrlist);
                bundle.putStringArrayList("urls",urls);
                bundle.putInt("position", pos);
                bundle.putSerializable("bean",mList);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);

            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.moment;
    }



    @Override
    public void setResultData(WonderfulBean wonderfulBean) {
        List<WonderfulBean.VideoBean> list = wonderfulBean.getVideo();

        list.get(1).getEm();
        if (list != null) {
            mList.addAll(list);
            momentAdapter.notifyDataSetChanged();
        }
        String url="";
        for (int i = 0; i < list.size(); i++) {
            String t = list.get(i).getT();
            arrlist.add(t);

            String substring = mList.get(i).getPtime().substring(0, 10).replace("-", "/");

            if (id.equals("VSET100340574858")) {
                url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/" + substring + "/" + mList.get(i).getVid() + "_h264418000nero_aac32-1.mp4";
            } else {
                if (id.equals("VSET100272959126")) {
                    url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video59/TMS/" + substring + "/" + mList.get(i).getVid() + "_h264418000nero_aac32.mp4";
                } else {
                    if (id.equals("VSET100237714751")) {
                        url = "http://vod.cntv.lxdns.com/flash/mp4video60/TMS/" + substring + "/" + mList.get(i).getVid() + "_h264418000nero_aac32.mp4";
                    } else {
                        if (id.equals("VSET100167308855")) {
                            url = "http://vod.cntv.lxdns.com/flash/mp4video60/TMS/" + substring + "/" + mList.get(i).getVid() + "_h264418000nero_aac32-1.mp4";
                        } else {
                            url = "http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/" + substring + "/" + mList.get(i).getVid() + "_h264418000nero_aac32.mp4";
                        }
                    }
                }
                urls.add(url);
            }

        }
    }

    @Override
    public void setPresenter(MomentContract.MomentPresenter momentPresenter) {
        mPresenter = momentPresenter;
    }

}
