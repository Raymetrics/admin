package com.raymetrics.admin.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryReqDTO {
    private String name;
    private String title;
    private String contents;
    private Boolean showYn;
}
