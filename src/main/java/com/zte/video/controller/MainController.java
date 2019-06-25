package com.zte.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:helloboy
 * Date:2019-06-25 16:21
 * Description:<描述>
 */
@Controller
public class MainController {

    @RequestMapping("/main")
    String MainPage() {
        return "main";
    }
}
