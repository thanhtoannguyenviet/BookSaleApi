package com.springbook.booksale.controller;

import com.springbook.booksale.entity.BookEntity;
import com.springbook.booksale.payload.BookResponse;
import com.springbook.booksale.service.BookService;
import com.springbook.booksale.utils.AppConstants;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping
    public BookResponse getAll(@RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
                                     @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)int pageSize,
                                     @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
                                     @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_DEFAULT_SORT_DIRECTION, required = false)String sortDir
    ){
        return bookService.getAllBook(pageNo,pageSize,sortBy,sortDir);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = BookEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @PostMapping
    public ResponseEntity<BookEntity> create(@RequestBody BookEntity bookEntity){
        return new ResponseEntity<>(bookService.createBook(bookEntity), HttpStatus.CREATED);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = BookEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> update(@RequestBody BookEntity bookEntity,@PathVariable(name="id")long id){
        return ResponseEntity.ok(bookService.updateBook(bookEntity,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id")long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
