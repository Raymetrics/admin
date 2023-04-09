package com.raymetrics.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {

    @RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
    public String main(@RequestParam(required = false) String exampleInputEmail){
        System.out.println(">?>>>"+exampleInputEmail);
        return "index";
    }
}
