package com.springbook.booksale.repository;

import com.springbook.booksale.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRespository extends JpaRepository<AuthorEntity, Long> {
}
