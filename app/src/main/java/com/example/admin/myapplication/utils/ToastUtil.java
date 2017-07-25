package com.example.admin.myapplication.utils;

import android.widget.Toast;

import com.example.admin.myapplication.global.MyApp;


/**
 * Created by Administrator on 2017/7/10.
 */

public class ToastUtil {
    private static Toast toast;
    public static void showToast(String text){
        if (toast==null){
            toast=Toast.makeText(MyApp.mContext,text,Toast.LENGTH_SHORT);
        }else {
            toast.setText(text);
        }
        toast.show();
    }
}
