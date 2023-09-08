package com.raymetrics.admin.web.model;

import com.raymetrics.admin.web.entity.Inquiry;
import com.raymetrics.admin.web.entity.InquiryReply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryResDTO {
    private int inquiryNo;
    private String title;
    private String contents;
    private String writer;
    private Boolean showYn;
    private Timestamp regDt;
    private List<InquiryReply> replies;


    public static InquiryResDTO of(Inquiry inquiry,String writer){
        return new InquiryResDTO(
                inquiry.getInquiryNo(),
                inquiry.getTitle(),
                inquiry.getContents(),
                writer,
                inquiry.getShowYn(),
                inquiry.getRegDt(),
                inquiry.getReplies()
        );
    }

}
