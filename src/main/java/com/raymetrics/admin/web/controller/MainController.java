package com.raymetrics.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        System.out.println(">>>>>>>>>>>>>>>>>>>로그인 들어옴");
        return "main/login";
    }

    @RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
    public String memberInfo(){
        return "/main/member/memberInfo";
    }

    @RequestMapping(value = "/memberEdit", method = RequestMethod.GET)
    public String memberEdit(){
        return "/main/member/memberEdit";
    }


//    @RequestMapping(value = "/inquiryBoard", method = RequestMethod.GET)
//    public String inquiry(){
//        return "/main/inquiryBoard";
//    }

  /*  @RequestMapping(value = "/auth", method = {RequestMethod.POST, RequestMethod.GET})
    public String auth(@RequestParam String email, @RequestParam String password){
        System.out.println("로그인됨");
        return "index";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object test(){
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return "/main/blank";
    }*/
}
