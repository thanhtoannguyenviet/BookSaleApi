package com.springbook.booksale.service;
import com.springbook.booksale.entity.TopicEntity;
import com.springbook.booksale.payload.TopicResponse;

import java.util.List;

public interface TopicService {
    TopicEntity createTopic(TopicEntity topicEntity);
    TopicResponse getAllTopics(int pageNo, int pageSize, String sortBy, String sortDir);
    TopicEntity getTopicById(long id);
    void deleteTopicById(long id);
    TopicEntity updateTopic(TopicEntity topicEntity, long id);

}
