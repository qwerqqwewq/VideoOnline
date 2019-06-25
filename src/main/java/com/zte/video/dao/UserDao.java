package com.zte.video.dao;

import com.zte.video.entity.User;

/**
 * @Author:helloboy
 * @Date:2019-06-24 17:31
 * Description:<描述>
 */
public interface UserDao {
    /**
     * 根据用户姓名查询
     * @param  name
     * @return
     **/
    public User selectByName(String name);


    /**
     * 用户注册
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

}
