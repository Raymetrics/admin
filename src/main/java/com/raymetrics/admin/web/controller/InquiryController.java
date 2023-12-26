package com.raymetrics.admin.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raymetrics.admin.web.entity.Inquiry;
import com.raymetrics.admin.web.model.InquiryReplyReqDTO;
import com.raymetrics.admin.web.model.InquiryReqDTO;
import com.raymetrics.admin.web.model.InquiryResDTO;
import com.raymetrics.admin.web.model.NewsReqDTO;
import com.raymetrics.admin.web.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController {
    private final InquiryService inquiryService;

    /**
     *
     * @param paramMap
     * @param model
     * @param response
     * @return
     * @throws Exception
     * 문의글 조회 api
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String inquiry(@RequestParam HashMap<String, Object> param,
                          Model model,
                          HttpServletResponse response) throws Exception{

        //리스트불러오기
        Page<InquiryResDTO> inquiryList = inquiryService.getList(param,10);

        int pageBlock = 10;
        int page = inquiryList.getNumber()+1;

        // 현재 페이지 블록
        int currentBlock = (int) Math.ceil((double) page / pageBlock);

        // 페이지 블록 시작 페이지
        int startPage = (currentBlock - 1) * pageBlock + 1;

        // 페이지 블록 끝 페이지
        int endPage = Math.min(startPage + pageBlock - 1, inquiryList.getTotalPages());
        endPage = Math.max(endPage, 1);

        model.addAttribute("INQUIRY_LIST", inquiryList);
        model.addAttribute("START_PAGE", startPage);
        model.addAttribute("END_PAGE", endPage);

        return "/main/inquiry/inquiryBoard";
    }


    /**
     *
     * @return
     * 문의글 등록페이지로 이동
     */
    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String registInquiry(){

        return "/main/inquiry/registInquiry";
    }


    /**
     *
     * @param paramMap
     * @return
     * 문의글 등록 api
     */
    @PostMapping(value = "/save")
    public String regist(@RequestParam HashMap<String, Object> paramMap){
        int inquiry_no = inquiryService.regist( paramMap, Integer.parseInt(paramMap.get("regAdminNo").toString()));

        return "redirect:/inquiry/detail/"+inquiry_no;
    }


    /**
     *
     * @param id
     * @param model
     * @return
     * @throws Exception
     * 문의글 상세 조회 api
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String inquiryDetail(@PathVariable("id") int id, ModelMap model, Model model2) throws Exception{

        InquiryResDTO inquiryResDTO = inquiryService.getOne(id);
        if(inquiryResDTO!=null){
            model.put("inquiryNo", inquiryResDTO.getInquiryNo());
            model.put("title", inquiryResDTO.getTitle());
            model.put("content", inquiryResDTO.getContents());
            model.put("replyList", inquiryResDTO.getReplies());
            model2.addAttribute("INQUIRY", inquiryResDTO);
            model2.addAttribute("REG_ADMIN_NO","1");
        }
        return "/main/inquiry/inquiryDetail";
    }

    /**
     *
     * @param paramMap
     * @return
     * 댓글등록 api
     */
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public String reply(@RequestParam HashMap<String, Object> paramMap){
        try{
            inquiryService.reply(paramMap);
        }catch (Exception e){

        }
        return "redirect:/inquiry/detail/"+paramMap.get("inquiryNo");
    }

    /**
     *
     * @param replyNo
     * @return
     * 댓글삭제 api
     */
    @DeleteMapping("/delete/reply")
    public ResponseEntity<?> deleteInquiryReply(@RequestParam int replyNo, @RequestParam int inquiryNo){
        if(inquiryService.deleteReply(replyNo, inquiryNo)){
            return ResponseEntity.ok().body(Map.of("success", true));
        }else {
            return ResponseEntity.status(500).build();
        }
    }


    /**
     *
     * @param inquiryNo
     * @return
     * 게시글 삭제 api
     */
    @DeleteMapping("/delete/{inquiryNo}")
    public ResponseEntity<?> deleteInquiry(@PathVariable int inquiryNo){
        if(inquiryService.deleteInquiry(inquiryNo)){
            return ResponseEntity.ok().body(Map.of("success", true));
        }else {
            return ResponseEntity.status(500).build();
        }
    }


    /**
     *
     * @param pw
     * @return
     * 게시글 PW체크 api
     */
    @GetMapping("/check-pw/{inquiryNo}")
    public Boolean checkInquiryPw(@PathVariable int inquiryNo, @RequestParam String pw){
        return inquiryService.checkPw(inquiryNo,pw);
    }
}
