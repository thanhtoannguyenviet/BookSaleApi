package com.springbook.booksale.repository;

import com.springbook.booksale.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponsitory extends JpaRepository<UserEntity, Long> {
}