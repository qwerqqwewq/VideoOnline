package com.zte.video.entity;

/**
 * Author:helloboy
 * Date:2019-06-25 10:27
 * Description:<描述>
 */
public class MessageComment {
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public MessageComment(){
    }

    public MessageComment(Integer id,String content,Integer mid,Integer uid,String commentDate){
        this.id=id;
        this.content=content;
        this.mid=mid;
        this.uid=uid;
        this.commentDate=commentDate;
    }

    private Integer id;
    private String content;
    private Integer mid;
    private Integer uid;
    private String commentDate;



}
