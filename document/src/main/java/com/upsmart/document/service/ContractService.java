package com.upsmart.document.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Copyright (C), 2016, 银联智惠信息服务（上海）有限公司
 *
 * @author aidar
 * @version 0.0.2
 * @desc
 * @date 2016年12月20日
 */
@Service
public interface ContractService {

    // 删除合同
    public Object deleteContract(int[] cids);

    // 新增合同
    public String addContract(String path, String s, MultipartFile[] file);

}
