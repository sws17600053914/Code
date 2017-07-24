package com.example.admin.myapplication.module.person;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.person.activity.Collect;
import com.example.admin.myapplication.module.person.activity.HistoricalRecord;
import com.example.admin.myapplication.module.person.activity.Login;
import com.example.admin.myapplication.module.person.activity.MyInformation;
import com.example.admin.myapplication.module.person.activity.Setting;
import com.example.admin.myapplication.network.HttpUtils;
import com.example.admin.myapplication.network.MyCallBack;
import com.zhy.android.percent.support.PercentRelativeLayout;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于：2017/7/19 9:30
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 * 个人中心
 */
public class PersonActivity extends BaseActivity implements View.OnClickListener {
    private ImageView phead;

    private ImageView back;

    private PercentRelativeLayout login;

    private PercentRelativeLayout watch;

    private PercentRelativeLayout collect;

    private PercentRelativeLayout set;
    private PercentRelativeLayout person;
    TextView person_name;
    private String usrid;

    PersonContract.PetsonPresenter petsonPresenter;
    private String uid;
    private String url;
    private String name;
    private String ima;
    private String uimage;

    @Override
    protected void initView() {

        login = (PercentRelativeLayout) findViewById(R.id.login);
        watch = (PercentRelativeLayout) findViewById(R.id.watch);
        collect = (PercentRelativeLayout) findViewById(R.id.collect);
        set = (PercentRelativeLayout) findViewById(R.id.set);
        back = (ImageView) findViewById(R.id.person_back);
        person = (PercentRelativeLayout) findViewById(R.id.parent);
        person_name = (TextView) findViewById(R.id.person_name);
          phead = (ImageView) findViewById(R.id.personal_head);
        login.setOnClickListener(this);
        watch.setOnClickListener(this);
        collect.setOnClickListener(this);
        set.setOnClickListener(this);
        back.setOnClickListener(this);
        person.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences("da", MODE_PRIVATE);
        usrid = preferences.getString("usrid", "");
        uid = preferences.getString("user_seq_id", "");
        String errMsg = preferences.getString("errMsgs", "");
        uimage = preferences.getString("ima","");
        Log.e("QQQ", "===" + errMsg);
        Log.e("QQQ", "===" + usrid + "udi===" + uid);
        if (errMsg.equals("成功")) {
            url = "http://my.cntv.cn/intf/napi/api.php?client=ipanda_mobile&method=user.getNickNameAndFace&userid=" + uid;
            HttpUtils.getInstance().get(url, null, new MyCallBack<PersonBean>() {

                @Override
                public void onSuccess(PersonBean contentEntity) {
                    Log.e("AAA", "nickname==--" + contentEntity.getContent().getNickname());
                    Log.e("AAA", "nickname==--" + contentEntity.getContent().getUserface());
                    name = contentEntity.getContent().getNickname();
                    ima = contentEntity.getContent().getUserface();
                   // Toast.makeText(PersonActivity.this, "名字" + contentEntity.getNickname(), Toast.LENGTH_SHORT).show();
                    person_name.setText(name);


                    Glide.with(PersonActivity.this).load(uimage).asBitmap().centerCrop().into(new BitmapImageViewTarget(phead) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            phead.setImageDrawable(circularBitmapDrawable);
                        }
                    });
                }

                @Override
                public void onFaile(String msg) {

                }
            });
            login.setVisibility(View.GONE);
            person.setVisibility(View.VISIBLE);

        } else {
            person.setVisibility(View.GONE);
            login.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_person;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Intent intent = new Intent(PersonActivity.this, Login.class);
                startActivity(intent);
                break;
            case R.id.watch:
                Intent intent1 = new Intent(PersonActivity.this, HistoricalRecord.class);
                startActivity(intent1);
                break;
            case R.id.collect:
                Intent intent2 = new Intent(PersonActivity.this, Collect.class);
                startActivity(intent2);
                break;
            case R.id.set:
                Intent intent3 = new Intent(PersonActivity.this, Setting.class);
                startActivity(intent3);
                break;
            case R.id.person_back:
                finish();
                break;
            case R.id.parent:
                Intent intent4 = new Intent(PersonActivity.this, MyInformation.class);
                intent4.putExtra("name",name);
                intent4.putExtra("ima",uimage);
                startActivity(intent4);
                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }


}
