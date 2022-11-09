package com.springbook.booksale.repository;

import com.springbook.booksale.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRespository extends JpaRepository<InvoiceEntity, Long> {
}