package com.zte.video.controller;

import com.zte.video.entity.Video;
import com.zte.video.entity.VideoComment;
import com.zte.video.service.VideoCommentService;
import com.zte.video.service.VideoService;
import com.zte.video.utils.LocalMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2019-06-25 16:21
 * Description:<描述>
 */
@Controller
public class MainController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoCommentService videoCommentService;

    @RequestMapping("/main")
    String MainPage() {
        return "main";
    }

    @RequestMapping("/play/{id}")
    public String playAction(@PathVariable("id") Integer id,
                             HttpServletResponse response, Model model) {
        Video video = videoService.findById(id);
        model.addAttribute("video", video);
        List<VideoComment> comments = videoCommentService.findByVideo(video);
        model.addAttribute("videoComments", comments);
        return "user/play";
    }

    @RequestMapping("/pop/{id}")
    public String popAction(Model model, @PathVariable("id") Integer id) {
        Map<Integer,String> map = LocalMedia.getLocalMediaMap();
        String path = map.get(id);
        model.addAttribute("path", path);
        model.addAttribute("maps", map);
        return "pop";
    }

    @RequestMapping("/pop")
    public String getPop(Model model) {
        Map<Integer,String> map = LocalMedia.getLocalMediaMap();
        model.addAttribute("maps", map);
        return "pop";
    }

}
