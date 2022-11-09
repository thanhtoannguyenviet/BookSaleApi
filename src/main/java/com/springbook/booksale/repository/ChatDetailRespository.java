package com.springbook.booksale.repository;

import com.springbook.booksale.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDetailRespository extends JpaRepository<TopicEntity, Long> {

}
