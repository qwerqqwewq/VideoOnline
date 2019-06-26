package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.User;
import com.zte.video.entity.Video;
import com.zte.video.entity.VideoComment;
import com.zte.video.service.VideoCommentService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tr
 * Date:2019-06-26 9:48
 * Description:<描述>
 */
@Controller
@RequestMapping("/videoComment")
public class VideoCommentController {
    @Autowired
    private VideoCommentService videoCommentService;

    @RequestMapping("/insert.do")
    @ResponseBody
    public String insertAction(HttpServletRequest req,Integer uid,Integer vid) throws InvocationTargetException, IllegalAccessException {
        //配置基础内容
        VideoComment videoComment = new VideoComment();
        BeanUtils.populate(videoComment,req.getParameterMap());
        //配置对应视频
        Video video = new Video();
        video.setId(vid);
        videoComment.setVideo(video);
        //配置对应评论人
        User user = new User();
        user.setId(uid);
        videoComment.setUser(user);
        //配置json信息
        Gson gson = new Gson();
        Map map = new HashMap<>(1);
        map.put("result", videoCommentService.addVideoComment(videoComment));
        //返回结果
        return gson.toJson(map);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public String updateAction(HttpServletRequest req,Integer uid,Integer vid) throws InvocationTargetException, IllegalAccessException {
        //配置基础内容
        VideoComment videoComment = new VideoComment();
        BeanUtils.populate(videoComment,req.getParameterMap());
        //配置对应视频
        Video video = new Video();
        video.setId(vid);
        videoComment.setVideo(video);
        //配置对应评论人
        User user = new User();
        user.setId(uid);
        videoComment.setUser(user);
        //配置json信息
        Gson gson = new Gson();
        Map map = new HashMap<>(1);
        map.put("result", videoCommentService.modifyVideoComment(videoComment));
        //返回结果
        return gson.toJson(map);
    }


}
