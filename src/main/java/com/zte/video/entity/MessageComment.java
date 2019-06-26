package com.zte.video.entity;

/**
 * @Author:helloboy
 * @Date:2019-06-25 10:27
 * Description:<描述>
 */
public class MessageComment {
    private Integer id;

    private String content;

    private User user;

    private String commentDate;

    public MessageComment() {
    }

    public MessageComment(Integer id, String content, User user, String commentDate) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "MessageComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", commentDate='" + commentDate + '\'' +
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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
}
