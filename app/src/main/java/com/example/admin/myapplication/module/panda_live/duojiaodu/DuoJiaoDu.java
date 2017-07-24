package com.example.admin.myapplication.module.panda_live.duojiaodu;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.MultiBean;
import com.example.admin.myapplication.utils.MyGridView;

import java.util.List;

/**
 * Created by ${马志武} on 2017/7/20.
 */

public class DuoJiaoDu extends BaseFragment implements DuoJiaoDuContract.DuoJiaoDuView{
    private DuoJiaoDuContract.DuoJiaoDuPresnetr mPresnetr;
    private MyGridView gridView;

    @Override
    protected void initData() {
        mPresnetr=new DuoJiaoDuPresenter(this);
        mPresnetr.start();
    }

    @Override
    protected void initView(View view) {
        gridView= (MyGridView) view.findViewById(R.id.gridview);
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.duojiaodu;
    }

    @Override
    public void setPresenter(DuoJiaoDuContract.DuoJiaoDuPresnetr duoJiaoDuPresnetr) {
        mPresnetr=duoJiaoDuPresnetr;
    }

    @Override
    public void setResultData(MultiBean multiBean) {
        List<MultiBean.ListBean> list = multiBean.getList();
        GridViewAdapter gridViewAdapter = new GridViewAdapter(getActivity(),list);
        gridView.setAdapter(gridViewAdapter);
        initGridListener(list);
    }

    private void initGridListener(final List<MultiBean.ListBean>  list) {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = list.get(position).getTitle();
                Intent intent=new Intent();
                intent.putExtra("title",title);
                intent.setAction("com.com.com");
                MyApp.mContext.sendBroadcast(intent);
            }
        });
    }

}
