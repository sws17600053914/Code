package com.example.admin.myapplication.module.LiveChina;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseFragment;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.LiveChinaBean;
import com.example.admin.myapplication.module.LiveChina.livechinaFragments.LiveChinaViewPagerFragment;
import com.example.admin.myapplication.module.person.PersonActivity;
import com.example.admin.myapplication.utils.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;



/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.LiveChinaView {


    ImageView livechinaPersoncenter;
    @BindView(R.id.livechina_tablayout)
    TabLayout livechinaTablayout;
    @BindView(R.id.livechina_add)
    ImageView livechinaAdd;
    @BindView(R.id.livechina_viewpager)
    NoScrollViewPager livechinaViewpager;
    Unbinder unbinder;
    //TODO mHomePresenter未初始化
    private LiveChinaContract.LiveChinaViewPresenter liveChinaViewPresenter;
    private ArrayList<Fragment> fragments= new ArrayList<>();;
    private ArrayList<String> strings= new ArrayList<>();;
    private LiveChinaAdapter adapter;
    LiveChinaBean dataBean;
    boolean aBoolean=true;
    private ImageView image_person;

    @Override
    public void setPresenter(LiveChinaContract.LiveChinaViewPresenter liveChinaViewPresenter) {

        this.liveChinaViewPresenter = liveChinaViewPresenter;
    }


    @Override
    protected void initData() {
        Log.e("TAG", "initData: ");
        liveChinaViewPresenter=new LiveChinaPresenter(this);
        //通过P层处理相关业务逻辑

            liveChinaViewPresenter.start();



        adapter = new LiveChinaAdapter(this.getChildFragmentManager(), fragments,strings);
        livechinaViewpager.setAdapter(adapter);
        livechinaTablayout.setupWithViewPager(livechinaViewpager);


    }

    @Override
    protected void initView(View view) {
        Log.e("TAG", "initView: ");
        image_person = (ImageView) view.findViewById(R.id.liveChina_gerenzhongxin);

        livechinaTablayout= (TabLayout) view.findViewById(R.id.livechina_tablayout);
        livechinaAdd= (ImageView) view.findViewById(R.id.livechina_add);
        livechinaViewpager= (NoScrollViewPager) view.findViewById(R.id.livechina_viewpager);

        image_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), PersonActivity.class);

                startActivity(intent);
            }

        });

        livechinaAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),LiveChinaAddActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_livechina;
    }

    @Override
    public void setResultData(LiveChinaBean dataBean) {
        //更新UI
        this.dataBean=dataBean;
        Log.e("TAG", "setResultData: ");
        List<LiveChinaBean.AlllistBean> alllist = dataBean.getAlllist();
        List<LiveChinaBean.TablistBean> tablist = dataBean.getTablist();
        ArrayList<String> list=new ArrayList<>();
        Log.e("YAHHHHHH", "setResultData: "+ MyApp.mLists.size() );

        if(MyApp.mLists.size()<=0){
//            aBoolean=false;
            for (int i = 0; i < dataBean.getTablist().size(); i++) {
                fragments.add(new LiveChinaViewPagerFragment(dataBean.getTablist().get(i).getUrl()));
                strings.add(dataBean.getTablist().get(i).getTitle());
                MyApp.mLists.add(dataBean.getTablist().get(i).getTitle());



            }
            for (int j = 0; j < dataBean.getAlllist().size(); j++) {
//                list.add(dataBean.getAlllist().get(j).getTitle());
                MyApp.mListx.add(dataBean.getAlllist().get(j).getTitle());
            }

            for (int i = 0; i < 5; i++) {
                MyApp.mListx.remove(dataBean.getTablist().get(i).getTitle());
                Log.e("YAHHHHHH", "setResultData: "+i );
            }



//            for (int i = 0; i < list.size(); i++) {
//                for (int j = 0; j < 5; j++) {
//                    if (list.get(i).toString().equals(MyApp.mLists.get(j).toString())) {
//                        list.remove(i);
//                        Log.e("YHAHH", "531313");
//                    } else {
//                        if(j<1){
//                            Log.e("YHAHH", "" + i);
//                            MyApp.mListx.add(list.get(i).toString());
//                        }
//                    }
//                }
//            }

            adapter.notifyDataSetChanged();
        }else {
//            for (int i = 0; i < MyApp.mLists.size(); i++) {
//                fragments.add(new LiveChinaViewPagerFragment(dataBean.getAlllist().get(i).getUrl()));
//                strings.add(dataBean.getTablist().get(i).getTitle());
//            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0&&resultCode==200) {
            strings.clear();
            fragments.clear();
            aBoolean=false;
            strings.addAll(MyApp.mLists);
            for (int i = 0; i < strings.size(); i++) {
                for (int j = 0; j < dataBean.getAlllist().size(); j++) {
                    if(strings.get(i).toString().equals(dataBean.getAlllist().get(j).getTitle().toString())){
                        fragments.add(new LiveChinaViewPagerFragment(dataBean.getAlllist().get(j).getUrl()));
                    }
                }
            }
            initData();
        }
    }
}
