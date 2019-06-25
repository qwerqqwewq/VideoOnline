package com.zte.video.dao;

import com.zte.video.entity.MessageComment;

/**
 * Author:helloboy
 * Date:2019-06-24 17:31
 * Description:<描述>
 */
public interface MessageCommentDao {
    /**
     * 添加对某个留言的回复
     * @param mid
     * @param uid
     * @return
     */
    public MessageComment insertMessageComment();

    /**
     * 查询某个留言下的所有的回复
     */
    public void selectByID(Integer mid);

    /**
     * 删除此留言下的某个回复
     * @param id
     * @return
     */
    public MessageComment deleteMessageComment(Integer id);

}
