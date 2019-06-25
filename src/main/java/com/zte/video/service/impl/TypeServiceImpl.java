package com.zte.video.service.impl;

import com.zte.video.dao.TypeDao;
import com.zte.video.entity.Type;
import com.zte.video.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 14:54
 * Description:<描述>
 */

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Type> findAll() {
        return typeDao.selectAll();
    }

    @Override
    public int addType(Type type) {
        return typeDao.insertType(type);
    }

    @Override
    public int modifyType(Type type) {
        return typeDao.updateType(type);
    }
}
