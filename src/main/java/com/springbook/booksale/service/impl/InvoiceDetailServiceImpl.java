package com.springbook.booksale.service.impl;

import com.springbook.booksale.entity.InvoicedetailEntity;
import com.springbook.booksale.exception.ResourceNotFoundException;
import com.springbook.booksale.repository.InvoiceDetailRespository;
import com.springbook.booksale.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
    @Autowired
    InvoiceDetailRespository invoiceDetailRespository;

    @Override
    public InvoicedetailEntity createInvoiceDetail(InvoicedetailEntity invoicedetailEntity) {
        return invoiceDetailRespository.save(invoicedetailEntity);
    }

    @Override
    public List<InvoicedetailEntity> getAllInvoiceDetail() {
        return invoiceDetailRespository.findAll();
    }

    @Override
    public InvoicedetailEntity getInvoiceDetail(long id) {
        return invoiceDetailRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice Detail","id",id));
    }

    @Override
    public void deleteInvoiceDetailById(long id) {
        InvoicedetailEntity invoicedetailEntity = invoiceDetailRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice Detail","id",id));
        invoicedetailEntity.setIsDel(false);
        invoiceDetailRespository.delete(invoicedetailEntity);
    }

    @Override
    public InvoicedetailEntity updateInvoiceDetail(InvoicedetailEntity invoicedetailEntity, long id) {
        InvoicedetailEntity invoice = invoiceDetailRespository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invoice Detail","id",id));
        invoicedetailEntity.setQuantity(invoicedetailEntity.getQuantity());
        return invoiceDetailRespository.save(invoice);
    }
}
