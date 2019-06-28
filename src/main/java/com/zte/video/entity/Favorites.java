package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 12:11
 * Description:<描述>
 */
public class Favorites implements Serializable {

    private User user;

    private Integer id;

    private String name;

    private String remark;

    private String createDate;

    public Favorites() {
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Favorites(String createDate, Integer id, String name, String remark, User user) {
        this.createDate = createDate;
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "createDate='" + createDate + '\'' +
                ", user=" + user +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}