package com.upsmart.document.converter;

import com.upsmart.document.domain.Book;
import com.upsmart.document.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by upsmart on 17-3-29.
 */
public class BookConverter {
    /**
     * @param domains sd
     * @return
     */
    public List<BookDto> toDtos(List<Book> domains) {
        if (domains.size() == 0 || domains == null) {
            return null;
        }
        List<BookDto> dtos = new ArrayList<BookDto>();
        for (Book domain : domains) {
            dtos.add(this.toDto(domain));
        }
        return dtos;
    }

    /**
     * @param domain
     * @return
     */
    public BookDto toDto(Book domain) {
        if (domain == null) {
            return null;
        }
        BookDto dto = new BookDto();
        dto.setId(domain.getId());
        dto.setType(domain.getType());
        dto.setDiscription(domain.getDiscription());
        dto.setName(domain.getName());
        dto.setPath(domain.getPath());

        return dto;
    }
}
