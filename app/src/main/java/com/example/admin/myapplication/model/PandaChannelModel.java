package com.example.admin.myapplication.model;


import com.example.admin.myapplication.model.bean.BaDaLingBean;
import com.example.admin.myapplication.model.bean.HomeDataBean;
import com.example.admin.myapplication.model.bean.HomeVideoBean;
import com.example.admin.myapplication.model.bean.LiveChinaBean;
import com.example.admin.myapplication.model.bean.LiveTitleBean;
import com.example.admin.myapplication.model.bean.LiveURLBean;
import com.example.admin.myapplication.model.bean.MultiBean;
import com.example.admin.myapplication.model.bean.OriginalBean;
import com.example.admin.myapplication.model.bean.PandaBroadBean;
import com.example.admin.myapplication.model.bean.PandaBroadTwoBean;
import com.example.admin.myapplication.model.bean.PandaLiveBean;
import com.example.admin.myapplication.model.bean.RollRollVideoBean;
import com.example.admin.myapplication.model.bean.WonderfulBean;
import com.example.admin.myapplication.module.person.PersonBean;
import com.example.admin.myapplication.module.person.dengl.LoginBean;
import com.example.admin.myapplication.network.MyCallBack;

import java.util.Map;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:27
 * 作 者：T
 * 微信：704003376
 *
 * 请求各个模块数据
 */

public interface PandaChannelModel {

    /**
     * 首页数据
     * @param callBack
     */
    void getHomeData(MyCallBack<HomeDataBean> callBack);

    /**
     * 滚滚视频数据
     *
     * @param callBack
     */
    void getRollVideoData(MyCallBack<RollRollVideoBean> callBack);


    /**
     * 获取熊猫直播数据
     *
     * @param callBack
     */
    void getLiveData(MyCallBack<PandaLiveBean> callBack);

    /**
     * 获取直播中国数据
     *
     * @param callBack
     */
    void getLiveChinaData(MyCallBack<LiveChinaBean> callBack);

    /**
     * 熊猫播报1(请求URL中有参数的)
     * @param path
     * @param primaryId
     * @param serviceId
     * @param callBack
     */
    void getPandaBroadData(String path, String primaryId,
                           String serviceId,String pagesize,
                           String page, MyCallBack<PandaBroadBean> callBack);

    /**
     * 熊猫播报2（请求URL中没有参数）
     * @param callBack
     */
    void getPandaBraodData(MyCallBack<PandaBroadTwoBean> callBack);


    /**
     * 获取多角度数据
     * @param callBack
     */
    void getMultiData(MyCallBack<MultiBean> callBack);


    /**
     * 获取首页视频
     * @param callBack
     */
    void getHomeVideoData(MyCallBack<HomeVideoBean> callBack);


    /**
     * 获取原创互动
     * @param callback
     */
    void getOriginalData(MyCallBack<OriginalBean> callback);


    /**
     * 获取八达岭数据
     * @param callBack
     */
    void getBaDaLingData(String url,MyCallBack<BaDaLingBean> callBack);


//    /**
//     * 获取精彩一刻数据
//     * @param callBack
//     */
//    void getWonderfulData(MyCallBack<WonderfulBean> callBack);
    /**
     * 用户登录(请求URL中有参数的)
     *
     * @param callBack
     */
    void getLoginData(String username, String password, String service, String from, MyCallBack<LoginBean> callBack);

    /*
    * 个人中心
    * @param callBack
    *
    * */
    void getPersonData(String client,String method,String userid, MyCallBack<PersonBean.ContentEntity> callBack);
    void getWonderfulData(Map<String,String> map, MyCallBack<WonderfulBean> callBack);

    void getLiveTitleData(MyCallBack<LiveTitleBean> callBack);

    void getLiveUrlData(Map<String,String> map,MyCallBack<LiveURLBean> callBack);
}
