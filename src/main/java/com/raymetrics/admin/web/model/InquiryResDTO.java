package com.raymetrics.admin.web.model;

import com.raymetrics.admin.web.entity.Inquiry;
import com.raymetrics.admin.web.entity.InquiryReply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryResDTO {
    private int inquiryNo;
    private String title;
    private String contents;
    private String email;
    private String name;
    private String phone;
    private String company;
    private String token;
    private Date regDt;
    private List<InquiryReply> replies;


    public static InquiryResDTO of(Inquiry inquiry){
        return new InquiryResDTO(
                inquiry.getInquiryNo(),
                inquiry.getTitle(),
                inquiry.getContents(),
                inquiry.getEmail(),
                inquiry.getName(),
                inquiry.getPhone(),
                inquiry.getCompany(),
                inquiry.getToken(),
                inquiry.getRegDt(),
                inquiry.getReplies()
        );
    }

}

