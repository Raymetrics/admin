package com.raymetrics.admin.web.service;

import com.raymetrics.admin.web.entity.Inquiry;
import com.raymetrics.admin.web.model.InquiryReplyResDTO;
import com.raymetrics.admin.web.model.InquiryReqDTO;
import com.raymetrics.admin.web.model.InquiryResDTO;
import com.raymetrics.admin.web.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    @Transactional
    public int regist(InquiryReqDTO inquiryReqDTO, HashMap<String, Object> paramMap, int adminNo){
        int inquiry_no = 0;
        try {
            Inquiry inquiry = inquiryRepository.save(new Inquiry(paramMap, adminNo));
            inquiry_no = inquiry.getInquiryNo();

        }catch (Exception e){

        }
        return inquiry_no;
    }


    @Transactional(readOnly = true)
    public List<Inquiry> getList(){
        List<InquiryResDTO> result = new ArrayList<>();

        List<Inquiry> inquiryList = inquiryRepository.findAllByOrderByInquiryNoDesc();
        inquiryList.forEach(inquiry -> {
            if(inquiry.getReplies()!=null){
                inquiry.getReplies().forEach(
                        inquiryReply -> inquiryReply.setWriter("reply글쓴이")
                );
            }
            result.add(InquiryResDTO.of(inquiry,"inquiry글쓴이"));
        });
        return inquiryList;
    }

}
