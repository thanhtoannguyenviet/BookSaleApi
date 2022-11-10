package com.springbook.booksale.repository;

import com.springbook.booksale.entity.AuthorEntity;
import com.springbook.booksale.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRespository  extends JpaRepository<BookEntity, Long> {
    @Query(value = "select b.* from book b " +
            "inner join author a on b.id_author = a.id " +
            "inner join topic t on b.id_topic = t.id " +
            "where b.name like %:keyword% or a.name like %:keyword% or t.name like %:keyword%", nativeQuery = true)
    Page<BookEntity> searchBook(@Param("keyword")String keyword, Pageable pageable);
}
