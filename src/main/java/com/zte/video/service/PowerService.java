package com.zte.video.service;

import com.zte.video.entity.Power;

/**
 * @Author:helloboy
 * @Date:2019-06-25 13:28
 * Description:<描述>
 */
public interface PowerService {
    /**
     * 根据id查询对应的power值
     * @param id
     * @return
     */
    public Power findPowerByID(Integer id);


    /**
     * 根据姓名查询权限值
     * @param name
     * @return
     */
    public Power findPowerByName(String name);
}
