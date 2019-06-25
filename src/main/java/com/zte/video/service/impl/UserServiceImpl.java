package com.zte.video.service.impl;

import com.zte.video.dao.UserDao;
import com.zte.video.entity.User;
import com.zte.video.service.UserService;
import com.zte.video.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        user.setRegistDate(CurrentDate.getCurrentDate());
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }
}
