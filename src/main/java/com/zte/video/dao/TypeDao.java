package com.zte.video.dao;

import com.zte.video.entity.Type;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 14:40
 * Description:<描述>
 */
public interface TypeDao {
    /**
     * 查找所有的影片类型
     * @return
     */
    public List<Type> selectAll();

    /**
     * 插入一个类型
     * @param type
     * @return
     */
    public int insertType(Type type);

    /**
     * 更新一个类型
     * @param type
     * @return
     */
    public int updateType(Type type);

    /**
     * 删除一个类型
     * 未设置级联删除，禁止使用
     * @param id
     * @return
     */
    public int deleteType(Integer id);
}
