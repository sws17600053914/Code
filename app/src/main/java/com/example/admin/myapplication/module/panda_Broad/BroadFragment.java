package com.example.admin.myapplication.module.panda_Broad;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.PandaBroadBean;
import com.example.admin.myapplication.model.bean.PandaBroadTwoBean;
import com.example.admin.myapplication.module.panda_Broad.Activity.BroadDetail_TopActivity;
import com.example.admin.myapplication.module.person.PersonActivity;
import com.jcodecraeer.xrecyclerview.ArrowRefreshHeader;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public class BroadFragment extends BaseFragment implements BroadContract.BroadView {
    //TODO mHomePresenter未初始化

    private BroadContract.BroadPresenter broadPresenter;

    private XRecyclerView mXRecyclerView;

    private ImageView mImage;

    private List<PandaBroadBean.ListBean> mList;
    private TextView tv_broad_;
    private List<PandaBroadBean.ListBean> list;
    private AdapterXRecyclerView adapterXRecyclerView;
    private int i = 2;

    @Override
    public void setPresenter(BroadContract.BroadPresenter broadPresenter) {

        this.broadPresenter = broadPresenter;
    }

    @Override
    protected void initView(View view) {
        mList = new ArrayList<>();

        ImageView image_persion = (ImageView) view.findViewById(R.id.image_persion);

        image_persion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PersonActivity.class);

                startActivity(intent);
            }
        });


        View inflate_deader = LayoutInflater.from(getActivity()).inflate(R.layout.layout_header, null);

        mImage = (ImageView) inflate_deader.findViewById(R.id.image_broad_);

        tv_broad_ = (TextView) inflate_deader.findViewById(R.id.tv_broad_);

        mXRecyclerView = (XRecyclerView) view.findViewById(R.id.listview_broad);

        mXRecyclerView.addHeaderView(inflate_deader);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mXRecyclerView.setLayoutManager(linearLayoutManager);

        mXRecyclerView.setRefreshHeader(new ArrowRefreshHeader(MyApp.mContext));

        mXRecyclerView.setLoadingMoreEnabled(true);

        mXRecyclerView.setArrowImageView(R.drawable.xlistview_arrow);

        initDataXRecycler();

        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {


            //XrecyclerView刷新方法
            @Override
            public void onRefresh() {

                mList.clear();
                broadPresenter.start();
                adapterXRecyclerView.notifyDataSetChanged();

                SharedPreferences sharedPreferences = MyApp.mContext.getSharedPreferences("Deserve.db", MyApp.mContext.MODE_PRIVATE);

                SharedPreferences.Editor edit = sharedPreferences.edit();

                edit.putInt("page", 1);

                edit.apply();

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mXRecyclerView.refreshComplete();
                            }
                        });
                    }
                }, 1000);

            }

            //XrecyclerView加载方法
            @Override
            public void onLoadMore() {

                Timer timer = new Timer();

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Deserve.db", getActivity().MODE_PRIVATE);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putInt("page", i);
                        edit.apply();
                        i++;
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (broadPresenter != null) {
                                    broadPresenter.start();
                                    Toast.makeText(getActivity(), "加载完成了", Toast.LENGTH_SHORT).show();
                                    mXRecyclerView.loadMoreComplete();
                                }
                            }
                        });
                    }
                }, 2000);
            }
        });

    }

    @Override
    public void setResultData(final PandaBroadTwoBean pandaBroadBean) {

        //获取到数据将Image传入
        Log.e("deserve", "setResultData: " + pandaBroadBean.getData().getBigImg().size());

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Glide.with(getActivity()).load(pandaBroadBean.getData().getBigImg().get(0).getImage()).into(mImage);

                    tv_broad_.setText(pandaBroadBean.getData().getBigImg().get(0).getTitle());
                }
            });

            mImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getActivity(), BroadDetail_TopActivity.class);

                    intent.putExtra("url_top","http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/07/20/429732b855b24e95ad208807174eb85c_h2641200000nero_aac16-1.mp4");

                    intent.putExtra("title_top", pandaBroadBean.getData().getBigImg().get(0).getTitle());

                    startActivity(intent);

                }
            });
    }

    //展示ListView数据
    @Override
    public void setPandaBroadListViewDta(PandaBroadBean pandaBroadListViewDta) {

        list = pandaBroadListViewDta.getList();

        if (list != null){

            mList.addAll(list);

            adapterXRecyclerView.notifyDataSetChanged();
        }
    }

    private void initDataXRecycler() {

        adapterXRecyclerView = new AdapterXRecyclerView(getActivity(), mList);

        mXRecyclerView.setAdapter(adapterXRecyclerView);

        adapterXRecyclerView.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

        //通过P层处理相关业务逻辑

        broadPresenter = new BroadPresenter(this);

        broadPresenter.start();

    }

    @Override
    public int getFragmentLayoutId() {

        return R.layout.fragment_broadpanda;
    }

    @Override
    public void onStart() {
        super.onStart();
        final ProgressDialog dialog = new ProgressDialog(getActivity());

        dialog.show();

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                dialog.dismiss();
            }
        },2000);
    }
}
