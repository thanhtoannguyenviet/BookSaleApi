package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.InvoiceEntity;
import com.springbook.booksale.exception.ResourceNotFoundException;
import com.springbook.booksale.payload.InvoiceResponse;
import com.springbook.booksale.repository.InvoiceRespository;
import com.springbook.booksale.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRespository invoiceRespository;
    @Override
    public InvoiceEntity createInvoice(InvoiceEntity invoiceEntity) {
        return invoiceRespository.save(invoiceEntity);
    }

    @Override
    public InvoiceResponse getAllInvoice(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        //create Pageable instance
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);

        Page<InvoiceEntity> invoicePage = invoiceRespository.findAll(pageable);
        List<InvoiceEntity> invoiceLs = invoicePage.getContent();

        InvoiceResponse dataResponse = new InvoiceResponse();
        dataResponse.setContent(invoiceLs);
        dataResponse.setPageNo(invoicePage.getNumber());
        dataResponse.setPageSize(invoicePage.getSize());
        dataResponse.setTotalElements(invoicePage.getTotalElements());
        dataResponse.setTotalPages(invoicePage.getTotalPages());
        dataResponse.setLast(invoicePage.isLast());
        return dataResponse;
    }

    @Override
    public InvoiceEntity getInvoiceById(long id) {
        return invoiceRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice","id",id));
    }

    @Override
    public void deleteInvoiceById(long id) {
        InvoiceEntity invoiceEntity = invoiceRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice","id",id));
        invoiceEntity.setIsDel(false);
        invoiceRespository.delete(invoiceEntity);
    }

    @Override
    public InvoiceEntity updateInvoice(InvoiceEntity invoiceEntity, long id) {
        InvoiceEntity invoice = invoiceRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice","id",id));
        invoice.setName(invoiceEntity.getName());
        invoice.setAddress(invoice.getAddress());
        invoice.setPhone(invoice.getPhone());
        return invoiceRespository.save(invoice);
    }
}
