package com.raymetrics.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewsController {
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String news(){
        return "/main/news";
    }

    @RequestMapping(value = "/regist/news", method = RequestMethod.GET)
    public String registNews(){
        return "/main/registNews";
    }

}
