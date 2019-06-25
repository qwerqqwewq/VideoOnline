package com.zte.video.dao;

import com.zte.video.entity.Message;

import java.util.Set;

/**
 * Author:helloboy
 * Date:2019-06-24 17:31
 * Description:<描述>
 */
public interface MessageDao {

    /**
     * 查询留言板的所有留言
     * @return
     */
    public Set<Message> selectAll();


    /**
     * 根据id查询留言板的留言
     * @return
     */
    public Message selectByID(Integer id);


    /**
     * 添加留言
     */
    public void insertMessage(Message message);

    /**
     * 删除评论
     */
    public void deleteMessage(Message message);
}
