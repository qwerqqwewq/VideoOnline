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

    public Favorites(){}
    public Favorites(Integer id,String name,String   createDate,Integer uid,String remark,User user){
        this.name=name;
        this.createDate=createDate;
        this.id=id;
        this.remark=remark;
        this.user=user;
    }


    public void setUser(User user) {
        this.user = user;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getUid(Integer id) {
        return this.id;
    }

    public void setUid(Integer uid) {
        this.id = uid;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "user=" + user +
                ", uid=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}