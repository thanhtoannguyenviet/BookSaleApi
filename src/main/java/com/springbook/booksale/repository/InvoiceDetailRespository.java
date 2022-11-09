package com.springbook.booksale.repository;

import com.springbook.booksale.entity.InvoicedetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRespository extends JpaRepository<InvoicedetailEntity, Long> {
}
