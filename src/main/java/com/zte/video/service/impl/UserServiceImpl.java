package com.zte.video.service.impl;

import com.zte.video.dao.UserDao;
import com.zte.video.entity.Power;
import com.zte.video.entity.User;
import com.zte.video.service.UserService;
import com.zte.video.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *让该类被spring管理，注解有效，注意这里在配置文件中需要扫包
 *配置事务,在类上配置事务，该事务作用于类中的所有方法，在方法上配置事务，该事务只作用于该方法
 *Propagation.REQUIRED:事务的默认隔离级别,
 *rollbackFor = Exception.class:当出现异常时回滚事务
 */
/**
 * @Author:helloboy
 * @Date:2019-06-25 13:26
 * Description:<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public User findByName(String name){
        return userDao.selectByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public User findPowerByName(String name){
        return userDao.selectPowerByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public User findByID(Integer id){
        return userDao.selectByID(id);
    }

}
