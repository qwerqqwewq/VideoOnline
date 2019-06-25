package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 10:24
 * Description:<描述>
 */
public class Video implements Serializable{
    private Integer id;
    private String title;
    private String picPath;
    private String videoPath;
    private Type type;
    private String videoTime;
    private String intro;
    private String uploadDate;

    public Video() {
    }

    public Video(Integer id, String title, String picPath, String videoPath, Type type, String videoTime, String intro, String uploadDate) {
        this.id = id;
        this.title = title;
        this.picPath = picPath;
        this.videoPath = videoPath;
        this.type = type;
        this.videoTime = videoTime;
        this.intro = intro;
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", picPath='" + picPath + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", type=" + type +
                ", videoTime='" + videoTime + '\'' +
                ", intro='" + intro + '\'' +
                ", uploadDate='" + uploadDate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
}
