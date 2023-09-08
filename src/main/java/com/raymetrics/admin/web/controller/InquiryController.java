package com.raymetrics.admin.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raymetrics.admin.web.model.InquiryReqDTO;
import com.raymetrics.admin.web.model.NewsReqDTO;
import com.raymetrics.admin.web.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class InquiryController {
    private final InquiryService inquiryService;
    @RequestMapping(value = "/inquiryBoard", method = RequestMethod.GET)
    public String inquiry(@RequestParam HashMap<String, Object> paramMap,
                          ModelMap model,
                          HttpServletResponse response) throws Exception{

        model.addAttribute("INQUIRY_LIST", inquiryService.getList());
        return "/main/inquiry/inquiryBoard";
    }


    @RequestMapping(value = "/regist/inquiry", method = RequestMethod.GET)
    public String registInquiry(){
        return "/main/inquiry/registInquiry";
    }
    @PostMapping(value = "/inquiry/save")
    public String regist(@RequestParam HashMap<String, Object> paramMap,
                         @ModelAttribute InquiryReqDTO inquiryReqDTO){
        System.out.println(">>>>>>>");
        int inquiry_no = inquiryService.regist(inquiryReqDTO, paramMap, Integer.parseInt(paramMap.get("regAdminNo").toString()));
        System.out.println("성공");
        return "redirect:/inquiryDetail/"+inquiry_no;
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
