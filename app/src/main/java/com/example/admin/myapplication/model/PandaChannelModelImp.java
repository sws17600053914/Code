package com.example.admin.myapplication.model;


import com.example.admin.myapplication.constants.Urls;
import com.example.admin.myapplication.model.bean.BaDaLingBean;
import com.example.admin.myapplication.model.bean.HomeDataBean;
import com.example.admin.myapplication.model.bean.HomeVideoBean;
import com.example.admin.myapplication.model.bean.LiveChinaBean;
import com.example.admin.myapplication.model.bean.MultiBean;
import com.example.admin.myapplication.model.bean.OriginalBean;
import com.example.admin.myapplication.model.bean.PandaBroadBean;
import com.example.admin.myapplication.model.bean.PandaBroadTwoBean;
import com.example.admin.myapplication.model.bean.PandaLiveBean;
import com.example.admin.myapplication.model.bean.RollRollVideoBean;
import com.example.admin.myapplication.model.bean.WonderfulBean;
import com.example.admin.myapplication.module.person.PersonBean;
import com.example.admin.myapplication.module.person.dengl.LoginBean;
import com.example.admin.myapplication.network.HttpFactory;
import com.example.admin.myapplication.network.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:41
 * 作 者：T
 * 微信：704003376
 */

public class PandaChannelModelImp implements PandaChannelModel {

    int i = 1;

    @Override
    public void getHomeData(MyCallBack<HomeDataBean> callBack) {
        HttpFactory.create().get(Urls.HOMEURLALL, null, callBack);
    }

    @Override
    public void getRollVideoData(MyCallBack<RollRollVideoBean> callBack) {
        HttpFactory.create().get(Urls.ROLLVIDEO, null, callBack);

    }

    @Override
    public void getLiveData(MyCallBack<PandaLiveBean> callBack) {
        HttpFactory.create().get(Urls.PANDALIVE, null, callBack);
    }

    @Override
    public void getLiveChinaData(MyCallBack<LiveChinaBean> callBack) {
        HttpFactory.create().get(Urls.LIVECHINAURL, null, callBack);
    }

    @Override
    public void getPandaBroadData(String path, String primaryId, String serviceId, String pagesize, String page, MyCallBack<PandaBroadBean> callBack) {

        Map<String, String> params = new HashMap<String, String>();

        i++;

        params.put("path", "iphoneInterface/general/getArticleAndVideoListInfo.json");

        params.put("primary_id", "PAGE1422435191506336");

        params.put("serviceId", "panda");

        params.put("pageSize", "6");

        params.put("page",i+"");

        HttpFactory.create().get(Urls.PANDAREPORT, params, callBack);

    }


//    @Override
//    public void getPandaBroadData(String path, String primaryId, String serviceId, String pagesize,int page MyCallBack<PandaBroadBean> callBack) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("path","iphoneInterface/general/getArticleAndVideoListInfo.json");
//        params.put("primary_id","PAGE1422435191506336");
//        params.put("serviceId","panda");
//        params.put("serviceId","panda");
//        params.put("serviceId","panda");
//        HttpFactory.create().get(Urls.PANDAREPORT, params, callBack);
//    }

    @Override
    public void getPandaBraodData(MyCallBack<PandaBroadTwoBean> callBack) {
        HttpFactory.create().get(Urls.PANDAREPORTTWO, null, callBack);
    }


    @Override
    public void getMultiData(MyCallBack<MultiBean> callBack) {
        HttpFactory.create().get(Urls.MULITANGLE, null, callBack);
    }

    @Override
    public void getHomeVideoData(MyCallBack<HomeVideoBean> callBack) {
        HttpFactory.create().get(Urls.HOMEVIDEOURL, null, callBack);
    }

    @Override
    public void getOriginalData(MyCallBack<OriginalBean> callback) {
        HttpFactory.create().get(Urls.ORIGINAL, null, callback);
    }

    @Override
    public void getBaDaLingData(String url,MyCallBack<BaDaLingBean> callBack) {
        HttpFactory.create().get(url, null, callBack);
    }

    @Override
    public void getWonderfulData(MyCallBack<WonderfulBean> callBack) {
//        Map<String, String> pamrams = new HashMap<String, String>();
//        pamrams.put("", "");
//        pamrams.put("", "");
//        pamrams.put("", "");
        HttpFactory.create().get(Urls.ORIGINALNEWS, null, callBack);
    }

//    //TODO  可能有参数
//    @Override
//    public void getWonderfulData(MyCallBack<WonderfulBean> callBack) {
//        Map<String, String> pamrams = new HashMap<String, String>();
//        pamrams.put("", "");
//        pamrams.put("", "");
//        pamrams.put("", "");
//        HttpFactory.create().get(Urls.ORIGINALNEWS, pamrams, callBack);
//    }
@Override
public void getLoginData(String username, String password, String service, String from,MyCallBack<LoginBean> callBack) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("username", username);
    params.put("password", password);
    params.put("service", service);
    params.put("from",from);
    HttpFactory.create().get(Urls.LOGIN, params, callBack);
}

    @Override
    public void getPersonData(String client, String method, String userid, MyCallBack<PersonBean.ContentEntity> callBack) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("client", client);
        params.put("method",method);
        params.put("userid",userid);
        HttpFactory.create().post(Urls.PERSON, params, callBack);
    }


}
