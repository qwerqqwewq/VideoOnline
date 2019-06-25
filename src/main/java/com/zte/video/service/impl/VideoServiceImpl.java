package com.zte.video.service.impl;

import com.zte.video.dao.VideoDao;
import com.zte.video.entity.Video;
import com.zte.video.service.VideoService;
import com.zte.video.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 14:03
 * Description:<描述>
 */

@Service//让该类被spring管理，注解有效，注意这里在配置文件中需要扫包
//配置事务,在类上配置事务，该事务作用于类中的所有方法，在方法上配置事务，该事务只作用于该方法
//Propagation.REQUIRED:事务的默认隔离级别,
//rollbackFor = Exception.class:当出现异常时回滚事务
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    /**
     * 查询所有视频
     */
    public List<Video> findAll() {
        return videoDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Video findByTitle(String title) {
        return videoDao.selectByTitle(title);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Video findById(Integer id) {
        return videoDao.selectById(id);
    }

    @Override
    public int modifyVideo(Video video) {
        return videoDao.updateVideo(video);
    }

    @Override
    public int addVideo(Video video) {
        video.setUploadDate(CurrentDate.getCurrentDate());
        return videoDao.insertVideo(video);
    }
}
