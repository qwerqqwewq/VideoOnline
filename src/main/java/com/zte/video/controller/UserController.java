package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Power;
import com.zte.video.entity.User;
import com.zte.video.service.PowerService;
import com.zte.video.service.UserService;
import com.zte.video.utils.CurrentDate;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    String login(HttpServletRequest req,String name,String pwd)throws InvocationTargetException,IllegalAccessException{
        Map map=new HashMap<>();
        Gson gson =new Gson();
        User user = new User();
        BeanUtils.populate(user,req.getParameterMap());
        user.setName(name);
        if (userService.findByName(name)!=null){
            if (userService.findByName(user.getName()).getPwd().toString().equals(pwd)){
                String a="管理员";
                if (userService.findPowerByName(user.getName()).toString().equals(a)) {
                    return "video/insert";
                }else {
                    return "main";
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
            user.setPwd(pwd);
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
