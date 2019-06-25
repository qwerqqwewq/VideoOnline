package com.zte.video.service;

import com.zte.video.entity.User;

/**
 * @Author:helloboy
 * @Date:2019-06-25 10:14
 * Description:<描述>
 */
public interface UserService {
    /**
     * 判断用户名是否存在
     * @param name
     * @return
     */
    public User findByName(String name);

    /**
     * 判断是否
     */
}
