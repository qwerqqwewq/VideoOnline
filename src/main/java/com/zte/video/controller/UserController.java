package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Power;
import com.zte.video.entity.User;
import com.zte.video.service.PowerService;
import com.zte.video.service.UserService;
import com.zte.video.utils.CurrentDate;
import com.zte.video.utils.MD5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:helloboy
 * @Date:2019-06-25 10:14
 * Description:<描述>
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PowerService powerService;

    /**
     * 判断用户名是否重复
     */
    private boolean confirmName(String name){
        if (userService.findByName(name)==null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 登录判断
     *  1、是否有此用户
     *  2、该用户对应的密码是否正确
     *
     */
    @RequestMapping( "/login.do")
    String login(HttpServletRequest req,String name,String pwd,Model model)throws InvocationTargetException,IllegalAccessException{
        Map map=new HashMap<>();
        Gson gson =new Gson();
        User user = userService.findByName(name);
        String mpwd= MD5Util.MD5Encode(pwd);
        if (user!=null){
            if (mpwd.equals(user.getPwd())){
                String a="管理员";
                if (user.getPower().getPower().equals(a)) {
                    model.addAttribute("user", user);
                    return "main";
                }else {
                    model.addAttribute("user", user);
                    return "video/page";
                }
            }else {
                map.put("msg","用户名或密码不正确");
            }
        }else {
            map.put("msg","用户名不正确");
        }
        return gson.toJson(map);
    }

    @RequestMapping("/login")
    String loginpage(){
        return "login/login";
    }

    /**
     * 注册表
     * 1、判断用户输入的两次密码是否一致
     * 2、判断该用户名是否已存在
     * 3、通过提交向user表中插入用户信息
     */
    @RequestMapping(value = "/regist.do")
    private String regist(HttpServletRequest req,String pwd,String tpwd)throws InvocationTargetException,IllegalAccessException{
        Map map = new HashMap<>();
        Gson gson = new Gson();
        if (pwd.equals(tpwd)) {
            User user = new User();
            BeanUtils.populate(user, req.getParameterMap());
            Power power = new Power();
            String name = req.getParameter("name");
            user.setName(name);
            String mpwd =MD5Util.MD5Encode(pwd);
            user.setPwd(mpwd);
            user.setRegistDate(CurrentDate.getCurrentDate());
            if (userService.findByName(name)==null) {
                userService.addUser(user);
                return "regist/success";
            } else {
                map.put("msg", "该用户名已存在");
            }
        }else {
            map.put("msg","两次密码不相同");
        }
        return gson.toJson(map);
    }

    @RequestMapping("/regist")
    String registpage(){
        return "regist/regist";
    }
}
