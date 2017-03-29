package com.upsmart.document.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-22
 */
@Service
public interface ManageService {
    //普通用户操作
    public List<Map<String, Object>> docFindByOwner(String owner);
    public List<Map<String, Object>> docFindByOwner(String owner,String seo);
    public List<Map<String, Object>> bookFindByOwner(String owner);
    public List<Map<String, Object>> bookFindByOwner(String owner,String seo);

    /**
     * @param path
     * @param s
     * @param file
     * @return
     */
    /*public String upLoad();*/
    public String upLoadDoc(String path, String s, MultipartFile[] file);
    public String upLoadBook(String path, String s, MultipartFile[] file);

    //管理员用户操作



    //公用操作
    public String deleteDoc(String owner,List<Integer> id);
    public String deleteBook(String owner,List<Integer> id);
    public String chDocDiscription(String owner,Integer id,String change);
    public String chBookDiscription(String owner,Integer id,String change);
}
