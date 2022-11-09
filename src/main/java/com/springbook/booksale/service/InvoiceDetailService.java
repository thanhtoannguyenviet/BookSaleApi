package com.springbook.booksale.service;

import com.springbook.booksale.entity.InvoicedetailEntity;

import java.util.List;

public interface InvoiceDetailService {
    InvoicedetailEntity createInvoiceDetail(InvoicedetailEntity invoicedetailEntity);
    List<InvoicedetailEntity> getAllInvoiceDetail();
    InvoicedetailEntity getInvoiceDetail(long id);
    void deleteInvoiceDetailById(long id);
    InvoicedetailEntity updateInvoiceDetail(InvoicedetailEntity authorEntity, long id);
}
