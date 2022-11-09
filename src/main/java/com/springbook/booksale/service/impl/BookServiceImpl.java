package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.BookEntity;
import com.springbook.booksale.exception.ResourceNotFoundException;
import com.springbook.booksale.payload.BookResponse;
import com.springbook.booksale.repository.BookResponsitory;
import com.springbook.booksale.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookResponsitory bookResponsitory;
    @Override
    public BookEntity createBook(BookEntity bookEntity) {
        return bookResponsitory.save(bookEntity);
    }

    @Override
    public BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        //create Pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);

        Page<BookEntity> bookPage = bookResponsitory.findAll(pageable);
        List<BookEntity> bookLs = bookPage.getContent();

        BookResponse dataResponse = new BookResponse();
        dataResponse.setContent(bookLs);
        dataResponse.setPageNo(bookPage.getNumber());
        dataResponse.setPageSize(bookPage.getSize());
        dataResponse.setTotalElements(bookPage.getTotalElements());
        dataResponse.setTotalPages(bookPage.getTotalPages());
        dataResponse.setLast(bookPage.isLast());
        return dataResponse;
    }

    @Override
    public BookEntity getBookById(long id) {
        return bookResponsitory.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book","id",id));
    }

    @Override
    public void deleteBookById(long id) {
        BookEntity bookEntity = bookResponsitory.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book","id",id));
        bookEntity.setIsDel(false);
        bookResponsitory.save(bookEntity);
    }

    @Override
    public BookEntity updateBook(BookEntity bookEntity, long id) {
        BookEntity book = bookResponsitory.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book","id",id));
        book.setName(bookEntity.getName());
        return  bookResponsitory.save(bookEntity);
    }
}
