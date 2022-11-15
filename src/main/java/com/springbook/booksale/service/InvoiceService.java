package com.springbook.booksale.service;

import com.springbook.booksale.entity.InvoiceEntity;
import com.springbook.booksale.payload.InvoiceResponse;

public interface InvoiceService {
    InvoiceEntity createInvoice(InvoiceEntity invoiceEntity);
    InvoiceResponse getAllInvoice(int pageNo, int pageSize, String sortBy, String sortDir);
    InvoiceEntity getInvoiceById(long id);
    void deleteInvoiceById(long id);
    InvoiceEntity updateInvoice(InvoiceEntity invoiceEntity, long id);
    InvoiceEntity getInvoiceByEmail(String email);
}
