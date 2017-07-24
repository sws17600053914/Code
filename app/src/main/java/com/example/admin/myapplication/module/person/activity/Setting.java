package com.example.admin.myapplication.module.person.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.base.BaseActivity;
import com.example.admin.myapplication.module.person.setting.About_Panda;
import com.example.admin.myapplication.module.person.setting.User_Tickling;
import com.zhy.android.percent.support.PercentRelativeLayout;

public class Setting extends BaseActivity implements View.OnClickListener{


    private ImageView set_back;
    private CheckBox accept_box;
    private CheckBox automatic_box;
    private PercentRelativeLayout clear;
    private PercentRelativeLayout user_tickling;
    private PercentRelativeLayout upgrade;
    private PercentRelativeLayout goodreputation;
    private PercentRelativeLayout about_pandachannel;
    private TextView rubbish;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private String appPkg;
    private String marketPkg;

    @Override
    protected void initView() {
        set_back = (ImageView) findViewById(R.id.set_back);
        accept_box = (CheckBox) findViewById(R.id.accept_box);
        automatic_box = (CheckBox) findViewById(R.id.automatic_box);
        user_tickling = (PercentRelativeLayout) findViewById(R.id.user_tickling);
        clear = (PercentRelativeLayout) findViewById(R.id.clear);
        upgrade = (PercentRelativeLayout) findViewById(R.id.upgrade);
        goodreputation = (PercentRelativeLayout) findViewById(R.id.goodreputation);
        about_pandachannel = (PercentRelativeLayout) findViewById(R.id.about_pandachannel);
        rubbish = (TextView) findViewById(R.id.laji);

        set_back.setOnClickListener(this);
        accept_box.setOnClickListener(this);
        automatic_box.setOnClickListener(this);
        user_tickling.setOnClickListener(this);
        clear.setOnClickListener(this);
        upgrade.setOnClickListener(this);
        goodreputation.setOnClickListener(this);
        about_pandachannel.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        boolean auto = sharedPreferences.getBoolean("auto",false);
        boolean accept = sharedPreferences.getBoolean("accept",false);
        if (auto==true){
            automatic_box.setChecked(true);
        }else {
            automatic_box.setChecked(false);
        }

        if (accept==true){
            accept_box.setChecked(true);
        }else {
            accept_box.setChecked(false);
        }

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_back:
                finish();
                break;
            case R.id.clear:
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("确认清除缓存吗？");

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        arg0.dismiss();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rubbish.setText("0.0M");

                    }
                }).show();

                break;
            case R.id.user_tickling:
                Intent intent1 = new Intent(Setting.this,User_Tickling.class);
                startActivity(intent1);
                break;
            case R.id.about_pandachannel://关于熊猫频道
                Intent intent = new Intent(Setting.this,About_Panda.class);
                startActivity(intent);
                break;
            case R.id.accept_box://消息推送
                editor.putBoolean("accept",accept_box.isChecked());
                editor.commit();
                break;
            case R.id.automatic_box://自动播放下一集
                if (automatic_box.isChecked()){
                    editor.putBoolean("auto",automatic_box.isChecked());

                }else {
                    editor.putBoolean("auto",automatic_box.isChecked());

                }
                editor.commit();
                break;
            case R.id.goodreputation:
                appPkg = "熊猫频道";
                marketPkg = "";
//            launchAppDetail(appPkg, marketPkg);
                try {
                    Intent intent9 = new Intent(Intent.ACTION_VIEW);
                    //参数是应用程序的包名
                    intent9.setData(Uri.parse("market://details?id=" + "熊猫频道"));
                    //通过隐式意图激活activity
                    startActivity(intent9);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Setting.this, "抱歉，你没有安装应用市场", Toast.LENGTH_LONG);
                }
                break;

        }
    }
    public void launchAppDetail(String appPkg, String marketPkg) {
        try {
            if (TextUtils.isEmpty(appPkg)) return;

            Uri uri = Uri.parse("market://details?id=" + appPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg)) {
                intent.setPackage(marketPkg);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
