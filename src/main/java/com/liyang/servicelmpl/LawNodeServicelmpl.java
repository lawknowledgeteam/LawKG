package com.liyang.servicelmpl;

import com.liyang.entity.node.LawNode;
import com.liyang.repository.LawNodeRepository;
import com.liyang.service.LawNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/7/22 16:16
 * @Description:
 **/
@Service
public class LawNodeServicelmpl implements LawNodeService {
    @Autowired
    LawNodeRepository lawNodeRepository;
    private final int pageLimit = 10;

    @Override
    public List<LawNode> getLawNode(int page) {
        int skip = (page - 1) * pageLimit;
        int limit = pageLimit;
        List<LawNode> result = lawNodeRepository.getLawNode(skip,limit);
        return result;
    }

    @Override
    public List<LawNode> getLawNodeByName(String lawName, int page) {
        int skip = (page - 1) * pageLimit;
        int limit = pageLimit;
        List<LawNode> result = lawNodeRepository.getLawNodeByName(".*"+lawName+".*",skip,limit);
        return result;
    }

    @Override
    public List<LawNode> getLawNodeById(int id, int page) {
        int skip = (page - 1) * pageLimit;
        int limit = pageLimit;
        List<LawNode> result = lawNodeRepository.getLawNodeById(String.valueOf(id),skip,limit);
        return result;
    }
}
