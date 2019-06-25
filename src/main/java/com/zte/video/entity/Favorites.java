package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 12:11
 * Description:<描述>
 */
public class Favorites implements Serializable {

    private Integer id;

    private Integer uid;

    private String name;

    private String remark;

    private String createDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public Favorites(){
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Favorites(Integer id,String name,String   createDate,Integer uid,String remark,User user){
        this.id=id;
        this.name=name;
        this.createDate=createDate;
        this.uid=uid;
        this.remark=remark;
        this.user=user;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate='" + createDate + '\'' +
                ", user=" + user +
                '}';
    }
}