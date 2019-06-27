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

    private String inserDate;

    public Integer getFId() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getid() {
        return id;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setId(Integer vid) {
        this.vid = vid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInserDate() {
        return inserDate;
    }

    public void setInserDate(String inserDate) {
        this.inserDate = inserDate;
    }

    public FavoritesContent() {
    }

    public FavoritesContent(Integer id, Integer vid, Integer fid, Integer uid, String remark, String inserDate) {
        this.id = id;
        this.remark = remark;
        this.vid = vid;
        this.fid = fid;
        this.inserDate = inserDate;
    }
}