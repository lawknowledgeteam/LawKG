package com.liyang.controller;


import com.liyang.entity.Law;
import com.liyang.service.LawService;
import com.liyang.util.FileDownload;
import com.liyang.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/law")
public class LawController {
    @Autowired
    LawService lawService;

    @GetMapping("/getCount")
    public HashMap<String,Integer> getCount(){
        return lawService.getCount();
    }

    @GetMapping("/getList")
    public List<Law> getList(@RequestParam int page){
        return lawService.getList(page);
    }

    @PostMapping("/update")
    public HashMap<String,Integer> insertNew(Law law) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = lawService.insertNew(law);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }

    @PostMapping ("/upload")
    public HashMap<String,Object> addApk(MultipartFile apkFile){
        FileUpload fud = new FileUpload();
        return fud.addFile(apkFile,"D:/workspace/law/");
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadsEntity(HttpServletRequest request, @RequestParam String fileName) throws Exception {
        FileDownload fileDownload = new FileDownload();
        return  fileDownload.downloadsEntity(request,"D:/workspace/law/",fileName);
    }


}
