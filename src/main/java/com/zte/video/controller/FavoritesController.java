package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.User;
import com.zte.video.service.FavoritesService;
import com.zte.video.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Author:helloboy
 * Date:2019-06-26 10:29
 * Description:<描述>
 */
@Controller
@RequestMapping("/favorites")
public class FavoritesController {
    @Autowired
    FavoritesService favoritesService;
    UserService userService;
@RequestMapping("/findByUser")
    String findFavoritesPageByUser(Integer uid,Model model){
    User user=new User();
    user = userService.findByID(uid);
    List<Favorites> favorites = favoritesService.findById(uid);
    model.addAttribute("favorites",favorites);
    return "/favorites/find";
}
    @RequestMapping("/insert.do")
    @ResponseBody
    String insertFavorites(HttpServletRequest req,Integer uid)  throws InvocationTargetException, IllegalAccessException{
        Favorites favorites=new Favorites();
        User user=new User();
        BeanUtils.populate(favorites, req.getParameterMap());
        user.setId(uid);
        favorites.setUser(user);
        Gson gson = new Gson();
        Map map=new HashMap();
        if(favoritesService.findById(uid)==null){
            map.put("result",favoritesService.addFavorites(favorites));
            map.put("msg","插入成功");
        }else
        {
            map.put("result",-1);
            map.put("msg","插入失败");
        }
        return gson.toJson(map);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    String updateFavorites(HttpServletRequest req,Integer uid)throws InvocationTargetException, IllegalAccessException{
        Favorites favorites=new Favorites();
        BeanUtils.populate(favorites, req.getParameterMap());
        User user=new User();
        user.setId(uid);
        favorites.setUser(user);
        Gson gson = new Gson();
        Map map=new HashMap();
            map.put("result",favoritesService.modifyFavorites(favorites));
            map.put("msg","插入成功");
        return gson.toJson(map);
    }
    @RequestMapping("/delete")
    String deleteFavorites(Integer fid){
        Favorites favorites=new Favorites();
        favorites.setId(fid);
        favoritesService.updateFavorites(favorites);
        return "/favorites/delete";

    }


}
