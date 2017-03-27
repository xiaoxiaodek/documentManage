package com.upsmart.document.converter;

import com.upsmart.document.domain.User;
import com.upsmart.document.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-16
 */
@Component
public class UserConverter {

    /**
     *
     * @param domains
     * @return
     */
    public List<UserDto> toDtos(List<User> domains) {
        if (domains.size() == 0 || domains == null) {
            return null;
        }
        List<UserDto> dtos = new ArrayList<UserDto>();
        for (User domain : domains) {
            dtos.add(this.toDto(domain));
        }
        return dtos;
    }

    /**
     *
     * @param domain
     * @return
     */
    public UserDto toDto(User domain) {
        if (domain == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setUid(domain.getUid());
        dto.setUname(domain.getUname());
        return dto;
    }
}
