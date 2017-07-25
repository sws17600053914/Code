package com.example.admin.myapplication.module.person.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.module.user.User;
import com.example.admin.myapplication.module.user.UserDao;
import com.example.admin.myapplication.userAdapter.UserAdapter;

import java.util.List;


/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/20 0020.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 */


public class BestViews extends BaseFragment {

    private ListView mListView;
    private ImageView image;
    private UserAdapter adapter;
    private User user;

    @Override
    protected void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.listview_bestview);
        image = (ImageView) view.findViewById(R.id.image_bestview);
    }

    @Override
    protected void initData() {

        UserDao userDao = MyApp.getUserDao();

        final List<User> lists = userDao.queryBuilder().where(UserDao.Properties.Id.between(0, 999)).build().list();

        if (lists.size() > 0){
            image.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
            adapter = new UserAdapter(getActivity(),lists);
            mListView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else {
            image.setVisibility(View.VISIBLE);
            mListView.setVisibility(View.GONE);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserDao userDao = MyApp.getUserDao();
                 List<User> list = userDao.queryBuilder().where(UserDao.Properties.Id.between(0, 999)).build().list();
                for (int i = 0; i < list.size(); i++){
                    user = list.get(position);
                }
                userDao.delete(user);
                lists.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.bestviews_fragment;
    }
}
