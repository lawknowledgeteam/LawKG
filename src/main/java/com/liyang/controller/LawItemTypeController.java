package com.liyang.controller;



import com.liyang.entity.Law;
import com.liyang.entity.LawItemType;
import com.liyang.service.LawItemTypeService;
import com.liyang.util.FileDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/awItemType")
public class LawItemTypeController {
    @Autowired
    LawItemTypeService lawItemTypeService;

    @GetMapping("/getCount")
    public HashMap<String,Integer> getCount(){
        return lawItemTypeService.getCount();
    }

    @GetMapping("/getList")
    public List<LawItemType> getList(@RequestParam int page){
        return lawItemTypeService.getList(page);
    }

    @PostMapping("/update")
    public HashMap<String,Integer> insertNew(LawItemType lawItemType) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result = lawItemTypeService.insertNew(lawItemType);
        if (result != 0){
            hm.put("code",1);
        }else {
            hm.put("code",0);
        }
        return hm;
    }

    @PostMapping("/getLawItemTypeName")
        public LawItemType getLawItemTypeName(@RequestParam int lawItemType){
        return lawItemTypeService.getLawItemTypeName(lawItemType);
    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadsEntity(HttpServletRequest request, @RequestParam String fileName) throws Exception {
        FileDownload fileDownload = new FileDownload();
        return  fileDownload.downloadsEntity(request,"D:/workspace/lawItemType/",fileName);
    }

}
