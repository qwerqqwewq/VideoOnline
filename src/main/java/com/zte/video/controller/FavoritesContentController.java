package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;
import com.zte.video.service.FavoritesContentService;
import com.zte.video.service.FavoritesService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


/**
 * Author:helloboy
 * Date:2019-06-26 10:38
 * Description:<描述>
 */
@RequestMapping("/favoritescontent")
public class FavoritesContentController {

    @Autowired
    private FavoritesContentService favoritesContentService;

    @Autowired
    private FavoritesService favoritesService;

    /**
     * 判断是否有重复的视频
     */
    private boolean confirmId(Integer vid){
        if (favoritesContentService.findAllById()== vid){
            return false;
        }else {
            return true;
        }
    }
    @RequestMapping(value = "/insert.do")
    /**
     * 添加视频至收藏夹
     */
    public String insertAction(HttpServletRequest req, Integer id)throws InvocationTargetException,IllegalAccessException{
        FavoritesContent favoritesContent = new FavoritesContent();
        BeanUtils.populate(favoritesContent, req.getParameterMap());
        Favorites favorites = new Favorites();
        favorites.getUid(id);
        favoritesContent.getVid(id);
        Map map=new HashMap<>(1);
        Gson gson =new Gson();
        map.put("result", favoritesContentService.addFavoritesContent(favoritesContent));
        //返回结果
        return gson.toJson(map);
    }
    String loginpage(){
        return "insert/insert";
    }
    @RequestMapping(value = "/update.do")
    /**
     * 修改收藏夹中视频备注
     */
    @ResponseBody
    public String updateAction(HttpServletRequest req,Integer id) throws InvocationTargetException, IllegalAccessException {
        FavoritesContent favoritesContent = new FavoritesContent();
        BeanUtils.populate(favoritesContent, req.getParameterMap());
        Favorites favorites = new Favorites();
        favorites.getUid(id);
        favoritesContent.getVid(id);
        Map map=new HashMap<>(1);
        Gson gson =new Gson();
        map.put("result", favoritesContentService.addFavoritesContent(favoritesContent));
        return gson.toJson(map);
    }

    /**
     * 删除选中的视频
     */

}

