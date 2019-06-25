package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 12:12
 * Description:<描述>
 */
public class FavoritesContent implements Serializable {

    private Integer id;

    private Integer fid;

    private Integer vid;

    private String remark;

    private String insertDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public FavoritesContent() {
    }

    public FavoritesContent(Integer id, Integer fid, Integer vid, String insertDate, String remark) {
        this.id = id;
        this.fid = fid;
        this.vid = vid;
        this.insertDate = insertDate;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FavoritesContent{" +
                "id=" + id +
                ", fid=" + fid +
                ", vid=" + vid +
                ", remark='" + remark + '\'' +
                ", insertDate='" + insertDate + '\'' +
                '}';
    }
}