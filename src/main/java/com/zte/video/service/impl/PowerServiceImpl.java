package com.zte.video.service.impl;

import com.zte.video.dao.PowerDao;
import com.zte.video.entity.Power;
import com.zte.video.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:helloboy
 * @Date:2019-06-25 13:28
 * Description:<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class PowerServiceImpl implements PowerService {
    @Autowired
    private PowerDao powerDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Power findPowerByID(Integer id){
        return powerDao.selectPowerByID(id);
    }
}
