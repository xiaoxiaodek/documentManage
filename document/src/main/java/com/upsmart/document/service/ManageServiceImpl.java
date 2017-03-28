package com.upsmart.document.service;
import com.upsmart.document.repository.DocRepository;
import com.upsmart.document.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.upsmart.document.domain.Doc;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-22
 */
@Service
public class ManageServiceImpl implements ManageService{
    @Autowired private DocRepository docRepository;
    private static Logger logger = LoggerFactory.getLogger(ManageServiceImpl.class);
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
    public List<Map<String, Object>> findByOwner(String Owner,String seo){
        List<Doc> doc = this.docRepository.findByOwner(Owner,seo);
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
    public String upLoadDoc(String path, String s, MultipartFile[] file){
        String result="";
        Map<String, Object> map = new HashMap<>();
        try {
            map = JSONUtil.jsonToObject(s);
        } catch (Exception e1) {
            logger.error("获取上传文件数据失败");
            result = "获取前台数据失败";
            e1.printStackTrace();
        }
        if (null != file) {
            for (int i = 0; i < file.length; i++) {
                String fname = file[i].getOriginalFilename();
                File targetFile = new File(path, fname);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                try {
                    file[i].transferTo(targetFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    result="传输文件出错（不合法操作）";
                } catch (IOException e) {
                    e.printStackTrace();
                    result="传输文件出错（io端口）";
                }
                Doc doc=new Doc();
                doc.setName(file[0].getOriginalFilename());
                doc.setOwner((String) map.get("user"));
                doc.setDiscription((String) map.get("info"));
                doc.setPath(path);
                doc.setType(file[0].getContentType());
                try {
                    docRepository.save(doc);
                }catch (Exception e){
                    result="存储文件信息出错";
                }
            }
        }
        return result;

    }
    public String deleteDoc(String owner,List<Integer> id){
        String result="";
        try{
            for(Integer i:id){
            this.docRepository.delete(this.docRepository.findById(i));
            }
        }catch (Exception e){
            result="出错了！";
        }
        return result;
    }

    public String chDiscription(String owner,Integer id,String change){
        String result="";
        try {
            Doc doc = this.docRepository.findById(id);
            doc.setDiscription(change);
            docRepository.save(doc);
        }catch(Exception e){
            result="出错啦！";
        }
        return result;
    }


}


