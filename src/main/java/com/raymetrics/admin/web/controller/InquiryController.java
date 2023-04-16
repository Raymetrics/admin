package com.raymetrics.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InquiryController {

    @RequestMapping(value = "/inquiryBoard", method = RequestMethod.GET)
    public String inquiry(){
        return "/main/inquiry/inquiryBoard";
    }


    @RequestMapping(value = "/regist/inquiry", method = RequestMethod.GET)
    public String registInquiry(){
        return "/main/inquiry/registInquiry";
    }

    @RequestMapping(value = "/inquiryDetail/{id}", method = RequestMethod.GET)
    public String newsDetail(@PathVariable("id") Long id, ModelMap model) throws Exception{
        String title = "";
        String content = "";
        String writer = "";
        if (id == 1) {
            title = "섬광체 견적 문의";
            writer = "박은지";
        }else if(id == 2){
            title = "문의하기 제목2";
            writer = "김철수";
        }else if(id == 3){
            title = "문의하기 제목3";
            writer = "김은정";
        }else if(id == 4){
            title = "문의하기 제목4";
            writer = "이제인";
        }else if(id == 5){
            title = "문의하기 제목5";
            writer = "홍길동";
        }
        content = title + " 본문 내용";

        model.put("id", id);
        model.put("title", title);
        model.put("content", content);
        model.put("writer", writer);

        return "/main/inquiry/inquiryDetail";
    }

    @RequestMapping(value = "/regist/delete", method = RequestMethod.GET)
    public String deleteInquiry(){
        return "/main/inquiryBoard";
    }
}
