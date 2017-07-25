package com.example.admin.myapplication.module.user;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 打井就要打出水来为止，Android也同样
 * <p>
 * 姓名：史文胜
 * <p>
 * 手机号：17600053914
 */

@Entity
public class User {
    @Id
    Long id;
    @Property(nameInDb = "image_url")
    String image_url;
    @Property(nameInDb = "tv_title")
    String tv_title;
    @Property(nameInDb = "tv_time")
    String tv_time;
    public String getTv_time() {
        return this.tv_time;
    }
    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }
    public String getTv_title() {
        return this.tv_title;
    }
    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 2108989170)
    public User(Long id, String image_url, String tv_title, String tv_time) {
        this.id = id;
        this.image_url = image_url;
        this.tv_title = tv_title;
        this.tv_time = tv_time;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}


