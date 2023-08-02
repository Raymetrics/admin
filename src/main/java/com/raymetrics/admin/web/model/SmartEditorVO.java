package com.raymetrics.admin.web.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SmartEditorVO {
    private MultipartFile filedata;
    private String callback;
    private String callback_func;
}
