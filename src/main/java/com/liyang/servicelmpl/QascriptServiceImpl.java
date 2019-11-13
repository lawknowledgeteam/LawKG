package com.liyang.servicelmpl;

import com.liyang.service.QascriptService;
import com.liyang.util.QAService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.stereotype.Service;

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
        List<String> result = new ArrayList<>();
        try {
            TTransport transport;
            transport = new TSocket("127.0.0.1", 9090);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            QAService.Client client = new QAService.Client(protocol);
            System.out.println(question);
            String res = client.qa_result(question);
            result.add(res);
            transport.close();

        } catch (TException e) {
            e.printStackTrace();
        }
        return result;
    }


/*    @Override
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
*//*            while (line != null) {
                System.out.println(line);
                listQa.add(line);
            }*//*
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return listQa;
    }*/
}
