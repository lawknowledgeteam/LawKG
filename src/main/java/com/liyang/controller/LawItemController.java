package com.liyang.lawknowledge.lawknowledge.controller;


import com.liyang.lawknowledge.lawknowledge.entity.LawItem;
import com.liyang.lawknowledge.lawknowledge.service.LawItemService;
import com.liyang.lawknowledge.lawknowledge.util.FileDownload;
import com.liyang.lawknowledge.lawknowledge.util.FileUpload;
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
