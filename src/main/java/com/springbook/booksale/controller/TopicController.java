package com.springbook.booksale.controller;

import com.springbook.booksale.entity.TopicEntity;
import com.springbook.booksale.payload.TopicResponse;
import com.springbook.booksale.service.TopicService;
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
@RequestMapping("/api/v1/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping
    public TopicResponse getAll(@RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false)int pageSize,
                                      @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
                                      @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_DEFAULT_SORT_DIRECTION, required = false)String sortDir
    ){
        return topicService.getAllTopics(pageNo,pageSize,sortBy,sortDir);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = TopicEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @PostMapping
    public ResponseEntity<TopicEntity> create(@RequestBody TopicEntity topicEntity){
        return new ResponseEntity<>(topicService.createTopic(topicEntity), HttpStatus.CREATED);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = TopicEntity.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Post not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<TopicEntity> getTopicById(@PathVariable(name="id")long id){
        return ResponseEntity.ok(topicService.getTopicById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TopicEntity> updateTopic(@RequestBody TopicEntity topicEntity,@PathVariable(name="id")long id){
        TopicEntity topicRRes = topicService.updateTopic(topicEntity,id);
        return ResponseEntity.ok(topicRRes);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable(name="id")long id){
        topicService.deleteTopicById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }
}
