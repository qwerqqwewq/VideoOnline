package com.zte.video.dao;

import com.zte.video.entity.Power;

/**
 * @Author:helloboy
 * @Date:2019-06-24 17:31
 * Description:<描述>
 */
public interface PowerDao {
    /**
     * 根据ID查询权限值
     * @param id
     * @return
     */
    public Power selectPowerByID(Integer id);

    /**
     * 根据name查询权限值
     * @param name
     * @return 
     */
    public Power selectPowerByName(String name);
}
