package com.example.admin.myapplication.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:40
 * 作 者：T
 * 微信：704003376
 */

public class WonderfulBean {

    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4476"}
     * video : [{"vsid":"VSET100167216881","order":"4473","vid":"3b2af8847566427ba3737a859944c482","t":"《精彩一刻》 20170721 这就是欺负女孩子的结果","url":"http://tv.cntv.cn/video/VSET100167216881/3b2af8847566427ba3737a859944c482","ptime":"2017-07-21 10:02:09","img":"http://p2.img.cctvpic.com/fmspic/2017/07/21/3b2af8847566427ba3737a859944c482-31.jpg?p=2&h=120","len":"00:00:42","em":"CM01"},{"vsid":"VSET100167216881","order":"4465","vid":"d7d80f55f0f342ed9a25073f26425b3f","t":"《精彩一刻》 20170720 我猜中了开头，没猜中这结尾","url":"http://tv.cntv.cn/video/VSET100167216881/d7d80f55f0f342ed9a25073f26425b3f","ptime":"2017-07-20 14:04:45","img":"http://p5.img.cctvpic.com/fmspic/2017/07/20/d7d80f55f0f342ed9a25073f26425b3f-35.jpg?p=2&h=120","len":"00:00:50","em":"CM01"},{"vsid":"VSET100167216881","order":"4466","vid":"a394d696a4284596ba4cbb85920c32a6","t":"《精彩一刻》 20170720 这其实是\u201c成实\u201d的真正实力","url":"http://tv.cntv.cn/video/VSET100167216881/a394d696a4284596ba4cbb85920c32a6","ptime":"2017-07-20 14:03:42","img":"http://p2.img.cctvpic.com/fmspic/2017/07/20/a394d696a4284596ba4cbb85920c32a6-21.jpg?p=2&h=120","len":"00:00:21","em":"CM01"},{"vsid":"VSET100167216881","order":"4468","vid":"cf0ed51bb3944536bf951525661defd8","t":"《精彩一刻》 20170720 练体操要从小抓起","url":"http://tv.cntv.cn/video/VSET100167216881/cf0ed51bb3944536bf951525661defd8","ptime":"2017-07-20 14:02:29","img":"http://p5.img.cctvpic.com/fmspic/2017/07/20/cf0ed51bb3944536bf951525661defd8-35.jpg?p=2&h=120","len":"00:00:51","em":"CM01"},{"vsid":"VSET100167216881","order":"4467","vid":"9938359a2c9e433faa2f541ca6edfef9","t":"《精彩一刻》 20170720 拉手手就是熊生最开心的事","url":"http://tv.cntv.cn/video/VSET100167216881/9938359a2c9e433faa2f541ca6edfef9","ptime":"2017-07-20 14:00:47","img":"http://p2.img.cctvpic.com/fmspic/2017/07/20/9938359a2c9e433faa2f541ca6edfef9-21.jpg?p=2&h=120","len":"00:00:34","em":"CM01"},{"vsid":"VSET100167216881","order":"4469","vid":"21b03d9e991b4f53ba538e9575785e3c","t":"《精彩一刻》 20170720 还是玩不过奶爸套路呀","url":"http://tv.cntv.cn/video/VSET100167216881/21b03d9e991b4f53ba538e9575785e3c","ptime":"2017-07-20 13:26:23","img":"http://p1.img.cctvpic.com/fmspic/2017/07/20/21b03d9e991b4f53ba538e9575785e3c-9.jpg?p=2&h=120","len":"00:00:16","em":"CM01"},{"vsid":"VSET100167216881","order":"4470","vid":"9cd8d26261784606a754f3c0c945dddd","t":"《精彩一刻》 20170720 腿短就别跨大步~","url":"http://tv.cntv.cn/video/VSET100167216881/9cd8d26261784606a754f3c0c945dddd","ptime":"2017-07-20 13:25:35","img":"http://p1.img.cctvpic.com/fmspic/2017/07/20/9cd8d26261784606a754f3c0c945dddd-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4476
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean implements Serializable{
        /**
         * vsid : VSET100167216881
         * order : 4473
         * vid : 3b2af8847566427ba3737a859944c482
         * t : 《精彩一刻》 20170721 这就是欺负女孩子的结果
         * url : http://tv.cntv.cn/video/VSET100167216881/3b2af8847566427ba3737a859944c482
         * ptime : 2017-07-21 10:02:09
         * img : http://p2.img.cctvpic.com/fmspic/2017/07/21/3b2af8847566427ba3737a859944c482-31.jpg?p=2&h=120
         * len : 00:00:42
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

    }
}
