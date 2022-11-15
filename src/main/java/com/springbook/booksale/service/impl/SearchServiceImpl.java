package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.BookEntity;
import com.springbook.booksale.payload.BookResponse;
import com.springbook.booksale.repository.BookResponsitory;
import com.springbook.booksale.repository.SearchRespository;
import com.springbook.booksale.service.BookService;
import com.springbook.booksale.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SearchRespository searchRespository;

    @Autowired
    BookResponsitory bookResponsitory;

    @Override
    public BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir, String keyword) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        if(keyword.length()>0){
            Page<BookEntity> bookPage = searchRespository.searchBook(keyword,pageable);
            List<BookEntity> bookLs = bookPage.getContent();
            BookResponse dataResponse = new BookResponse();
            dataResponse.setContent(bookLs);
            dataResponse.setPageNo(bookPage.getNumber());
            dataResponse.setPageSize(bookPage.getSize());
            dataResponse.setTotalElements(bookPage.getTotalElements());
            dataResponse.setTotalPages(bookPage.getTotalPages());
            dataResponse.setLast(bookPage.isLast());
            return dataResponse;
        }else{
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
    }
}
