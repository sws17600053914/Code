package com.example.admin.myapplication.module.LiveChina;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.global.MyApp;
import com.example.admin.myapplication.utils.MyGridLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LiveChinaAddActivity extends BaseActivity {

    @BindView(R.id.addactivity_chahao)
    ImageView addactivityChahao;
    @BindView(R.id.addactivity_bianji)
    Button addactivityBianji;
    @BindView(R.id.add_shang_gridlayout)
    MyGridLayout addShangGridlayout;
    @BindView(R.id.add_xia_gridlayout)
    MyGridLayout addXiaGridlayout;
    @BindView(R.id.addactivity_paixu)
    TextView addactivityPaixu;
    private List<String> mList1 = new ArrayList<>();

    boolean aBoolean=false;
    @Override
    protected void initView() {
        addShangGridlayout = (MyGridLayout) findViewById(R.id.add_shang_gridlayout);
        addXiaGridlayout = (MyGridLayout) findViewById(R.id.add_xia_gridlayout);
        addactivityBianji = (Button) findViewById(R.id.addactivity_bianji);
        addactivityChahao = (ImageView) findViewById(R.id.addactivity_chahao);
        addactivityPaixu= (TextView) findViewById(R.id.addactivity_paixu);
        addactivityChahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                setResult(200, intent);
                finish();
            }
        });
        addactivityBianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean){
                    addactivityPaixu.setText("");
                    aBoolean=false;
                    addactivityBianji.setText("编辑");
                }else {
                    addactivityPaixu.setText("长按拖动可以排序");
                    aBoolean=true;
                    addactivityBianji.setText("完成");
                }
            }
        });

        addShangGridlayout.setDragAble(true);
        addXiaGridlayout.setDragAble(false);

        addShangGridlayout.setItems(MyApp.mLists);
        addXiaGridlayout.setItems(MyApp.mListx);

            addShangGridlayout.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
                @Override
                public void OnItemClickLitener(String strItem, View v) {
                    // 上面的Gridlayout的点击事件
                    if (aBoolean) {
                        if (MyApp.mLists.size() > 4) {
                            addShangGridlayout.removeView(v);
                            mList1.add(strItem);
                            addXiaGridlayout.setItems(mList1);
                            mList1.clear();
                            MyApp.mLists.remove(strItem);
                            MyApp.mListx.add(strItem);
                        } else {
                            Toast.makeText(LiveChinaAddActivity.this, "栏目区,不能少于四个频道", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            addXiaGridlayout.setOnItemClickLitener(new MyGridLayout.OnItemClickLitener() {
                @Override
                public void OnItemClickLitener(String strItem, View v) {
                    if (aBoolean) {
                        addXiaGridlayout.removeView(v);
                        addShangGridlayout.addItem(strItem);
                        MyApp.mLists.add(strItem);
                        MyApp.mListx.remove(strItem);
                    }
                }
            });
    }
    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_live_china_add;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
