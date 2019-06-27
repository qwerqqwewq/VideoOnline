package com.zte.video.dao;

import com.zte.video.entity.Message;
import com.zte.video.entity.MessageComment;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-24 17:31
 * Description:<描述>
 */
public interface MessageCommentDao {
    /**
     * 添加对某个留言的回复
     * @param message
     * @return
     */
    public MessageComment insertMessageCommentById(Message message);

    /**
     * 查询某个留言下的所有的回复
     * @param message
     * @return
     */
    public List<MessageComment> selectAllByID(Message message);

    /**
     * 删除某条留言下的某个回复
     * @param id
     * @return
     */
    public MessageComment deleteMessageCommentByID(Integer id);
    /**
     * 清空
     * @return
     */
    public int deleteAllMessageComment();
}
