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
public class InquiryReplyResDTO {
    private int replyNo;
    private String contents;
    private String writer;

    public static InquiryReplyResDTO of(InquiryReply inquiryReply, String writer){
        return new InquiryReplyResDTO(
                inquiryReply.getReplyNo(),
                inquiryReply.getContents(),
                writer
        );
    }

}
