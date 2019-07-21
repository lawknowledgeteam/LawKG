package com.liyang.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;

/**
 * @Author: Pan
 * @Date: 2019/7/5 14:24
 * @Description:
 **/
public class FileUpload {

    public HashMap<String,Object> addFile(MultipartFile fileUpload, String filePath){
        DateUtil dul = new DateUtil();
        HashMap<String,Object> hm = new HashMap<>();
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = dul.toName()+suffixName;
        //指定本地文件夹存储图片
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File("D:"+filePath+fileName));
            hm.put("code",1);
            hm.put("url",filePath+fileName);
            return hm;
        } catch (Exception e) {
            e.printStackTrace();
            hm.put("code",0);
            return  hm;
        }
    }
}
