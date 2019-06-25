package com.zte.video.dao;

import com.zte.video.entity.Video;

import java.util.List;

/**
 * @Author:helloboy
 * @Date:2019-06-25 11:56
 * Description:<描述>
 */
public interface VideoDao {
    /**
     * 选择所有视频
     * @return
     */
    public List<Video> selectAll();

    /**
     * 根据名称查找视频
     * @param title
     * @return
     */
    public Video selectByTitle(String title);

    /**
     * 根据id查找视频
     * @param id
     * @return
     */
    public Video selectById(Integer id);

    /**
     * 修改视频
     * @param video
     * @return
     */
    public int updateVideo(Video video);

    /**
     * 插入视频
     * @param video
     * @return
     */
    public int insertVideo(Video video);



}
