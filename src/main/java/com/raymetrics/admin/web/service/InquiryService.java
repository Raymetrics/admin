package com.raymetrics.admin.web.service;

import com.raymetrics.admin.web.entity.Inquiry;
import com.raymetrics.admin.web.entity.InquiryReply;
import com.raymetrics.admin.web.model.InquiryReplyResDTO;
import com.raymetrics.admin.web.model.InquiryReqDTO;
import com.raymetrics.admin.web.model.InquiryResDTO;
import com.raymetrics.admin.web.repository.InquiryReplyRepository;
import com.raymetrics.admin.web.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final InquiryReplyRepository inquiryReplyRepository;
    @Transactional
    public int regist(HashMap<String, Object> paramMap, int adminNo){
        int inquiry_no = 0;
        try {
            Inquiry inquiry = inquiryRepository.save(new Inquiry(paramMap));
            inquiry_no = inquiry.getInquiryNo();

        }catch (Exception e){

        }
        return inquiry_no;
    }


    @Transactional(readOnly = true)
    public Page<InquiryResDTO> getList(Map<String,Object> param, int pageSize) {
        List<InquiryResDTO> result = new ArrayList<>();

        int page = Optional.ofNullable(param.get("page"))
                .map(Object::toString)
                .map(Integer::valueOf)
                .orElse(0);
        int size = pageSize;
        PageRequest pageable = PageRequest.of(page, size);
        Page<Inquiry> inquiryPage = inquiryRepository.findAllByOrderByInquiryNoDesc(pageable);

        return inquiryPage.map(InquiryResDTO::of);
    }

    @Transactional(readOnly = true)
    public InquiryResDTO getOne(int id){
        Optional<Inquiry> inquiry = inquiryRepository.findById(id);
        if(inquiry.isPresent()){
            return InquiryResDTO.of(inquiry.get());
        }else {
            return null;
        }
    }


    @Transactional
    public void reply(HashMap<String, Object> paramMap) throws Exception{
        try{
            if(paramMap!=null) {
                Optional<Inquiry> inquiry = inquiryRepository.findById(Integer.parseInt(paramMap.get("inquiryNo").toString()));
                InquiryReply inquiryReply = new InquiryReply(paramMap, inquiry.get());

                inquiryReplyRepository.save(inquiryReply);
            }else {
                throw new Exception("param 빈값임");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Boolean deleteReply(int replyNo, int inquiryNo){
        try{
            InquiryReply inquiryReply = inquiryReplyRepository.findFirstByReplyNoAndInquiry_InquiryNo(replyNo,inquiryNo);
            if(inquiryReply!=null){
                inquiryReplyRepository.delete(inquiryReply);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    public Boolean deleteInquiry(int inquiryNo){
        try{
            Inquiry inquiry = inquiryRepository.findFirstByInquiryNo(inquiryNo);
            if(inquiry!=null){
                //관련 댓글삭제
                List<InquiryReply> inquiryReplyList = inquiryReplyRepository.findAllByInquiry_InquiryNo(inquiryNo);
                if(inquiryReplyList.size()>0){
                    inquiryReplyList.forEach(inquiryReply -> inquiryReplyRepository.delete(inquiryReply));
                }

                //게시글삭제
                inquiryRepository.delete(inquiry);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional(readOnly = true)
    public Boolean checkPw(int inquiryNo, String pw){
        Inquiry inquiry = inquiryRepository.findFirstByInquiryNoAndPw(inquiryNo, pw);
        if(inquiry!=null){
            return true;
        }
        return false;
    }
}
