package com.zte.video.controller;

import com.google.gson.Gson;
import com.zte.video.entity.Power;
import com.zte.video.entity.User;
import com.zte.video.service.PowerService;
import com.zte.video.service.UserService;
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
    @RequestMapping(value = "/login.do")
    private String login(HttpServletRequest req,String username,String password)throws InvocationTargetException,IllegalAccessException{
        User user = new User();
        Power power=new Power();
        BeanUtils.populate(user,req.getParameterMap());
        BeanUtils.populate(power,req.getParameterMap());
        Map map=new HashMap<>();
        Gson gson =new Gson();
        user.setName(username);
        user.setPower(power);
        if (userService.findByName(username)!=null){
            if (userService.findByName(username).getPwd().toString().equals(password)){
                String a="管理员";
                if (userService.findByName(username).getPower().getPower().toString().equals(a)) {
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
    @RequestMapping(value = "/regist")
    private String regist(HttpServletRequest req)throws InvocationTargetException,IllegalAccessException{
        User user=new User();
        BeanUtils.populate(user,req.getParameterMap());
        String name=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        String tpwd=req.getParameter("tpwd");
        if (pwd==tpwd){
            if(userService.findByName(name)!=null){
                userService.addUser(user);
                return "success";
            }else {
                return "该用户名已存在";
            }
        }else {
            return "两次密码不相同";
        }
    }
}
