package com.springbook.booksale.repository;

import com.springbook.booksale.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRespository extends JpaRepository<TopicEntity, Long> {
}
