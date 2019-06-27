package com.zte.video.dao;

import com.zte.video.entity.User;
import com.zte.video.entity.Video;
import com.zte.video.entity.VideoComment;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-26 8:33
 * Description:<描述>
 */
public interface VideoCommentDao {

    /**
     * 插入一条视频评论
     *
     * @param videoComment
     * @return
     */
    public int insertVideoComment(VideoComment videoComment);

    /**
     * 更新一条评论，删除操作实际上也是更新操作
     * @param videoComment
     * @return
     */
    public int updateVideoComment(VideoComment videoComment);

    /**
     * 选择所有评论
     * @return
     */
    public List<VideoComment> selectAll();

    /**
     * 根据评论id选择评论
     * @param id
     * @return
     */
    public List<VideoComment> selectById(Integer id);

    /**
     * 根据用户选择评论
     * @param user
     * @return
     */
    public List<VideoComment> selectByUser(User user);

    /**
     * 根据视频选择评论
     * @param video
     * @return
     */
    public List<VideoComment> selectByVideo(Video video);

    /**
     * 根据id删除视频评论
     * @param id 视频评论
     * @return
     */
    public int deleteById(Integer id);

}
