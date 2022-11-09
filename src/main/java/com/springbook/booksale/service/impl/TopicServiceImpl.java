package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.TopicEntity;
import com.springbook.booksale.exception.ResourceNotFoundException;
import com.springbook.booksale.payload.TopicResponse;
import com.springbook.booksale.repository.TopicRespository;
import com.springbook.booksale.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRespository topicRespository;

    @Override
    public TopicEntity createTopic(TopicEntity topicEntity) {
        return topicRespository.save(topicEntity);
    }

    @Override
    public TopicResponse getAllTopics(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        //create Pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);

        Page<TopicEntity> topicPage = topicRespository.findAll(pageable);
        List<TopicEntity> topicLs = topicPage.getContent();

        TopicResponse dataResponse = new TopicResponse();
        dataResponse.setContent(topicLs);
        dataResponse.setPageNo(topicPage.getNumber());
        dataResponse.setPageSize(topicPage.getSize());
        dataResponse.setTotalElements(topicPage.getTotalElements());
        dataResponse.setTotalPages(topicPage.getTotalPages());
        dataResponse.setLast(topicPage.isLast());
        return dataResponse;
    }

    @Override
    public TopicEntity getTopicById(long id) {
        return topicRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Topic","id",id));
    }

    @Override
    public void deleteTopicById(long id) {
        TopicEntity topicEntity = topicRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Topic","id",id));
        topicEntity.setIsDel(false);
        topicRespository.save(topicEntity);
    }

    @Override
    public TopicEntity updateTopic(TopicEntity topicEntity, long id) {
        TopicEntity topic = topicRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Topic","id",id));
        topic.setName(topicEntity.getName());
        TopicEntity rs = topicRespository.save(topic);
        return rs;
    }
}
