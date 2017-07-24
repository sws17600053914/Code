package com.example.admin.myapplication.module.person.dengl;

/**
 * 代码虐我千百遍，我待代码如初恋
 * 创建于： Administrator on 2017/7/22 0022.
 * 作 者：晋玉芬
 * 微信：18401670585
 * <p>
 */


public class LoginBean {

    /**
     * errType : 0
     * ticket : 8502a7f9-4f01-4a6a-8a1b-502035a263e3
     * user_seq_id : 54074959
     * errMsg : 成功
     * usrid : 540749591500705027790
     * sso : []
     * timestamp : 2017-07-22 14:25:11
     */
    private String errType;
    private String ticket;
    private String user_seq_id;
    private String errMsg;
    private String usrid;

    public String getErrType() {
        return errType;
    }

    public void setErrType(String errType) {
        this.errType = errType;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getUser_seq_id() {
        return user_seq_id;
    }

    public void setUser_seq_id(String user_seq_id) {
        this.user_seq_id = user_seq_id;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "errType='" + errType + '\'' +
                ", ticket='" + ticket + '\'' +
                ", user_seq_id='" + user_seq_id + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", usrid='" + usrid + '\'' +
                '}';
    }
}
