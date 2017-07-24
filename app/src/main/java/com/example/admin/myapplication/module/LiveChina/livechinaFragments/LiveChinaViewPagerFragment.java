package com.example.admin.myapplication.module.LiveChina.livechinaFragments;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.model.bean.BaDaLingBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * Created by lenovo on 2017/7/19.
 */

public class LiveChinaViewPagerFragment extends BaseFragment implements LiveChinaFragmentContract.LiveChinaFragmentView{
    private LiveChinaFragmentContract.LiveChinaFragmentViewPresenter liveChinaFragmentViewPresenter;
    @BindView(R.id.livechina_xrecycleview)
    XRecyclerView livechinaXrecycleview;
    Unbinder unbinder;
    private List<BaDaLingBean.LiveBean> live=new ArrayList<>();
    private LiveChinaFragmentsAdapter adapter;
    private String url;

    public LiveChinaViewPagerFragment(String url){
        this.url=url;
    };

    @Override
    public void setPresenter(LiveChinaFragmentContract.LiveChinaFragmentViewPresenter liveChinaFragmentViewPresenter) {
        this.liveChinaFragmentViewPresenter=liveChinaFragmentViewPresenter;
        liveChinaFragmentViewPresenter.getUrl(url);
    }
    @Override
    protected void initData() {

        liveChinaFragmentViewPresenter= (LiveChinaFragmentContract.LiveChinaFragmentViewPresenter) new LiveChinaFragmentPresenter(this);
        //通过P层处理相关业务逻辑
        liveChinaFragmentViewPresenter.start();

        LinearLayoutManager xLinearLayoutManager = new LinearLayoutManager(getActivity());
        livechinaXrecycleview.setLayoutManager(xLinearLayoutManager);
        adapter = new LiveChinaFragmentsAdapter(getActivity(),live);
        livechinaXrecycleview.setAdapter(adapter);

        livechinaXrecycleview.setLoadingMoreEnabled(false);
        livechinaXrecycleview.setLoadingListener(new XRecyclerView.LoadingListener() {


            //XrecyclerView刷新方法
            @Override
            public void onRefresh() {

                adapter.notifyDataSetChanged();

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                livechinaXrecycleview.refreshComplete();
                            }
                        });
                    }
                },1000);

            }
            //XrecyclerView加载方法
            @Override
            public void onLoadMore() {

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {

                                livechinaXrecycleview.refreshComplete();
                            }
                        });
                    }
                },0);
            }
        });

    }

    @Override
    protected void initView(View view) {
        livechinaXrecycleview= (XRecyclerView) view.findViewById(R.id.livechina_xrecycleview);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_livechina_viewpagers;
    }


    @Override
    public void setResultData(BaDaLingBean dataBean) {
        live.clear();
        live.addAll(dataBean.getLive());

        adapter.notifyDataSetChanged();

    }


}
