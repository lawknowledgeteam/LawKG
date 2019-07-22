package com.liyang.controller;


import com.liyang.entity.LawItem;
import com.liyang.service.LawItemService;
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
@RequestMapping("/lawitem")
public class LawItemController {

    @Autowired
    LawItemService lawItemService;

    @GetMapping("/getList")
    public List<LawItem> getList(@RequestParam int page) {
        return lawItemService.getList(page);
    }

    @GetMapping("/getLawItem")
    public LawItem getLawItem(@RequestParam int lawItemID){
        return lawItemService.getLawItem(lawItemID);
    }

    @GetMapping("/getCount")
    public HashMap<String, Integer> getCount() {

        return  lawItemService.getCount();
    }

    @PostMapping("/update")
    public HashMap<String,Integer> insertNew(LawItem lawItem) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = lawItemService.insertNew(lawItem);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }

    @PostMapping("/upload")
    public HashMap<String,Object> addApk(MultipartFile apkFile){
        FileUpload fud = new FileUpload();
        return fud.addFile(apkFile,"D:/workspace/lawitem/");
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadsEntity(HttpServletRequest request, @RequestParam String fileName) throws Exception {
        FileDownload fileDownload = new FileDownload();
        return  fileDownload.downloadsEntity(request,"D:/workspace/lawitem/",fileName);
    }


}
