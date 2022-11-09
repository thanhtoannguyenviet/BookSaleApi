package com.springbook.booksale.service;

import com.springbook.booksale.entity.BookEntity;
import com.springbook.booksale.payload.BookResponse;

public interface BookService {
    BookEntity createBook(BookEntity bookEntity);
    BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir);
    BookEntity getBookById(long id);
    void deleteBookById(long id);
    BookEntity updateBook(BookEntity bookEntity, long id);
}
