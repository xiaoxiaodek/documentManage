package com.upsmart.document.service;

import com.upsmart.document.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.upsmart.document.domain.Doc;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-22
 */
@Service
public class ManageServiceImpl implements ManageService{
    @Autowired private DocRepository docRepository;
    public List<Map<String, Object>> findByOwner(String Owner){
        List<Doc> doc = this.docRepository.findByOwner(Owner);
        List<Map<String, Object>> returnResult = new ArrayList<>();
        for (int i = 0; i < doc.size(); i++) {
            Map<String, Object> docMap = new HashMap<>();
            docMap.put("id", doc.get(i).getId());
            docMap.put("name", doc.get(i).getName());
            docMap.put("type",doc.get(i).getType() );
            docMap.put("path", doc.get(i).getPath());
            docMap.put("discription", doc.get(i).getDiscription());
//            docMap.put("owner", doc.get(i).getOwner());
//            docMap.put("path", doc.get(i).getSendtime());
            returnResult.add(docMap);
        }
        return returnResult;

    }
}
