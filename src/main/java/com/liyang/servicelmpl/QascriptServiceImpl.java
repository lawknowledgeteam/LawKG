package com.liyang.servicelmpl;

import com.liyang.service.QascriptService;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/10/27 17:11
 * @Description:
 **/
@Service
public class QascriptServiceImpl implements QascriptService {
    @Override
    public List<String> getQaResult(String question) {
        List<String> listQa = new ArrayList<>();
        Process proc;
        try {
            String command = "python D:\\QAscript\\crime_qa.py  "+question ;
            System.out.println(command);
            proc = Runtime.getRuntime().exec(command);// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gbk"));
            String line = in.readLine();
            System.out.println(line);
            listQa.add(line);
/*            while (line != null) {
                System.out.println(line);
                listQa.add(line);
            }*/
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return listQa;
    }
}
