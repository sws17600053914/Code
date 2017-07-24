package com.example.admin.myapplication.model.bean;

import java.util.List;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 10:56
 * 作 者：T
 * 微信：704003376
 */
public class HomeDataBean {


    private DataBean data;

    @Override
    public String toString() {
        return "HomeDataBean{" +
                "data=" + data +
                '}';
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


        private AreaBean area;
        private PandaeyeBean pandaeye;
        private PandaliveBean pandalive;
        private WallliveBean walllive;
        private ChinaliveBean chinalive;
        private InteractiveBean interactive;
        private CctvBean cctv;
        private List<BigImgBean> bigImg;
        private List<ListBeanXXX> list;

        @Override
        public String toString() {
            return "DataBean{" +
                    "area=" + area +
                    ", pandaeye=" + pandaeye +
                    ", pandalive=" + pandalive +
                    ", walllive=" + walllive +
                    ", chinalive=" + chinalive +
                    ", interactive=" + interactive +
                    ", cctv=" + cctv +
                    ", bigImg=" + bigImg +
                    ", list=" + list +
                    '}';
        }

        public AreaBean getArea() {
            return area;
        }

        public void setArea(AreaBean area) {
            this.area = area;
        }

        public PandaeyeBean getPandaeye() {
            return pandaeye;
        }

        public void setPandaeye(PandaeyeBean pandaeye) {
            this.pandaeye = pandaeye;
        }

        public PandaliveBean getPandalive() {
            return pandalive;
        }

        public void setPandalive(PandaliveBean pandalive) {
            this.pandalive = pandalive;
        }

        public WallliveBean getWalllive() {
            return walllive;
        }

        public void setWalllive(WallliveBean walllive) {
            this.walllive = walllive;
        }

        public ChinaliveBean getChinalive() {
            return chinalive;
        }

        public void setChinalive(ChinaliveBean chinalive) {
            this.chinalive = chinalive;
        }

        public InteractiveBean getInteractive() {
            return interactive;
        }

        public void setInteractive(InteractiveBean interactive) {
            this.interactive = interactive;
        }

        public CctvBean getCctv() {
            return cctv;
        }

        public void setCctv(CctvBean cctv) {
            this.cctv = cctv;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public List<ListBeanXXX> getList() {
            return list;
        }

        public void setList(List<ListBeanXXX> list) {
            this.list = list;
        }

        public static class AreaBean {


            private String title;
            private String image;
            private String url;
            private String id;
            private List<ListscrollBean> listscroll;
            private List<?> listh;
            private List<?> lists;
            private List<?> topiclist;

            @Override
            public String toString() {
                return "AreaBean{" +
                        "title='" + title + '\'' +
                        ", image='" + image + '\'' +
                        ", url='" + url + '\'' +
                        ", id='" + id + '\'' +
                        ", listscroll=" + listscroll +
                        ", listh=" + listh +
                        ", lists=" + lists +
                        ", topiclist=" + topiclist +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<ListscrollBean> getListscroll() {
                return listscroll;
            }

            public void setListscroll(List<ListscrollBean> listscroll) {
                this.listscroll = listscroll;
            }

            public List<?> getListh() {
                return listh;
            }

            public void setListh(List<?> listh) {
                this.listh = listh;
            }

            public List<?> getLists() {
                return lists;
            }

            public void setLists(List<?> lists) {
                this.lists = lists;
            }

            public List<?> getTopiclist() {
                return topiclist;
            }

            public void setTopiclist(List<?> topiclist) {
                this.topiclist = topiclist;
            }

            public static class ListscrollBean {
                /**
                 * image : http://p1.img.cctvpic.com/photoworkspace/2017/06/12/2017061213503191970.jpg
                 * url : http://live.ipanda.com/2017/06/12/VIDEwHnBh4Rl0GZ5BeHFcnlR170612.shtml
                 * title : 搓澡的呢？小公主都要睡着了
                 * videoLength :
                 * id : TITE1497340387814143
                 * pid : d2a828ca5cd0400f82c2adee5581fc17
                 * vid :
                 * order : 1
                 */

                private String image;
                private String url;
                private String title;
                private String videoLength;
                private String id;
                private String pid;
                private String vid;
                private String order;

                @Override
                public String toString() {
                    return "ListscrollBean{" +
                            "image='" + image + '\'' +
                            ", url='" + url + '\'' +
                            ", title='" + title + '\'' +
                            ", videoLength='" + videoLength + '\'' +
                            ", id='" + id + '\'' +
                            ", pid='" + pid + '\'' +
                            ", vid='" + vid + '\'' +
                            ", order='" + order + '\'' +
                            '}';
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getVideoLength() {
                    return videoLength;
                }

                public void setVideoLength(String videoLength) {
                    this.videoLength = videoLength;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class PandaeyeBean {
            /**
             * title : 熊猫观察
             * pandaeyelogo : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/27/1453878224122_861.png
             * items : [{"title":"东北虎五胞胎取名谐音为\u201c东北欢迎你\u201d","bgcolor":"#ff0a5a","brief":"新生","url":"http://panview.ipanda.com/2017/06/14/VIDEQ2MhA0Ejp9OgTUcZXJV0170614.shtml","id":"TITE1497403113884217","pid":"26097f927eb34babad51340659d08fe1","vid":"","order":"1"},{"title":"萌娃\u201c越狱\u201d 哥哥助弟弟下床","bgcolor":"#ff0a5a","brief":"趣闻","url":"http://panview.ipanda.com/2017/06/14/VIDEDitkvohE2rnEJQlg1opd170614.shtml","id":"TITE1497403079074598","pid":"3adc37e20dea44a9be56433d80234fa7","vid":"","order":"2"}]
             * pandaeyelist : http://www.ipanda.com/kehuduan/shipinliebieye/xiongmaoguancha/index.json
             */

            private String title;
            private String pandaeyelogo;
            private String pandaeyelist;
            private List<ItemsBean> items;

            @Override
            public String toString() {
                return "PandaeyeBean{" +
                        "title='" + title + '\'' +
                        ", pandaeyelogo='" + pandaeyelogo + '\'' +
                        ", pandaeyelist='" + pandaeyelist + '\'' +
                        ", items=" + items +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPandaeyelogo() {
                return pandaeyelogo;
            }

            public void setPandaeyelogo(String pandaeyelogo) {
                this.pandaeyelogo = pandaeyelogo;
            }

            public String getPandaeyelist() {
                return pandaeyelist;
            }

            public void setPandaeyelist(String pandaeyelist) {
                this.pandaeyelist = pandaeyelist;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            public static class ItemsBean {
                /**
                 * title : 东北虎五胞胎取名谐音为“东北欢迎你”
                 * bgcolor : #ff0a5a
                 * brief : 新生
                 * url : http://panview.ipanda.com/2017/06/14/VIDEQ2MhA0Ejp9OgTUcZXJV0170614.shtml
                 * id : TITE1497403113884217
                 * pid : 26097f927eb34babad51340659d08fe1
                 * vid :
                 * order : 1
                 */

                private String title;
                private String bgcolor;
                private String brief;
                private String url;
                private String id;
                private String pid;
                private String vid;
                private String order;

                @Override
                public String toString() {
                    return "ItemsBean{" +
                            "title='" + title + '\'' +
                            ", bgcolor='" + bgcolor + '\'' +
                            ", brief='" + brief + '\'' +
                            ", url='" + url + '\'' +
                            ", id='" + id + '\'' +
                            ", pid='" + pid + '\'' +
                            ", vid='" + vid + '\'' +
                            ", order='" + order + '\'' +
                            '}';
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getBgcolor() {
                    return bgcolor;
                }

                public void setBgcolor(String bgcolor) {
                    this.bgcolor = bgcolor;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class PandaliveBean {
            /**
             * title : 熊猫直播
             * list : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765186225_780.jpg","url":"","title":"成都基地高清精切线路","id":"ipanda","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json","order":"1"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765209983_511.jpg","url":"","title":"成都直播：熊猫母子园","id":"xiongmao07","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json","order":"2"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765227283_786.jpg","url":"","title":"成都直播：熊猫一号别墅","id":"xiongmao09","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json","order":"3"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/4/1/1491013180946_553.jpg","url":"","title":"卧龙直播：熊猫\u201c宝宝\u201d","id":"xiongmao11","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE145017878968133121/index.json","order":"4"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765258608_842.jpg","url":"","title":"卧龙直播：熊猫\u201c青青\u201d","id":"xiongmao12","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE145017878968133121/index.json","order":"5"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/6/1/1464765552815_663.jpg","url":"","title":"雅安基地幼儿园","id":"xiongmao18","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE145017878968133121/index.json","order":"6"}]
             */

            private String title;
            private List<ListBean> list;

            @Override
            public String toString() {
                return "PandaliveBean{" +
                        "title='" + title + '\'' +
                        ", list=" + list +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765186225_780.jpg
                 * url :
                 * title : 成都基地高清精切线路
                 * id : ipanda
                 * vid : http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json
                 * order : 1
                 */

                private String image;
                private String url;
                private String title;
                private String id;
                private String vid;
                private String order;

                @Override
                public String toString() {
                    return "ListBean{" +
                            "image='" + image + '\'' +
                            ", url='" + url + '\'' +
                            ", title='" + title + '\'' +
                            ", id='" + id + '\'' +
                            ", vid='" + vid + '\'' +
                            ", order='" + order + '\'' +
                            '}';
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class WallliveBean {
            /**
             * title : 长城直播
             * list : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453447161326_398.jpg","url":"","title":"八达岭长城南四楼","id":"bgws4","vid":"http://www.ipanda.com/kehuduan/liebiao/badaling/index.json","order":"1"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453449429822_667.jpg","url":"","title":"八达岭长城北十楼","id":"bgwn10","vid":"http://www.ipanda.com/kehuduan/liebiao/badaling/index.json","order":"2"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453449966410_700.jpg","url":"","title":"山海关长城镜头一","id":"wgw05","vid":"http://www.ipanda.com/kehuduan/liebiao/shanhaiguan/index.json","order":"3"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453450730912_656.jpg","url":"","title":"山海关长城镜头二","id":"wgw06","vid":"http://www.ipanda.com/kehuduan/liebiao/shanhaiguan/index.json","order":"4"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453451106626_148.jpg","url":"","title":"水长城","id":"wgw01","vid":"http://www.ipanda.com/kehuduan/liebiao/PAGEtcPWwRQbFtXAc5XV95lh160119/index.json","order":"5"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453451567952_933.jpg","url":"","title":"嘉峪关","id":"jyg03","vid":"http://www.ipanda.com/kehuduan/liebiao/PAGEcA8N14784Rzm35Q4Ppx1160119/index.json","order":"6"}]
             */

            private String title;
            private List<ListBeanX> list;

            @Override
            public String toString() {
                return "WallliveBean{" +
                        "title='" + title + '\'' +
                        ", list=" + list +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {
                /**
                 * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453447161326_398.jpg
                 * url :
                 * title : 八达岭长城南四楼
                 * id : bgws4
                 * vid : http://www.ipanda.com/kehuduan/liebiao/badaling/index.json
                 * order : 1
                 */

                private String image;
                private String url;
                private String title;
                private String id;
                private String vid;
                private String order;

                @Override
                public String toString() {
                    return "ListBeanX{" +
                            "image='" + image + '\'' +
                            ", url='" + url + '\'' +
                            ", title='" + title + '\'' +
                            ", id='" + id + '\'' +
                            ", vid='" + vid + '\'' +
                            ", order='" + order + '\'' +
                            '}';
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class ChinaliveBean {
            /**
             * title : 直播中国
             * list : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/19/1474274866009_775.jpg","url":"","title":"【直播】张家界","id":"zjjmht","vid":"http://livechina.ipanda.com/zhangjiajie/01/index.shtml","order":"1"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/19/1474274669741_123.jpg","url":"","title":"【直播】凤凰古城","id":"fhgcdgm","vid":"http://livechina.ipanda.com/fenghuang/01/index.shtml","order":"2"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646740047_989.jpg","url":"","title":"【直播】中央电视塔","id":"ztd","vid":"http://livechina.ipanda.com/zhongta/02/index.shtml","order":"3"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646628905_109.jpg","url":"","title":"【直播】悬空寺","id":"hsxksqj","vid":"http://livechina.ipanda.com/hengshan/01/index.shtml","order":"4"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646593298_50.jpg","url":"","title":"【直播】黄果树","id":"hgsljtgpt","vid":"http://livechina.ipanda.com/huangguoshu/02/index.shtml","order":"5"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646137373_456.jpg","url":"","title":"【直播】黄龙","id":"hlwxt","vid":"http://www.ipanda.com/kehuduan/liebiao/huanglong/index.json","order":"6"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453182053209_224.jpg","url":"","title":"【直播】泰山","id":"taishan01","vid":"http://www.ipanda.com/kehuduan/liebiao/PAGE1451288906969388/index.json","order":"7"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453182136725_375.jpg","url":"","title":"【直播】黄山","id":"hssxf","vid":"http://www.ipanda.com/kehuduan/liebiao/huangshan/index.json","order":"8"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453182395917_608.jpg","url":"","title":"【直播】峨眉山","id":"emsarm","vid":"http://www.ipanda.com/kehuduan/liebiao/emeishan/index.json","order":"9"}]
             */

            private String title;
            private List<ListBeanXX> list;

            @Override
            public String toString() {
                return "ChinaliveBean{" +
                        "title='" + title + '\'' +
                        ", list=" + list +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ListBeanXX> getList() {
                return list;
            }

            public void setList(List<ListBeanXX> list) {
                this.list = list;
            }

            public static class ListBeanXX {
                /**
                 * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/19/1474274866009_775.jpg
                 * url :
                 * title : 【直播】张家界
                 * id : zjjmht
                 * vid : http://livechina.ipanda.com/zhangjiajie/01/index.shtml
                 * order : 1
                 */

                private String image;
                private String url;
                private String title;
                private String id;
                private String vid;
                private String order;

                @Override
                public String toString() {
                    return "ListBeanXX{" +
                            "image='" + image + '\'' +
                            ", url='" + url + '\'' +
                            ", title='" + title + '\'' +
                            ", id='" + id + '\'' +
                            ", vid='" + vid + '\'' +
                            ", order='" + order + '\'' +
                            '}';
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class InteractiveBean {
            /**
             * title : 特别策划
             * interactiveone : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626317442_981.jpg","title":"二十四节气\u2014\u2014芒种","url":"http://webapp.cctv.com/h5/travel/U80531QU7SY7.html","type":"","vid":"","order":"1"}]
             * interactivetwo : []
             */

            private String title;
            private List<InteractiveoneBean> interactiveone;
            private List<?> interactivetwo;

            @Override
            public String toString() {
                return "InteractiveBean{" +
                        "title='" + title + '\'' +
                        ", interactiveone=" + interactiveone +
                        ", interactivetwo=" + interactivetwo +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<InteractiveoneBean> getInteractiveone() {
                return interactiveone;
            }

            public void setInteractiveone(List<InteractiveoneBean> interactiveone) {
                this.interactiveone = interactiveone;
            }

            public List<?> getInteractivetwo() {
                return interactivetwo;
            }

            public void setInteractivetwo(List<?> interactivetwo) {
                this.interactivetwo = interactivetwo;
            }

            public static class InteractiveoneBean {
                /**
                 * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626317442_981.jpg
                 * title : 二十四节气——芒种
                 * url : http://webapp.cctv.com/h5/travel/U80531QU7SY7.html
                 * type :
                 * vid :
                 * order : 1
                 */

                private String image;
                private String title;
                private String url;
                private String type;
                private String vid;
                private String order;

                @Override
                public String toString() {
                    return "InteractiveoneBean{" +
                            "image='" + image + '\'' +
                            ", title='" + title + '\'' +
                            ", url='" + url + '\'' +
                            ", type='" + type + '\'' +
                            ", vid='" + vid + '\'' +
                            ", order='" + order + '\'' +
                            '}';
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
                }
            }
        }

        public static class CctvBean {
            /**
             * title : 央视名栏
             * listlive : []
             * listurl : http://www.ipanda.com/kehuduan/shipinliebieye/cctvshipindicengye/index.json
             */

            private String title;
            private String listurl;
            private List<?> listlive;

            @Override
            public String toString() {
                return "CctvBean{" +
                        "title='" + title + '\'' +
                        ", listurl='" + listurl + '\'' +
                        ", listlive=" + listlive +
                        '}';
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getListurl() {
                return listurl;
            }

            public void setListurl(String listurl) {
                this.listurl = listurl;
            }

            public List<?> getListlive() {
                return listlive;
            }

            public void setListlive(List<?> listlive) {
                this.listlive = listlive;
            }
        }

        public static class BigImgBean {
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/16/1497597712866_826.jpg
             * title :
             * url : http://download.cntv.cn/app/ipanda/index.html
             * id : TITE1497597714712290
             * type : 6
             * stype :
             * pid :
             * vid :
             * order : 1
             */

            private String image;
            private String title;
            private String url;
            private String id;
            private String type;
            private String stype;
            private String pid;
            private String vid;
            private String order;

            @Override
            public String toString() {
                return "BigImgBean{" +
                        "image='" + image + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'' +
                        ", id='" + id + '\'' +
                        ", type='" + type + '\'' +
                        ", stype='" + stype + '\'' +
                        ", pid='" + pid + '\'' +
                        ", vid='" + vid + '\'' +
                        ", order='" + order + '\'' +
                        '}';
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }

        public static class ListBeanXXX {
            /**
             * listUrl : http://www.ipanda.com/kehuduan/shipinliebieye/guangyingzhongguo/index.json
             * title : 《光影中国》
             * type : 2
             * order : 1
             */

            private String listUrl;
            private String title;
            private String type;
            private String order;

            @Override
            public String toString() {
                return "ListBeanXXX{" +
                        "listUrl='" + listUrl + '\'' +
                        ", title='" + title + '\'' +
                        ", type='" + type + '\'' +
                        ", order='" + order + '\'' +
                        '}';
            }

            public String getListUrl() {
                return listUrl;
            }

            public void setListUrl(String listUrl) {
                this.listUrl = listUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }
    }
}
