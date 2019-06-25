package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 12:12
 * Description:<描述>
 */
public class FavoritesContent implements Serializable {

    private Integer id;
    private User user;
    private Video video;
    private String insertDate;
    private String remark;

    public FavoritesContent(){}
    public FavoritesContent(Integer id,User user,Video video,String insertDate,String remark){
        this.id=id;
        this.user=user;
        this.video=video;
        this.insertDate=insertDate;
        this.remark=remark;
    }


    @Override
    public String toString() {
        return "FavoritesContent{" +
                "id=" + id +
                ", user=" + user +
                ", video=" + video +
                ", insertDate='" + insertDate + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Video getVideo() {
        return video;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}