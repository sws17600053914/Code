package com.example.admin.myapplication.module.home.items;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.model.bean.HomeDataBean;
import com.example.admin.myapplication.module.home.China_Adapter;
import com.example.admin.myapplication.module.home.GunGun_bean;
import com.example.admin.myapplication.module.home.HomeGridView2_Adapter;
import com.example.admin.myapplication.module.home.HomeGridView_Adapter;
import com.example.admin.myapplication.module.home.HomeListview_Adapter;
import com.example.admin.myapplication.module.home.JiecaoViod;
import com.example.admin.myapplication.module.home.MyGridView;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;
import com.example.admin.myapplication.utils.GlideImageLoadar;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by C on 2017/7/19.
 */

public class HomeAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private final int TYPE_VP = 0;
    private final int BOBAO_VP = 1;
    private final int ZHIBO_VP = 2;
    private final int JINGCAI_VP = 3;
    private final int GUNGUN_VP = 4;
    private final int CHINA_VP = 5;
    private VpHolder vpHolder;
    private BobaoHolder bobaoHolder;
    private ZhiboHoler zhiboHoler;
    private JingcaiHolder jingcaiHolder;
    private GunGunHolder gunGunHolder;
    private ChinaHolder chinaHolder;
    private Banner banner;
    private Context context;
    private HomeDataBean bean;
    private ImageView img;
    private TextView biaoti1, neirong1, biaoti2, neirong2;
    private MyGridView myGridView, myGridView2, myGridView3;
    private ListView listView;
    private GunGun_bean news;
    private Boolean aBoolean = true;
    ArrayList<HomeDataBean.DataBean.PandaliveBean.ListBean> list = new ArrayList<>();

    public HomeAdapter(Context context, HomeDataBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        if (viewType == TYPE_VP) {
            View view = LayoutInflater.from(context).inflate(R.layout.lunbo_item, parent, false);
            vpHolder = new VpHolder(view);
            banner = (Banner) view.findViewById(R.id.mybanner);
            banner.setOnBannerListener(new OnBannerListener() {

                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context, "轮播点击事件" + position, Toast.LENGTH_SHORT).show();
                }
            });
            return vpHolder;
        }
            if (viewType == BOBAO_VP) {
            final View view = LayoutInflater.from(context).inflate(R.layout.bobao_item, parent, false);
            bobaoHolder = new BobaoHolder(view);
            img = (ImageView) view.findViewById(R.id.home_img);
            biaoti1 = (TextView) view.findViewById(R.id.home_biaoti);
            neirong1 = (TextView) view.findViewById(R.id.home_biaoti11);
            biaoti2 = (TextView) view.findViewById(R.id.home_biaoti2);
            neirong2 = (TextView) view.findViewById(R.id.home_biaoti22);
            neirong1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyApp.mContext, JiecaoViod.class);
                    MyApp.mContext.startActivity(intent);
                }
            });
            neirong2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyApp.mContext, JiecaoViod.class);
                    MyApp.mContext.startActivity(intent);
                }
            });
            return bobaoHolder;
        }

        if (viewType == ZHIBO_VP) {
            View view = LayoutInflater.from(context).inflate(R.layout.zhibo_item, parent, false);
            zhiboHoler = new ZhiboHoler(view);
            myGridView = (MyGridView) view.findViewById(R.id.home_gridview1);
            myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    position = position + 1;
                    Toast.makeText(context, "直播频道" + position, Toast.LENGTH_SHORT).show();
                }
            });
            return zhiboHoler;
        }
        if (viewType == JINGCAI_VP) {
            View view = LayoutInflater.from(context).inflate(R.layout.jingcai_item, parent, false);
            jingcaiHolder = new JingcaiHolder(view);
            myGridView2 = (MyGridView) view.findViewById(R.id.home_gridview2);
            return jingcaiHolder;
        }
        if (viewType == GUNGUN_VP) {
            View view = LayoutInflater.from(context).inflate(R.layout.gungun, parent, false);
            gunGunHolder = new GunGunHolder(view);
            listView = (ListView) view.findViewById(R.id.gungun_listview);
            return gunGunHolder;
        }
        if (viewType == CHINA_VP) {
            View view = LayoutInflater.from(context).inflate(R.layout.china, parent, false);
            chinaHolder = new ChinaHolder(view);
            myGridView3 = (MyGridView) view.findViewById(R.id.home_gridview3);
            return chinaHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        //轮播
        if (position == TYPE_VP) {
            List<String> imaglist = new ArrayList<>();
            imaglist.add(bean.getData().getArea().getListscroll().get(0).getImage());
            imaglist.add(bean.getData().getArea().getListscroll().get(1).getImage());
            imaglist.add(bean.getData().getArea().getListscroll().get(2).getImage());
            imaglist.add(bean.getData().getArea().getListscroll().get(3).getImage());
            Log.e("图片", imaglist.toString());
            List<String> textlist = new ArrayList<>();
            textlist.add(bean.getData().getArea().getListscroll().get(0).getTitle());
            textlist.add(bean.getData().getArea().getListscroll().get(1).getTitle());
            textlist.add(bean.getData().getArea().getListscroll().get(2).getTitle());
            textlist.add(bean.getData().getArea().getListscroll().get(3).getTitle());
            banner.update(imaglist, textlist);
            banner.isAutoPlay(true);
            banner.setImageLoader(new GlideImageLoadar());
            banner.setDelayTime(3000);
            banner.setIndicatorGravity(BannerConfig.LEFT);
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            banner.start();
        }
        // 熊猫播报
        if (position == BOBAO_VP) {
            Glide.with(context).load(bean.getData().getPandaeye().getPandaeyelogo()).into(img);
            biaoti1.setText(bean.getData().getPandaeye().getItems().get(0).getBrief());
            neirong1.setText(bean.getData().getPandaeye().getItems().get(0).getTitle());
            biaoti2.setText(bean.getData().getPandaeye().getItems().get(1).getBrief());
            neirong2.setText(bean.getData().getPandaeye().getItems().get(1).getTitle());
        }
        //直播秀场
        if (aBoolean) {
            if (position == ZHIBO_VP) {
                Log.e("TAGG", "加载了");
                list.addAll(bean.getData().getPandalive().getList());
                HomeGridView_Adapter adapter = new HomeGridView_Adapter(context, list);
                myGridView.setAdapter(adapter);
                aBoolean = false;
            }
        }
        //精彩一刻
        if (position == JINGCAI_VP) {
            ArrayList<HomeDataBean.DataBean.BigImgBean> list2 = new ArrayList<>();
            list2.addAll(bean.getData().getBigImg());
            HomeGridView2_Adapter adapter = new HomeGridView2_Adapter(context, list2);
            myGridView2.setAdapter(adapter);
        }
        //滚滚视频
        if (position == GUNGUN_VP) {

            HttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/video/index.json", null, new MyCallBack<GunGun_bean>() {
                @Override
                public void onSuccess(GunGun_bean gunGun_bean) {

                    final ArrayList<GunGun_bean.ListBean> list3 = new ArrayList<>();
                    for (int i = 0; i < gunGun_bean.getList().size(); i++) {
                        list3.addAll(gunGun_bean.getList());
                    }
                    HomeListview_Adapter adapter = new HomeListview_Adapter(context, list3);
                    listView.setAdapter(adapter);

                }

                @Override
                public void onFaile(String msg) {
                    Log.e("TAG", "onFaile: 请求失败");
                }
            });

        }
        //直播中国
        if (position == CHINA_VP) {
            ArrayList<HomeDataBean.DataBean.ChinaliveBean.ListBeanXX> list4 = new ArrayList<>();
            list4.addAll(bean.getData().getChinalive().getList());
            China_Adapter adapter = new China_Adapter(context, list4);
            myGridView3.setAdapter(adapter);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_VP;
        }
        if (position == 1) {
            return BOBAO_VP;
        }
        if (position == 2) {
            return ZHIBO_VP;
        }
        if (position == 3) {
            return JINGCAI_VP;
        }
        if (position == 4) {
            return GUNGUN_VP;
        }
        if (position == 5) {
            return CHINA_VP;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

}
