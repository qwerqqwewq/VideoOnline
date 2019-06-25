package com.zte.video.service;

import com.zte.video.entity.Type;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 14:53
 * Description:<描述>
 */

public interface TypeService {
    /**
     * 查找所有的影片类型
     * @return
     */
    public List<Type> findAll();

    /**
     * 插入一个类型
     * @param type
     * @return
     */
    public int addType(Type type);

    /**
     * 更新一个类型
     * @param type
     * @return
     */
    public int modifyType(Type type);
}
