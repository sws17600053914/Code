package com.example.admin.myapplication.network;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 09:48
 * 作 者：T
 * 微信：704003376
 */
public interface MyCallBack<T> {
    void onSuccess(T t);             //请求成功

    void onFaile(String msg);       //请求失败
}
