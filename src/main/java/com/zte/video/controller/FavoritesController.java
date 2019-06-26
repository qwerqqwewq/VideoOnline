package com.zte.video.controller;

import com.zte.video.entity.Favorites;
import com.zte.video.entity.User;
import com.zte.video.service.FavoritesService;
import com.zte.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    String findFavoritesPageByUser(HttpServletRequest req,Integer uid,Model model){
    User user=new User();
    user = userService.findById()
    List<Favorites> favorites = favoritesService.findById(user);
    model.addAttribute("favorites",favorites);
    return "/favorites/find";
}

}
