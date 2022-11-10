package com.springbook.booksale.controller;

import com.springbook.booksale.payload.BookResponse;
import com.springbook.booksale.service.BookService;
import com.springbook.booksale.service.SearchService;
import com.springbook.booksale.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
    @Autowired
    SearchService searchService;
    @GetMapping
    public BookResponse getAll(@RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
                               @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)int pageSize,
                               @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
                               @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_DEFAULT_SORT_DIRECTION, required = false) String sortDir,
                               @RequestParam(value = "keyword", required = false) String keywork){
        return searchService.getAllBook(pageNo,pageSize,sortBy,sortDir,keywork);
    }
}
