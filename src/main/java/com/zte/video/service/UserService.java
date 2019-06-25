package com.zte.video.service;

import com.zte.video.entity.User;

/**
 * @Author:helloboy
 * @Date:2019-06-25 10:14
 * Description:<描述>
 */
public interface UserService {
    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    public User findByName(String name);

    /**
     * 插入一条用户数据（用于用户注册）
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int modifyUser(User user);



}
