package com.example.admin.myapplication.module.interact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.model.bean.OriginalBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

//分享
public class Share_it_Activity extends BaseActivity implements OriginalContract.OriginalView{

    private MyXrecyclerviewAdapter myAdapter;
    private XRecyclerView xrecyclerview;

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_share_it;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        OriginalPresenter originalPresenter=new OriginalPresenter(this);
        originalPresenter.start();
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }



    @Override
    public void setResultData(OriginalBean originalBean) {
        xrecyclerview = (XRecyclerView) findViewById(R.id.xrecycler);
        final List<OriginalBean.InteractiveBean> list = originalBean.getInteractive();
        xrecyclerview.setLayoutManager(new LinearLayoutManager(Share_it_Activity.this));

        myAdapter = new MyXrecyclerviewAdapter(this,list);
        xrecyclerview.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyXrecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void OnItemclick(int pos) {
                Intent intent=new Intent(Share_it_Activity.this,Share_it_item_Activity.class);
                Log.e("tag", list.get(pos).getUrl()+"");
                Log.e("tag", list.get(pos).getTitle()+"");
                intent.putExtra("url",list.get(pos).getUrl());
                intent.putExtra("title",list.get(pos).getTitle());
                startActivity(intent);
            }
        });

    }

    @Override
    public void setPresenter(OriginalContract.OriginalPresenter originalPresenter) {

    }
}
