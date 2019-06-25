package com.zte.video.dao;

import com.zte.video.entity.Message;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-24 17:31
 * Description:<描述>
 */
public interface MessageDao {

    /**
     * 查询留言板的所有留言
     * @return
     */
    public List<Message> selectAll();


    /**
     * 根据id查询留言板的留言
     * @param id
     * @return
     */
    public Message selectByID(Integer id);


    /**
     * 添加留言
     * @param message
     */
    public void insertMessage(Message message);

    /**
     * 删除评论
     * @param message
     */
    public void deleteMessage(Message message);
}
