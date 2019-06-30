package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Favorites;
import com.zte.video.entity.FavoritesContent;
import com.zte.video.entity.User;
import com.zte.video.service.FavoritesContentService;
import com.zte.video.service.FavoritesService;
import com.zte.video.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    UserService userService;
    @Autowired
    FavoritesContentService favoritesContentService;


@RequestMapping("/findByUser")
    String findFavoritesPageByUser(Model model,HttpServletRequest req){
    HttpSession session=req.getSession();
    User user=(User)session.getAttribute("user");
    user = userService.findByID(user.getId());
    List<Favorites> favorites = favoritesService.findById(user);
    model.addAttribute("favorites",favorites);
    return "/favorites/find";
}
    @RequestMapping("/insert.do")
    @ResponseBody
    String insertFavorites(HttpServletRequest req)  throws InvocationTargetException, IllegalAccessException{
        Favorites favorites=new Favorites();
        User user=new User();
        HttpSession session=req.getSession();
        user=(User)session.getAttribute("user");
        BeanUtils.populate(favorites, req.getParameterMap());
        favorites.setUser(user);
        Gson gson = new Gson();
        Map map=new HashMap();
        map.put("result",favoritesService.addFavorites(favorites));

        return gson.toJson(map);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    String updateFavorites(HttpServletRequest req)throws InvocationTargetException, IllegalAccessException{
        Favorites favorites=new Favorites();
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        BeanUtils.populate(favorites, req.getParameterMap());
        favorites.setUser(user);
        Gson gson = new Gson();
        Map map=new HashMap();
            map.put("result",favoritesService.modifyFavorites(favorites));
            map.put("msg","插入成功");
        return gson.toJson(map);
    }


    @RequestMapping("/delete.do")
    @ResponseBody
    String deleteFavorites(Integer id){

        Favorites favorites=new Favorites();
        favorites.setId(id);

        Gson gson=new Gson();
        Map map=new HashMap<>();
        if(favorites.getId()==null)
        {
            map.put("msg","删除失败");
        }else {
            List<FavoritesContent> favoritesContents = favoritesContentService.findAllById(favorites);
            for (FavoritesContent favoritesContent : favoritesContents) {
                favoritesContentService.removeFavoritesContent(favoritesContent);
            }
            favoritesService.removeFavorites(id);

            map.put("msg", "删除成功");
        }
        return gson.toJson(map);

    }


    @RequestMapping("/update")
    String updateFavorites(){
        return "/favorites/update";
    }

    @RequestMapping("/delete")
    String deleteFavorites(Model model,HttpServletRequest req){
            HttpSession session=req.getSession();
            User user=(User)session.getAttribute("user");
            user = userService.findByID(user.getId());
            List<Favorites> favorites = favoritesService.findById(user);
            model.addAttribute("favorites",favorites);
        return "/favorites/delete";
    }
    @RequestMapping("/insert")
    String insertFavorites(){
        return "/favorites/insert";
    }


}
