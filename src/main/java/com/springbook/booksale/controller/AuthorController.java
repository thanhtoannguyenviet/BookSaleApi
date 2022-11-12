package com.springbook.booksale.controller;

import com.springbook.booksale.entity.AuthorEntity;
import com.springbook.booksale.payload.AuthorResponse;
import com.springbook.booksale.service.AuthorService;
import com.springbook.booksale.utils.AppConstants;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping
    public AuthorResponse getAll(@RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
                                       @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)int pageSize,
                                       @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
                                       @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_DEFAULT_SORT_DIRECTION, required = false)String sortDir
    ){
        return authorService.getAllAuthor(pageNo,pageSize,sortBy,sortDir);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = AuthorEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @PreAuthorize("hasRole('Admin')")
    @PostMapping
    public ResponseEntity<AuthorEntity> create(@RequestBody AuthorEntity topicEntity){
        return new ResponseEntity<>(authorService.createAuthor(topicEntity), HttpStatus.CREATED);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = AuthorEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
    @PreAuthorize("hasRole('Admin')")
    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> update(@RequestBody AuthorEntity topicEntity,@PathVariable(name="id")long id){
        return ResponseEntity.ok(authorService.updateAuthor(topicEntity,id));
    }
    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id")long id){
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
