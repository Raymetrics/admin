package com.raymetrics.admin.web.model;

import com.raymetrics.admin.web.entity.News;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewsResDTO {
    private int newsNo;
    private String title;
    private String contents;
    private String regAdminName;
    private Date regDt;


    public static NewsResDTO of(News news){
        return new NewsResDTO(
                news.getNewsNo(),
                news.getTitle(),
                news.getContents(),
                news.getRegAdminName(),
                news.getRegDt()
        );
    }

}
