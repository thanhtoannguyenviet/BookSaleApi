package com.springbook.booksale.service;


import com.springbook.booksale.entity.AuthorEntity;
import com.springbook.booksale.payload.AuthorResponse;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity authorEntity);
    AuthorResponse getAllAuthor(int pageNo, int pageSize, String sortBy, String sortDir);
    AuthorEntity getAuthorById(long id);
    void deleteAuthorById(long id);
    AuthorEntity updateAuthor(AuthorEntity authorEntity, long id);

}
