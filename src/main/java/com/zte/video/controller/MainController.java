package com.zte.video.controller;

import com.zte.video.entity.Video;
import com.zte.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Author:helloboy
 * Date:2019-06-25 16:21
 * Description:<描述>
 */
@Controller
public class MainController {
    @Autowired
    private VideoService videoService;


    @RequestMapping("/main")
    String MainPage() {
        return "main";
    }

    @RequestMapping("/play/{id}")
    public String playAction(@PathVariable("id") Integer id,
                             HttpServletResponse response,Model model) {
        Video video = videoService.findById(id);
        String videoUrl = video.getVideoPath();
        model.addAttribute("video", video);
        model.addAttribute("videoUrl", videoUrl);
        return "user/play";
    }

}
