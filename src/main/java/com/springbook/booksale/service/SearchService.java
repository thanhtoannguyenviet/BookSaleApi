package com.springbook.booksale.service;

import com.springbook.booksale.entity.BookEntity;
import com.springbook.booksale.payload.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchService{
    BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir, String keywork);

}
