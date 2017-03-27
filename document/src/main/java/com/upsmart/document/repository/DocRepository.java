package com.upsmart.document.repository;

import com.upsmart.document.domain.Doc;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-22
 */
@Repository public interface DocRepository extends PagingAndSortingRepository<Doc, Integer> {
    /**
     * @param owner
     * @return
     */
    List<Doc> findByOwner(String owner);
}