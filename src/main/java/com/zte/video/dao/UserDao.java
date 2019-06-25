package com.zte.video.dao;

import com.zte.video.entity.User;

/**
 * Author:helloboy
 * Date:2019-06-24 17:31
 * Description:<描述>
 */
public interface UserDao {
    /**
     * 查询t_user中是否有此用户名存在
     * @param  name
     * @return
     **/
    User checkname(String name);

    /**
     * 查询校对用户名密码并确定正确与否
     * @param name
     * @param pwd
     * @return
     */
    User loadcheck(String name,String pwd);

    /**
     * 查询用户权限
     * @param pid
     * @return
     */
    User selectpower(Integer pid);

    /**
     * 用户注册
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 删除用户信息
     * @param user
     */
    void deleteUser(User user);

}
