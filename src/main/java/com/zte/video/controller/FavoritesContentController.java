package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;
import com.zte.video.service.FavoritesContentService;
import com.zte.video.service.FavoritesService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author:helloboy
 * Date:2019-06-26 10:38
 * Description:<描述>
 */
@Controller
@RequestMapping("/favoritescontent")
public class FavoritesContentController {

    @Autowired
    private FavoritesContentService favoritesContentService;

    @Autowired
    private FavoritesService favoritesService;

    /**
     * 判断是否有重复的视频
     */
    private boolean confirmId(Favorites favorites,Integer vid){
        List<FavoritesContent> favoritesContents = favoritesContentService.findAllById(favorites);
        boolean hasSame = false;
        for (FavoritesContent favoritesContent : favoritesContents) {
            if (favoritesContent.getVideo().getId().equals(vid)) {
                hasSame = true;
                break;
            }
        }
        return hasSame;
    }
    @RequestMapping("/insert.do")
    /**
     * 添加视频至收藏夹
     */
    public String insertAction(HttpServletRequest req)throws InvocationTargetException,IllegalAccessException{
        FavoritesContent favoritesContent = new FavoritesContent();
        BeanUtils.populate(favoritesContent, req.getParameterMap());
        Map map=new HashMap<>(1);
        Gson gson =new Gson();
        map.put("result", favoritesContentService.addFavoritesContent(favoritesContent));
        //返回结果
        return gson.toJson(map);
    }

    @RequestMapping("/insertPage")
    String loginpage(){
        return "insert/insert";
    }

    /**
     * 修改收藏夹中视频备注
     */
    @RequestMapping("/update.do")
    public String updateAction(HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        FavoritesContent favoritesContent = new FavoritesContent();
        BeanUtils.populate(favoritesContent, req.getParameterMap());
        Map map=new HashMap<>(1);
        Gson gson =new Gson();
        map.put("result", favoritesContentService.modifyFavoritesContent(favoritesContent));
        return gson.toJson(map);
    }


    /**
     * 删除选中的视频
     */
    @RequestMapping("/delete.do")
    public String deleteAction(HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        FavoritesContent favoritesContent = new FavoritesContent();
        BeanUtils.populate(favoritesContent, req.getParameterMap());
        Map map=new HashMap<>(1);
        Gson gson =new Gson();
        map.put("result", favoritesContentService.removeFavoritesContent(favoritesContent));
        return gson.toJson(map);
    }
     @RequestMapping("/favoritescontent")
    public String showFavoritesContent(){
        return "favoritescontent/page";
    }
}

