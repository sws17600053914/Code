package com.example.admin.myapplication.module.RollRoll_video;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.model.bean.RollRollVideoBean;
import com.example.admin.myapplication.module.RollRoll_video.activity.RollActivity;
import com.example.admin.myapplication.module.RollRoll_video.activity.RollItemActivity;
import com.example.admin.myapplication.module.RollRoll_video.adapter.RollAdapter;
import com.example.admin.myapplication.module.person.PersonActivity;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;




public class RollFragment extends BaseFragment implements RollContract.RollView {

    private RollContract.RollPresenter rollContract;
    private ImageView imageView;
    private XRecyclerView xRecyclerView;
    private ArrayList<RollRollVideoBean.ListBean> strings = new ArrayList<>();
    private RollAdapter adapter;
    private ImageView imageView1;
    private ImageView image;

    @Override
    public void setPresenter(RollContract.RollPresenter rollPresenter) {
        rollContract = rollPresenter;
    }

    @Override
    protected void initData() {

        //通过P层处理相关业务逻辑
        rollContract = new RollPresenter(this);
        rollContract.start();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);

        xRecyclerView.setRefreshProgressStyle(ProgressStyle.SysProgress);
        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        xRecyclerView.addItemDecoration(new RecyclerDivider(getActivity(), RecyclerDivider.VERTICAL_LIST));

        View header = LayoutInflater.from(getActivity()).inflate(R.layout.xrecycler_image, null);
        imageView1 = (ImageView) header.findViewById(R.id.xrecycler_img);

        xRecyclerView.addHeaderView(header);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        adapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                        xRecyclerView.setLoadingMoreEnabled(true);
                    }

                }, 1000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
//                       Toast.makeText(getActivity(), "天啊，没有更多数据了", Toast.LENGTH_SHORT).show();
//                        adapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                        xRecyclerView.setLoadingMoreEnabled(true);
                    }
                }, 1);
            }
        });


        adapter = new RollAdapter(getActivity(), strings);
        xRecyclerView.setAdapter(adapter);

    }

    @Override
    protected void initView(View view) {
        image = (ImageView) view.findViewById(R.id.roll_person);

        imageView = (ImageView) view.findViewById(R.id.roll_image);
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.roll_reycler);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_rollroll;
    }

    @Override
    public void setResultData(final RollRollVideoBean resultData) {
        strings.addAll(resultData.getList());
        Glide.with(getActivity()).load(resultData.getBigImg().get(0).getImage()).into(imageView1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RollActivity.class);
                intent.putExtra("url", resultData.getBigImg().get(0).getUrl());
                intent.putExtra("title", resultData.getBigImg().get(0).getTitle());
                startActivity(intent);
            }
        });
        adapter.setOnClick(new RollAdapter.setOnClick() {
            @Override
            public void setClick(int position) {
                Intent intent = new Intent(getActivity(), RollItemActivity.class);
                intent.putExtra("id", resultData.getList().get(position).getId());
                startActivity(intent);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PersonActivity.class);

                startActivity(intent);

            }
        });
    }
}
