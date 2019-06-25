package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 10:29
 * Description:<描述>
 */
public class VideoComment implements Serializable{
    private Integer id;
    private String content;
    private String commentDate;
    private Video video;
    private User user;

    public VideoComment() {
    }

    public VideoComment(Integer id, String content, String commentDate, Video video, User user) {
        this.id = id;
        this.content = content;
        this.commentDate = commentDate;
        this.video = video;
        this.user = user;
    }

    @Override
    public String toString() {
        return "VideoComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", video=" + video +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
