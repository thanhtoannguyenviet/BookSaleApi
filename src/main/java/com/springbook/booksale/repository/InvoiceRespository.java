package com.springbook.booksale.repository;

import com.springbook.booksale.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InvoiceRespository extends JpaRepository<InvoiceEntity, Long> {
    @Query(value = "select i.* from invoice i " +
            "where i.email like %:email%", nativeQuery = true)
    InvoiceEntity getByEmail(@Param("email")String email);

}