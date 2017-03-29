package com.upsmart.document.repository;

import com.upsmart.document.domain.Book;
import com.upsmart.document.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by upsmart on 17-3-29.
 *
 * @author upsmart
 * @since 17-3-29
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
        /**
         * @param owner
         * @return
         */
        List<Book> findByOwner(String owner);
        /**
         * @param id
         * @return
         */
        Book findById(Integer id);
        /**
         * @param type
         * @return
         */
        List<Book> findByType(String type);
        /**
         *
         * @param
         * @return
         */
        @Modifying
        @Query(value = "select * from doc where owner=?1 and  type=?2",nativeQuery = true)
        List<Book> findByOwner(String owner ,String seo);
        /**
         *
         * @param
         * @return
         */
        @Modifying
        @Query(value = "select * from Book",nativeQuery = true)
        List<Book> findAll();
}
