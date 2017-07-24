package com.example.admin.myapplication.module.person;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/22 0022.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 */


public class PersonBean {

    /**
     * code : 0
     * content : {"nickname":"央视网友8l8z9n3k","userface":"http://userface.img.cctvpic.com/80x80/883/697/54074755.jpg"}
     */
    private int code;
    private ContentEntity content;

    public void setCode(int code) {
        this.code = code;
    }

    public void setContent(ContentEntity content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public ContentEntity getContent() {
        return content;
    }

    public class ContentEntity {
        /**
         * nickname : 央视网友8l8z9n3k
         * userface : http://userface.img.cctvpic.com/80x80/883/697/54074755.jpg
         */
        private String nickname;
        private String userface;

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setUserface(String userface) {
            this.userface = userface;
        }

        public String getNickname() {
            return nickname;
        }

        public String getUserface() {
            return userface;
        }
    }
}
