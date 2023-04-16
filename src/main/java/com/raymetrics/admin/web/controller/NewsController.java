package com.raymetrics.admin.web.controller;

import org.apache.ibatis.annotations.Case;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewsController {
    @RequestMapping(value = "/news/list", method = RequestMethod.GET)
    public String news(){
        return "/main/news/news";
    }

    @RequestMapping(value = "/regist/news", method = RequestMethod.GET)
    public String registNews(){
        return "/main/news/newsRegist";
    }

    @RequestMapping(value = "/newsDetail/{id}", method = RequestMethod.GET)
    public String newsDetail(@PathVariable("id") Long id, ModelMap model) throws Exception{
        String title = "";
        String content = "";
        String date = "";
        if (id == 7) {
            title = "쿼리연구소 수출";
        }else if(id == 6){
            title = "서울대학교병원 MOU";
        }else if(id == 5){
            title = "레이메트릭스 국내 섬광체 최초 국산화";
        }else if(id == 4){
            title = "보조선량계 신제품 출시";
        }else if(id == 3){
            title = "캐리마와 MOU";
        }else if(id == 2){
            title = "FTA 체결";
        }else if(id == 1){
            title = "레이메트릭스 첫 수출";
        }
        content = title + " 본문 내용";

        model.put("id", id);
        model.put("title", title);
        model.put("content", content);

        return "/main/news/newsDetail";
    }

    @RequestMapping(value = "/news/edit/{id}", method = RequestMethod.GET)
    public String editNews(@PathVariable("id") Long id, ModelMap model){
        String title = "";
        String content = "";
        String date = "";
        if (id == 7) {
            title = "쿼리연구소 수출";
        }else if(id == 6){
            title = "서울대학교병원 MOU";
        }else if(id == 5){
            title = "레이메트릭스 국내 섬광체 최초 국산화";
        }else if(id == 4){
            title = "보조선량계 신제품 출시";
        }else if(id == 3){
            title = "캐리마와 MOU";
        }else if(id == 2){
            title = "FTA 체결";
        }else if(id == 1){
            title = "레이메트릭스 첫 수출";
        }
        content = title + " 본문 내용";

        model.put("id", id);
        model.put("title", title);
        model.put("content", content);

        return "/main/news/newsEdit";
    }
}
