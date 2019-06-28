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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
    public String insertVideo(HttpServletRequest req, Integer typeId) throws Exception {
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

    @RequestMapping("/img/{id}")
    @ResponseBody
    public String requestImg(@PathVariable("id") Integer id
    ,HttpServletResponse response) throws IOException {
        String imgFile = videoService.findById(id).getPicPath();
        FileInputStream fileIs=null;
        try {
            fileIs = new FileInputStream(imgFile);
        } catch (Exception e) {
            return "fail";
        }
        //得到文件大小
        int i=fileIs.available();
        byte[] data=new byte[i];
        //读数据
        fileIs.read(data);
        //设置返回的文件类型
        response.setContentType("image/*");
        //得到向客户端输出二进制数据的对象
        OutputStream outStream=response.getOutputStream();
        //输出数据
        outStream.write(data);
        outStream.flush();
        outStream.close();
        fileIs.close();
        return "ok";
    }

    @RequestMapping("/update.do/{id}")
    @ResponseBody
    public String updateVideo(HttpServletRequest req,
                              Integer typeId,
                              @PathVariable("id") Integer id)
            throws InvocationTargetException, IllegalAccessException {
        Video video = new Video();
        BeanUtils.populate(video, req.getParameterMap());
        //视频id
        video.setId(id);
        //类型
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

    @RequestMapping("/remove.do/{id}")
    @ResponseBody
    public String removeAction(@PathVariable("id") Integer id) {
        Gson gson = new Gson();
        Map map = new HashMap(1);
        map.put("result", videoService.removeVideo(id));
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

    @RequestMapping("/updateVideo/{id}")
    String updateVideoPage(Model model,
                           @PathVariable("id") Integer id) {
        Video video = videoService.findById(id);
        model.addAttribute("video", video);
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        return "video/update";
    }
}
