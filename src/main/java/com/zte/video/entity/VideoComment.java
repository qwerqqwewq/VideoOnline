package com.zte.video.entity;

/**
 * Author:helloboy
 * Date:2019-06-25 10:29
 * Description:<描述>
 */
public class VideoComment {
    private Integer id;
    private String content;
    private String commentDate;
    private Integer vid;
    private Integer uid;

    public VideoComment() {
    }

    public VideoComment(Integer id, String content, String commentDate, Integer vid, Integer uid) {
        this.id = id;
        this.content = content;
        this.commentDate = commentDate;
        this.vid = vid;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "VideoComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", vid=" + vid +
                ", uid=" + uid +
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

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
