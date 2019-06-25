package com.zte.video.dao;

import com.zte.video.entity.Message;

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
    Message selectAll(Integer id);

    /**
     * 添加评论
     */
    void addMessage();

    /**
     * 删除评论
     */
    void deleteMessage();
}
