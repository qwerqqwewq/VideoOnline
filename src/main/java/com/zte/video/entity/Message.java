package com.zte.video.entity;

import java.io.Serializable;

/**
 * Author:helloboy
 * Date:2019-06-25 9:16
 * Description:<描述>
 */
public class Message implements Serializable {

    private Integer id;

    private String content;

    private String messageDate;

    private Integer uid;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public Message(){
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

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Message(Integer id,String content,String messageDate,Integer uid,User user){
        this.id=id;
        this.content=content;
        this.messageDate=messageDate;
        this.uid=uid;
        this.user=user;
    }

}
