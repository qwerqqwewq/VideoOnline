package com.zte.video.service;

import com.zte.video.entity.User;
import com.zte.video.entity.Video;
import com.zte.video.entity.VideoComment;

import java.util.List;

/**
 * Author:helloboy
 * Date:2019-06-26 9:33
 * Description:<描述>
 */
public interface VideoCommentService {

    /**
     * 插入一条视频评论
     *
     * @param videoComment
     * @return
     */
    public int addVideoComment(VideoComment videoComment);

    /**
     * 更新一条评论，删除操作实际上也是更新操作
     * @param videoComment
     * @return
     */
    public int modifyVideoComment(VideoComment videoComment);

    /**
     * 选择所有评论
     * @return
     */
    public List<VideoComment> findAll();

    /**
     * 根据评论id选择评论
     * @param id
     * @return
     */
    public List<VideoComment> findById(Integer id);

    /**
     * 根据用户选择评论
     * @param user
     * @return
     */
    public List<VideoComment> findByUser(User user);

    /**
     * 根据视频选择评论
     * @param video
     * @return
     */
    public List<VideoComment> findByVideo(Video video);
}
