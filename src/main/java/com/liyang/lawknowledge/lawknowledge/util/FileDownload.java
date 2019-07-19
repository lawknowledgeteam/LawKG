package com.liyang.lawknowledge.lawknowledge.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: Pan
 * @Date: 2019/7/5 16:34
 * @Description:
 **/
public class FileDownload {

    public ResponseEntity<byte[]> downloadsEntity(HttpServletRequest request,String path,String fileName) throws Exception{
        //String	path = "D:/auvres/apk/";
      //  String  fileName = "default.png";
        File file=new File(path,fileName);
        if(!file.isFile()){
            return null;
        }
        @SuppressWarnings("resource")
        InputStream input=new FileInputStream(file);
        byte[] buff=new byte[input.available()]; // 获取文件大小
        input.read(buff) ;
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus status=HttpStatus.OK;
        ResponseEntity<byte[]> entity=new ResponseEntity<byte[]>(buff,headers,status);
        return  entity;
    }


    /*public String downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName) {
         fileName = "dalaoyang.jpeg";// 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File("/Users/dalaoyang/Documents/dalaoyang.jpeg");
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }*/
}
