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
@Table(name = "INQUIRY")
public class Inquiry extends AuditingAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inquiryNo;
    private String title;
    private String name;
    private String pw;
    private String contents;
    private Boolean showYn;
    private Integer regAdminNo;
    private Integer modAdminNo;
    @OneToMany(mappedBy = "inquiry", fetch = FetchType.LAZY)
    private List<InquiryReply> replies = new ArrayList<>();

    public Inquiry(HashMap<String, Object> param){
        this.name = String.valueOf(param.get("writer"));
        this.title = String.valueOf(param.get("title"));
        this.contents = String.valueOf(param.get("smartEditor"));
        this.showYn =  Optional.ofNullable(param.get("showYn"))
                        .map(Object::toString)
                        .map(Boolean::valueOf)
                        .orElse(false);
        if (!this.showYn) {
            this.pw = String.valueOf(param.get("pw"));
        }
    }
}
