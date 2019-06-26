package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Type;
import com.zte.video.entity.Video;
import com.zte.video.service.TypeService;
import com.zte.video.service.VideoService;
import com.zte.video.utils.MediaUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/insert.do")
    @ResponseBody
    String insertVideo(HttpServletRequest req, Integer typeId) throws Exception {
        Video video = new Video();
        Gson gson = new Gson();
        Map map = null;
        //进行保存和转码操作
        map = MediaUtils.uploadMedia(req, video);
        System.out.println(map);
        Object flag = map.get("upload");
        if (flag != null && (boolean) flag) {
            System.out.println(video);
            map.put("result", videoService.addVideo(video));
            map.put("video", video);
        }
        return gson.toJson(map);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    String updateVideo(HttpServletRequest req, Integer typeId) throws InvocationTargetException, IllegalAccessException {
        Video video = new Video();
        BeanUtils.populate(video, req.getParameterMap());
        Type type = new Type();
        type.setId(typeId);
        video.setType(type);
        Gson gson = new Gson();
        Map map = new HashMap();
        //查看是否存在对应记录
        if (videoService.findById(video.getId())!=null) {
            //进行修改操作
            map.put("result", videoService.modifyVideo(video));
            map.put("msg", "有对应记录");
        }
        else {
            map.put("result", -1);
            map.put("msg", "无对应记录");
        }
        return gson.toJson(map);
    }

    @RequestMapping("/page")
    String mainPage() {

        return "video/page";
    }

    @RequestMapping("/insertVideo")
    String insertVideoPage(Model model) {
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        System.out.println(types);
        return "video/insert";
    }

    @RequestMapping("/findVideo")
    String findVideoPage(Model model) {
        List<Video> videos = videoService.findAll();
        model.addAttribute("videos",videos);

        return "video/find";
    }

    @RequestMapping("/updateVideo")
    String updateVideoPage(Model model) {
        List<Video> videos = videoService.findAll();
        model.addAttribute("videos",videos);

        return "video/update";
    }
}
