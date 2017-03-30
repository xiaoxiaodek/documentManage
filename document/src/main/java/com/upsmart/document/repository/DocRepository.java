package com.upsmart.document.repository;

import com.upsmart.document.domain.Doc;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
     * @param owner 撒旦法
     * @return
     */
    List<Doc> findByOwner(String owner);
    /**
     * @param type
     * @return
     */
    List<Doc> findByType(String type);
    /**
     * @param id
     * @return
     */
    Doc findById(Integer id);
    /**
     *
     * @param
     * @return
     */
    @Modifying
    @Query(value = "select * from doc where owner=?1 and  type=?2",nativeQuery = true)
    List<Doc> findByOwner(String owner ,String seo);
    /**
     *
     * @param
     * @return
     */
    @Modifying
    @Query(value = "select * from doc",nativeQuery = true)
    List<Doc> findAll();
}
