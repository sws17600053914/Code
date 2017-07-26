package com.example.admin.myapplication.module.RollRoll_video.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.model.bean.RollDataBean;
import com.example.admin.myapplication.model.bean.TestBean;
import com.example.admin.myapplication.module.RollRoll_video.RecyclerDivider;
import com.example.admin.myapplication.module.RollRoll_video.adapter.Roll2Adapter;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.android.percent.support.PercentRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * 生命不息，奋斗不止，万事起于细微，量变引起质变
 * Created by 因天鹏 on 2017/7/19.
 */

public class RollItemActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private ImageView share, shoucheng,back;
    private CheckBox checkBox;
    private XRecyclerView xRecyclerView;
    private TextView textView,titleTOP;
    private PercentRelativeLayout layout;
    private JCVideoPlayer jcVideoPlayer;
    private ArrayList<RollDataBean.VideoBean> mList = new ArrayList<>();
    private Roll2Adapter adapter;
    private int a = 1;
    private String id;
    private String url;
    private boolean b = true;
    private String pid;
    private String title;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case 0:
                    pid = (String) msg.obj;
                    break;
                case 1:
                    pid = (String) msg.obj;
                    break;

            }
            String url = "http://115.182.35.91/api/getVideoInfoForCBox.do?pid=" + pid;
            HttpUtils.getInstance().get(url, null, new MyCallBack<TestBean>() {
                @Override
                public void onSuccess(TestBean testBean) {
                    final List<TestBean.VideoBean.ChaptersBean> chapters = testBean.getVideo().getChapters();
                    Log.e("TAG", String.valueOf(chapters));

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < chapters.size(); i++) {
                                url1 = chapters.get(i).getUrl();
                                jcVideoPlayer.setUp(url1, title);
                            }
                        }
                    });
                }

                @Override
                public void onFaile(String msg) {

                }
            });
        }
    };
    private String url1;

    @Override
    protected void initView() {
        back = (ImageView) findViewById(R.id.rollitem_image);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleTOP = (TextView) findViewById(R.id.rollitem_title);
        jcVideoPlayer = (JCVideoPlayer) findViewById(R.id.rollitem_jcvideo);
        shoucheng = (ImageView) findViewById(R.id.rollitem_shoucheng);
        shoucheng.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.rollitem_content);
        share = (ImageView) findViewById(R.id.rollitem_share);
        xRecyclerView = (XRecyclerView) findViewById(R.id.rollitem_xrecycler);
        checkBox = (CheckBox) findViewById(R.id.rollitem_checkbox);
        layout = (PercentRelativeLayout) findViewById(R.id.rollitem_layout);
        checkBox.setOnCheckedChangeListener(this);
        share.setOnClickListener(this);
        shoucheng.setOnClickListener(this);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        titleTOP.setText(title);

        s();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);

        xRecyclerView.setRefreshProgressStyle(ProgressStyle.SysProgress);
        xRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        xRecyclerView.addItemDecoration(new RecyclerDivider(this, RecyclerDivider.VERTICAL_LIST));
        xRecyclerView.setLoadingMoreEnabled(true);

        adapter = new Roll2Adapter(this, mList);
        xRecyclerView.setAdapter(adapter);


        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
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
                    @Override
                    public void run() {
                        a = a + 1;
                        s();
                        adapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                        xRecyclerView.setLoadingMoreEnabled(true);
                    }
                }, 3000);
            }
        });

        adapter.setOnClick(new Roll2Adapter.setOnClick() {
            @Override
            public void setClick(int position) {
                pid = mList.get(position).getVid();
                RollItemActivity.this.title = mList.get(position).getT();
                Message message = new Message();
                message.obj = pid;
                message.arg1 = 1;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_rollitem;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            layout.setVisibility(View.VISIBLE);
        } else {
            layout.setVisibility(View.GONE);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rollitem_share:

                View view = LayoutInflater.from(this).inflate(R.layout.original_pop, null);
                final PopupWindow window = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                window.setOutsideTouchable(true);
                window.setBackgroundDrawable(new BitmapDrawable());
                window.setFocusable(true);
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.alpha = 0.6f;
                getWindow().setAttributes(params);
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams params = getWindow().getAttributes();
                        params.alpha = 1.0f;
                        getWindow().setAttributes(params);
                    }
                });
                window.showAtLocation(RollItemActivity.this.findViewById(R.id.rollitem), Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                Button button = (Button) view.findViewById(R.id.pop_button);
                RadioButton fac = (RadioButton) view.findViewById(R.id.pop_fac);
                RadioButton weibo = (RadioButton) view.findViewById(R.id.pop_sinawebo);
                RadioButton mon = (RadioButton) view.findViewById(R.id.pop_moments);
                RadioButton weixin = (RadioButton) view.findViewById(R.id.pop_wechat);
                RadioButton tw = (RadioButton) view.findViewById(R.id.pop_twitter);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        window.dismiss();
                    }
                });

                break;
            case R.id.rollitem_shoucheng:
                if (b == true) {
                    shoucheng.setImageResource(R.drawable.collect_yes);
                    b = false;
                } else {
                    shoucheng.setImageResource(R.drawable.collect_no);
                    b = true;
                }
                break;
        }
    }

    private void s() {
//        http://api.cntv.cn/video/videolistById?p=2&serviceId=panda&n=10&vsid=VSET100284428835
        url = "http://api.cntv.cn/video/videolistById?p=" + a + "&serviceId=panda&n=10&vsid=" + id;
        HttpUtils.getInstance().get(url, null, new MyCallBack<RollDataBean>() {
            @Override
            public void onSuccess(RollDataBean rollDataBean) {
                textView.setText(rollDataBean.getVideoset().get_$0().getDesc());
                mList.addAll(rollDataBean.getVideo());
                pid = mList.get(0).getVid();
                title = mList.get(0).getT();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.obj = pid;
                        message.arg1 = 0;
                        handler.sendMessage(message);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
            @Override
            public void onFaile(String msg) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos() ;
    }
}
