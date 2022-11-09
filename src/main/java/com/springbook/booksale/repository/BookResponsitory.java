package com.springbook.booksale.repository;

import com.springbook.booksale.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookResponsitory extends JpaRepository<BookEntity, Long> {

}
