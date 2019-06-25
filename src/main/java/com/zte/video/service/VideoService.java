package com.zte.video.service;

import com.zte.video.entity.Video;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-25 14:02
 * Description:<描述>
 */
public interface VideoService {
    //选择所有视频
    public List<Video> findAll();

    //根据名称查找视频
    public Video findByTitle(String title);

    //修改视频
    public int modifyVideo(Video video);

    //插入视频
    public int addVideo(Video video);
}
