package com.raymetrics.admin.web.entity;

import com.raymetrics.admin.web.common.entity.AuditingAt;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Table(name = "news")
public class News extends AuditingAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsNo;
    private String title;
    private String contents;
    private Boolean delYn;
    private Integer regAdminNo;
    private Integer modAdminNo;

    public News(HashMap<String, Object> param){
        this.title = String.valueOf(param.get("title"));
        this.contents = String.valueOf(param.get("smartEditor"));

    }
}
