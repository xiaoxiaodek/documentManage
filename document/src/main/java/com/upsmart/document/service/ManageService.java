package com.upsmart.document.service;

import org.springframework.stereotype.Service;

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
    public List<Map<String, Object>> findByOwner(String owner);

    public String upLoad();
}
