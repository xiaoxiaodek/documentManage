package com.upsmart.document.repository;

import com.upsmart.document.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C), 2016, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @desc
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    /**
     *
     * @param uname
     * @return
     */
    User findByUname(String uname);
}
