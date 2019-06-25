package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Type;
import com.zte.video.entity.Video;
import com.zte.video.service.TypeService;
import com.zte.video.service.VideoService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2019-06-25 16:05
 * Description:<描述>
 */
@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private TypeService typeService;

    @PostMapping("/insert.do")
    String insertVideo(HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        Video video = new Video();
        BeanUtils.populate(video,req.getParameterMap());

        Gson gson = new Gson();
        Map map = new HashMap();
        map.put("result", videoService.addVideo(video));
        return gson.toJson(map);
    }

    @RequestMapping("/page")
    String mainPage(Model model) {
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        return  "video/page";
    }
}
