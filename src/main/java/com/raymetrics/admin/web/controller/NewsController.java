package com.raymetrics.admin.web.controller;

import com.raymetrics.admin.web.entity.News;
import com.raymetrics.admin.web.model.NewsResDTO;
import com.raymetrics.admin.web.service.FileUploadService;
import com.raymetrics.admin.web.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Case;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    private final FileUploadService fileUploadService;

    @RequestMapping(value= "/news/list", method = RequestMethod.GET)
    public String news(@RequestParam Map<String,Object> param, Model model) {

        Page<NewsResDTO> newsList = newsService.getList(param);

        int pageBlock = 10;
        int page = newsList.getNumber()+1;

        // 현재 페이지 블록
        int currentBlock = (int) Math.ceil((double) page / pageBlock);

        // 페이지 블록 시작 페이지
        int startPage = (currentBlock - 1) * pageBlock + 1;

        // 페이지 블록 끝 페이지
        int endPage = Math.min(startPage + pageBlock - 1, newsList.getTotalPages());
        endPage = Math.max(endPage, 1);

        model.addAttribute("NEWS_LIST", newsList);
        model.addAttribute("START_PAGE", startPage);
        model.addAttribute("END_PAGE", endPage);


        return "/main/news/news";
    }

    /**
     * 상세페이지
     * @param newsNo
     * @param model
     * @return
     */
    @RequestMapping(value= "/news/detail/{newsNo}", method = RequestMethod.GET)
    public String inquiry(@PathVariable("newsNo") int newsNo, Model model, @RequestParam Map<String,Object> param) {

        NewsResDTO news = newsService.getOne(newsNo);
        model.addAttribute("NEWS",news);

        return "/main/news/newsDetail";
    }

    @RequestMapping(value = "/news/regist", method = RequestMethod.GET)
    public String registNews(){
        return "/main/news/newsRegist";
    }

    @PostMapping("/news")
    public String saveNews(@RequestParam HashMap<String, Object> paramMap, RedirectAttributes attributes) throws IOException {
        News news = newsService.regist(paramMap);
        fileUploadService.uploadImgToCloud(news);
        return "redirect:/news/list";
    }


//    @RequestMapping(value = "/newsDetail/{id}", method = RequestMethod.GET)
//    public String newsDetail(@PathVariable("id") Long id, ModelMap model) throws Exception{
//        String title = "";
//        String content = "";
//        String date = "";
//        if (id == 7) {
//            title = "쿼리연구소 수출";
//        }else if(id == 6){
//            title = "서울대학교병원 MOU";
//        }else if(id == 5){
//            title = "레이메트릭스 국내 섬광체 최초 국산화";
//        }else if(id == 4){
//            title = "보조선량계 신제품 출시";
//        }else if(id == 3){
//            title = "캐리마와 MOU";
//        }else if(id == 2){
//            title = "FTA 체결";
//        }else if(id == 1){
//            title = "레이메트릭스 첫 수출";
//        }
//        content = title + " 본문 내용";
//
//        model.put("id", id);
//        model.put("title", title);
//        model.put("content", content);
//
//        return "/main/news/newsDetail";
//    }

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
