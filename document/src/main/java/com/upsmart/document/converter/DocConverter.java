package com.upsmart.document.converter;

import com.upsmart.document.domain.Doc;
import com.upsmart.document.dto.DocDto;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017, 银联智惠信息服务（上海）有限公司
 *
 * @author upsmart
 * @since 17-3-21
 */
@Component
public class DocConverter {
    /**
     *
     * @param domains
     * @return
     */
    public List<DocDto> toDtos(List<Doc> domains) {
        if (domains.size() == 0 || domains == null) {
            return null;
        }
        List<DocDto> dtos = new ArrayList<DocDto>();
        for (Doc domain : domains) {
            dtos.add(this.toDto(domain));
        }
        return dtos;
    }

    /**
     *
     * @param domain
     * @return
     */
    public DocDto toDto(Doc domain) {
        if (domain == null) {
            return null;
        }
        DocDto dto = new DocDto();
        dto.setId(domain.getId());
        dto.setType(domain.getType());
        dto.setDiscription(domain.getDiscription());
        dto.setName(domain.getName());
        dto.setPath(domain.getPath());

        return dto;
    }
}
