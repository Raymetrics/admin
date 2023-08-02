package com.raymetrics.admin.web.controller;

import com.mysql.jdbc.StringUtils;
import com.raymetrics.admin.web.model.SmartEditorVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class ImageUploadController {

    @RequestMapping(value="/smarteditorMultiImageUpload", method = RequestMethod.POST)
    public String smarteditorMultiImageUpload(HttpServletRequest request, SmartEditorVO smartEditorVO) throws UnsupportedEncodingException {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        String callback = smartEditorVO.getCallback();
        String callback_func = smartEditorVO.getCallback_func();
        String file_result = "";
        String result = "";
        MultipartFile multipartFile = smartEditorVO.getFiledata();

        try {
            if(multipartFile!=null && multipartFile.getSize()>0){
                System.out.println("DDDDD");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        result= "redirect:" + callback + "?callback_func="+ URLEncoder.encode(callback_func,"UTF-8")+file_result;

        return result;
    }
}
