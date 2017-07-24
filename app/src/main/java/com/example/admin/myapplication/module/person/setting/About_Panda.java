package com.example.admin.myapplication.module.person.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
/**
 * 代码虐我千百遍，我待代码如初恋
 *
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 关于熊猫频道
 */
public class About_Panda extends BaseActivity {

    private ImageView about_back;

    @Override
    protected void initView() {
        about_back = (ImageView) findViewById(R.id.about_back);
        about_back.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_about__panda;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

}