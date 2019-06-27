package com.zte.video.service.impl;

import com.zte.video.dao.VideoCommentDao;
import com.zte.video.dao.VideoDao;
import com.zte.video.entity.User;
import com.zte.video.entity.Video;
import com.zte.video.entity.VideoComment;
import com.zte.video.service.VideoCommentService;
import com.zte.video.utils.CurrentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-26 9:38
 * Description:<描述>
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class VideoCommentServiceImpl implements VideoCommentService {
    @Autowired
    VideoCommentDao videoCommentDao;

    @Override
    public int addVideoComment(VideoComment videoComment) {
        String time = CurrentDate.getCurrentDate();
        videoComment.setCommentDate(time);
        return videoCommentDao.insertVideoComment(videoComment);
    }

    @Override
    public int modifyVideoComment(VideoComment videoComment) {
        String time = CurrentDate.getCurrentDate();
        videoComment.setCommentDate(time);
        return videoCommentDao.updateVideoComment(videoComment);
    }

    @Override
    public List<VideoComment> findAll() {
        return videoCommentDao.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)

    public List<VideoComment> findById(Integer id) {
        return videoCommentDao.selectById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<VideoComment> findByUser(User user) {
        return videoCommentDao.selectByUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<VideoComment> findByVideo(Video video) {
        return videoCommentDao.selectByVideo(video);
    }

    @Override
    public int removeById(Integer id) {
        return videoCommentDao.deleteById(id);
    }
}
