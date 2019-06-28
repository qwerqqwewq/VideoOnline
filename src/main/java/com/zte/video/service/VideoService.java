package com.zte.video.service;

import com.zte.video.entity.Video;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-25 14:02
 * Description:<描述>
 */
public interface VideoService {
    /**
     * 选择所有视频
     * @return
     */
    public List<Video> findAll();

    /**
     * 根据名称查找视频
     * @param title
     * @return
     */
    public Video findByTitle(String title);

    /**
     * 根据id查找视频
     * @param id
     * @return
     */
    public Video findById(Integer id);

    /**
     * 修改视频
     * @param video
     * @return
     */
    public int modifyVideo(Video video);

    /**
     * 插入视频
     * @param video
     * @return
     */
    public int addVideo(Video video);

    /**
     * 下架视频
     * @param id 视频id
     * @return
     */
    public int removeVideo(Integer id);
}
